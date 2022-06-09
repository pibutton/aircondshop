package hu.nye.progkor.aircondshop.controller;

import hu.nye.progkor.aircondshop.model.TermekLista;
import hu.nye.progkor.aircondshop.service.TermekListaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/termek")
public class TermekListaRestController {

    private final TermekListaService termekListaService;

    public TermekListaRestController(final TermekListaService termekListaService){
        this.termekListaService = termekListaService;
    }

    @GetMapping
    public List<TermekLista> getAllTermekListak() {
    return termekListaService.getAllTermekLista();
    }

    @GetMapping("/{id}")
    TermekLista getTermekLista(final @PathVariable("id") Long id){
    return termekListaService.getTermekLista(id);
    }

    @PostMapping
    TermekLista createTermekLista(final @RequestBody TermekLista termekLista){
        return termekListaService.createTermekLista(termekLista);
    }

    @PutMapping("/{id}")
    TermekLista updateTermekLista(final @PathVariable Long id, final @RequestBody TermekLista termekListaChange){
        return termekListaService.updateTermekLista(id,termekListaChange);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTermekLista(final @PathVariable Long id) {
        termekListaService.deleteTermekLista(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
