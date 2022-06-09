package hu.nye.progkor.aircondshop.service.impl;

import hu.nye.progkor.aircondshop.model.EnergiaBesorolas;
import hu.nye.progkor.aircondshop.model.Marka;
import hu.nye.progkor.aircondshop.model.TermekLista;
import hu.nye.progkor.aircondshop.model.exception.NotFoundException;
import hu.nye.progkor.aircondshop.service.TermekListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TermekListaServiceImpl implements TermekListaService {

    private static final List<TermekLista> DATA_BASE = new ArrayList<>();

    @Autowired
    public TermekListaServiceImpl() {
        DATA_BASE.add(new TermekLista(1L, Marka.Daikin, "200",EnergiaBesorolas.Aplusz, "wi-fi"));
        DATA_BASE.add(new TermekLista(2L, Marka.Panasonic, "100",EnergiaBesorolas.Apluszplusz, "0"));
    }
    public TermekListaServiceImpl(final List<TermekLista> termekListak) {
        DATA_BASE.addAll(termekListak);
    }


    @Override
    public List<TermekLista> getAllTermekLista() {
        return Collections.unmodifiableList(DATA_BASE);
    }

    @Override
    public TermekLista getTermekLista(final Long id) {
        return DATA_BASE.stream()
        .filter(termekLista -> termekLista.getId().equals(id))
        .findFirst()
        .orElseThrow(NotFoundException::new);

    }

    @Override
    public TermekLista createTermekLista(final TermekLista termekLista) {
        termekLista.setId(getNextId());
        DATA_BASE.add(termekLista);
        return termekLista;
    }

    @Override
    public TermekLista updateTermekLista(final Long id, final TermekLista termekListaChange) {
        final TermekLista termekLista = getTermekLista(id);
        termekLista.setMarka(termekListaChange.getMarka());
        termekLista.setAr(termekListaChange.getAr());
        termekLista.setEnergiabesorolas(termekListaChange.getEnergiabesorolas());
        termekLista.setKiegeszitok(termekListaChange.getKiegeszitok());
        return termekLista;
    }

    @Override
    public void deleteTermekLista(final Long id) {
        final TermekLista termekLista = getTermekLista(id);
        DATA_BASE.remove(termekLista);
    }

    private long getNextId() {
        return getLastId() + 1L;
    }



    private long getLastId() {
        return DATA_BASE.stream()
                .mapToLong(TermekLista::getId)
                .max()
                .orElse(0);
    }

}
