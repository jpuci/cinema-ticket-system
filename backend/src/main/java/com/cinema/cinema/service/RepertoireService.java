package com.cinema.cinema.service;

import com.cinema.cinema.model.Repertoire;
import com.cinema.cinema.repository.RepertoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class RepertoireService {

    private final RepertoireRepository repertoireRepository;

    @Autowired
    public RepertoireService(RepertoireRepository repertoireRepository) {
        this.repertoireRepository = repertoireRepository;
    }

    public List<Repertoire> getRepertoireTodayByMovieId(String id) throws NumberFormatException {
        List<Repertoire> result = new ArrayList<>();
        long idLong = Long.parseLong(id);
        Optional<List<Repertoire>> allScreeningsOptional = repertoireRepository.findAllByMovieId(idLong);
        if (allScreeningsOptional.isPresent()) {
            result = allScreeningsOptional
                    .get()
                    .stream()
                    .filter(r -> Objects.equals(r.getScreeningDate(), LocalDate.now()))
                    .toList();
        }
        return result;
    }

    public List<Repertoire> getRepertoireToday() throws NumberFormatException {
        List<Repertoire> result = new ArrayList<>();
        List<Repertoire> repertoire= repertoireRepository.findAll();
        result = repertoire
                .stream()
                .filter(r -> Objects.equals(r.getScreeningDate(), LocalDate.now()))
                .toList();
        return result;
    }

    public Optional<List<Repertoire>> getRepertoireByMovieId(String id) throws NumberFormatException {
        long idLong = Long.parseLong(id);
        return repertoireRepository.findAllByMovieId(idLong);
    }

    public Optional<Repertoire> getRepertoireById(String id) throws NumberFormatException {
        long idLong = Long.parseLong(id);
        return repertoireRepository.findById(idLong);
    }
}
