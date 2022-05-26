package hu.nye.progkor.aircondshop.controller;

import hu.nye.progkor.aircondshop.model.Termek;
import hu.nye.progkor.aircondshop.service.TermekService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/termek")
public class TermekRestController {

    private final TermekRestController termekService;

    public TermekRestController(final TermekService termekService){
        this.termekService = termekService;

    }

    @GetMapping
    public List<Termek> getAllTermek() {
    return termekService.getAllTermek();
}

@GetMapping("/{id}")
Termek getTermek(@PathVariable("id") final Long id){
    return termekService.getTermek(id);
    }
}
