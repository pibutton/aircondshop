package hu.nye.progkor.aircondshop.service;

import hu.nye.progkor.aircondshop.model.Termek;
import java.util.List;

public interface TermekService {

    List<Termek> getAllTermek();

    Termek getTermek(Long id);

    Termek createTermek(Termek termek);

    Termek updateTermek(Long id, Termek TermekChange);

    void deleteTermek(Long id);

}
