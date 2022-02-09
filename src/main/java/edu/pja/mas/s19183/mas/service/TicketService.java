package edu.pja.mas.s19183.mas.service;

import edu.pja.mas.s19183.mas.model.PassengerRoute;
import edu.pja.mas.s19183.mas.repository.TicketRepository;
import edu.pja.mas.s19183.mas.model.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

//    public List<Ticket> getTicketsByRouteId(long routeId) {
//        return ticketRepository.findTicketsByPassengerRouteId(routeId);
//    }

    public List<Ticket> getSoldTickets(PassengerRoute passengerRoute){
        return ticketRepository.findBySoldTickets(passengerRoute);
    }

    public List<Ticket> getAllTickets() {
        Iterable<Ticket> all = ticketRepository.findAll();
        List<Ticket> res = new ArrayList<>();
        all.forEach(res :: add);
        return res;
    }
}
