package edu.pja.mas.s19183.mas.gui.controllers;

import edu.pja.mas.s19183.mas.gui.view.PassengerRouteListView;
import edu.pja.mas.s19183.mas.model.PassengerRoute;
import edu.pja.mas.s19183.mas.model.Route;
import edu.pja.mas.s19183.mas.model.Ticket;
import edu.pja.mas.s19183.mas.service.PassengerRouteService;
import edu.pja.mas.s19183.mas.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PassengerRouteListController {
    private final PassengerRouteListView view;
    private final PassengerRouteService passengerRouteService;
    private final TicketService ticketService;
    private final TicketListController ticketListController;
    private MainWindowController mainWindowController;
   

    public void showGUI(MainWindowController mwc) {
        mainWindowController = mwc;
        updateRoutesFromDB();
        mainWindowController.repaintGUI();
        mainWindowController.showView(view.getMainPanel());

    }

    @PostConstruct
    public void initListeners() {
        view.getPassengerRouteList().addListSelectionListener(e -> {
            if (view.getPassengerRouteList().getSelectedValue() == null) return;
            PassengerRoute selectedPassengerRoute = (PassengerRoute) view.getPassengerRouteList().getSelectedValue();
            view.getSelectedRouteValue().setText(selectedPassengerRoute.getRouteNumber());
        });

        view.getShowRouteTickets().addActionListener(e -> {
            if (view.getPassengerRouteList().getSelectedValue() == null) return;
            PassengerRoute selectedPassengerRoute = (PassengerRoute) view.getPassengerRouteList().getSelectedValue();
            view.getSelectedRouteValue().setText(selectedPassengerRoute.getRouteNumber());
            List<Ticket> ticketsByRoute = ticketService.getTicketsByRouteId(selectedPassengerRoute.getId());
            ticketListController.showGUI(mainWindowController, ticketsByRoute);
        });
    }



    private void updateRoutesFromDB() {
        List<Route> routes = passengerRouteService.getAllRoutes();
        DefaultListModel<Route> model = (DefaultListModel<Route>) view.getPassengerRouteList().getModel();
        model.removeAllElements();
        routes.forEach(model :: addElement);

    }

}
