package com.cinema.cinema.service;

import com.cinema.cinema.model.Row;
import com.cinema.cinema.model.TakenSeat;
import com.cinema.cinema.repository.RowRepository;
import com.cinema.cinema.repository.TakenSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TakenSeatService {

    private final TakenSeatRepository takenSeatRepository;

    @Autowired
    public TakenSeatService(TakenSeatRepository takenSeatRepository) {
        this.takenSeatRepository = takenSeatRepository;
    }

    public Optional<List<TakenSeat>> getTakenSeatsByRepertoireId(String id) throws NumberFormatException {
        long idLong = Long.parseLong(id);
        return takenSeatRepository.findAllByRepertoireId(idLong);
    }

}
