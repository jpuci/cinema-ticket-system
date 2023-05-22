package com.cinema.cinema.service;

import com.cinema.cinema.model.Row;
import com.cinema.cinema.repository.RowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RowService {

    private final RowRepository rowRepository;

    @Autowired
    public RowService(RowRepository rowRepository) {
        this.rowRepository = rowRepository;
    }

    public Optional<List<Row>> getRowsByHallId(String id) throws NumberFormatException {
        long idLong = Long.parseLong(id);
        return rowRepository.findAllByHallIdOrderByRowName(idLong);
    }

}
