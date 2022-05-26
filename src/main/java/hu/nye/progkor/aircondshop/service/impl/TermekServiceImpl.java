package hu.nye.progkor.aircondshop.service.impl;

import hu.nye.progkor.aircondshop.model.EnergiaBesorolas;
import hu.nye.progkor.aircondshop.model.Marka;
import hu.nye.progkor.aircondshop.model.Termek;
import hu.nye.progkor.aircondshop.model.exception.NotFoundException;
import hu.nye.progkor.aircondshop.service.TermekService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TermekServiceImpl implements TermekService {

    private static final List<Termek> DATA_BASE = new ArrayList<>();

    static {
          DATA_BASE.add(new Termek(1L, Marka.Daikin, "200",EnergiaBesorolas.Aplusz, "wi-fi"));
          DATA_BASE.add(new Termek(2L, Marka.Panasonic, "100",EnergiaBesorolas.Apluszplusz, "0"));
    }


    @Override
    public List<Termek> getAllTermek() {
        return Collections.unmodifiableList(DATA_BASE);
    }

    @Override
    public Termek getTermek(final Long id) {
        return DATA_BASE.stream()
        .filter(termek -> termek.getId().equals(id))
        .findFirst()
        .orElseThrow(NotFoundException::new);

    }

    @Override
    public Termek createTermek(final Termek termek) {
        termek.setId(getNextId());
        DATA_BASE.add(termek);
        return termek;
    }

    @Override
    public Termek updateTermek(final Long id, final Termek termekChange) {
        final Termek termek = getTermek(id);
        termek.setMarka(termekChange.getMarka());
        termek.setEnergiabesorolas(termekChange.getEnergiabesorolas());
        termek.setKiegeszitok(termekChange.getKiegeszitok());
        return termek;
    }

    @Override
    public void deleteTermek(Long id) {
        final Termek termek = getTermek(id);
        DATA_BASE.remove(termek);
    }

    private long getNextId() {
        return getLastId() + 1L;
    }



    private long getLastId() {
        return DATA_BASE.stream()
                .mapToLong(Termek::getId)
                .max()
                .orElse(0);
    }

}
