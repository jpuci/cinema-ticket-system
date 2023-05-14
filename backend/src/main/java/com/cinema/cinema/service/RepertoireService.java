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

    public List<Repertoire> getSeancesTodayByMovieId(String id) throws NumberFormatException {
        List<Repertoire> result = new ArrayList<>();
        long idLong = Long.parseLong(id);
        Optional<List<Repertoire>> allSeancesOptional = repertoireRepository.findAllByMovieId(idLong);
        if (allSeancesOptional.isPresent()) {
            result = allSeancesOptional
                    .get()
                    .stream()
                    .filter(r -> Objects.equals(r.getSeanceDate(), LocalDate.now()))
                    .toList();
        }
        return result;
    }

    public Optional<List<Repertoire>> getRepertoireByMovieId(String id) throws NumberFormatException {
        long idLong = Long.parseLong(id);
        return repertoireRepository.findAllByMovieId(idLong);
    }
}
