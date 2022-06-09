package hu.nye.progkor.aircondshop.service;

import hu.nye.progkor.aircondshop.model.TermekLista;
import java.util.List;

public interface TermekListaService {

    List<TermekLista> getAllTermekListak();

    TermekLista getTermekLista(Long id);

    TermekLista createTermekLista(TermekLista termekLista);

    TermekLista updateTermekLista(Long id, TermekLista TermekListaChange);

    void deleteTermekLista(Long id);

}
