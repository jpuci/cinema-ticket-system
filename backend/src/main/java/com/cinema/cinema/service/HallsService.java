package com.cinema.cinema.service;

import com.cinema.cinema.model.Halls;
import com.cinema.cinema.repository.HallsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HallsService {

    private final HallsRepository hallsRepository;

    @Autowired
    public HallsService(HallsRepository hallsRepository) {
        this.hallsRepository = hallsRepository;
    }

    public Optional<List<Halls>> getHallById(String id) throws NumberFormatException {
        long idLong = Long.parseLong(id);
        return hallsRepository.findAllByHallIdOrderByRowName(idLong);
    }

}
