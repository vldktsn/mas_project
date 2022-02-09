package edu.pja.mas.s19183.mas.gui.controllers;

import edu.pja.mas.s19183.mas.gui.view.PassengerRouteListView;
import edu.pja.mas.s19183.mas.gui.view.TicketListView;
import edu.pja.mas.s19183.mas.model.PassengerRoute;
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
public class TicketListController {
    private final TicketListView view;
    private final TicketService ticketService;
    private MainWindowController mainWindowController;

    public void showGUI(MainWindowController mainWindowController, List<Ticket> tickets) {
        showTicketsByRoute(tickets);
        mainWindowController.repaintGUI();
        mainWindowController.showView(view.getMainPanel());
    }

    public void showGUI(MainWindowController mainWindowController) {
        updateTicketsFromDB();
        mainWindowController.showView(view.getMainPanel());
    }

    @PostConstruct
    public void initListeners() {
        view.getTicketsList().addListSelectionListener(e -> {
            if (view.getTicketsList().getSelectedValue() == null) return;
            Ticket selectedTicket = (Ticket) view.getTicketsList().getSelectedValue();
            view.getSelectedTicketValue().setText(selectedTicket.getTicketNumber());
            view.getSelectedRouteValue().setText(selectedTicket.getSoldTickets().getRouteNumber());
        });
    }

    public void showTicketsByRoute(List<Ticket> tickets) {
        DefaultListModel<Ticket> model = (DefaultListModel<Ticket>) view.getTicketsList().getModel();
        model.removeAllElements();
        tickets.forEach(model::addElement);
    }

    private void updateTicketsFromDB() {
        List<Ticket> tickets = ticketService.getAllTickets();
        DefaultListModel<Ticket> model = (DefaultListModel<Ticket>) view.getTicketsList().getModel();
        model.removeAllElements();
        tickets.forEach(model::addElement);
    }
}
