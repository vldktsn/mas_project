package edu.pja.mas.s19183.mas.service;

import edu.pja.mas.s19183.mas.repository.TrainRepository;
import edu.pja.mas.s19183.mas.model.Train;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainService {
    private final TrainRepository trainRepository;

    public List<Train> getAllTrains() {
        Iterable<Train> all = trainRepository.findAll();
        List<Train> res = new ArrayList<>();
        all.forEach(res :: add);
        return res;
    }
}
