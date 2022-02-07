package edu.pja.mas.s19183.mas.service;

import edu.pja.mas.s19183.mas.model.PassengerRoute;
import edu.pja.mas.s19183.mas.repository.PassengerRouteRepository;
import edu.pja.mas.s19183.mas.model.Route;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerRouteService {
    private final PassengerRouteRepository passengerRouteRepository;

    public List<Route> getAllRoutes() {
        Iterable<PassengerRoute> all = passengerRouteRepository.findAll();
        List<Route> res = new ArrayList<>();
        all.forEach(res :: add);
        return res;
    }

}
