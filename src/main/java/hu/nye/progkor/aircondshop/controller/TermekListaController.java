package hu.nye.progkor.aircondshop.controller;

import hu.nye.progkor.aircondshop.model.TermekLista;
import hu.nye.progkor.aircondshop.model.exception.NotFoundException;
import hu.nye.progkor.aircondshop.service.TermekListaService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/termek-lista")
public class TermekListaController {

    private final TermekListaService termekListaService;

    public TermekListaController(final TermekListaService termekListaService) {
        this.termekListaService = termekListaService;
    }

    @GetMapping
    public String getAllTermekLista(final Model model) {
        final List<TermekLista> termekListak = termekListaService.getAllTermekListak();
        model.addAttribute("termekListak", termekListak);
        return "termek/list";
    }

    @GetMapping("/{id}")
    public String getTermekLista(final Model model, final @PathVariable Long id) {
        final TermekLista termekLista = termekListaService.getTermekLista(id);
        model.addAttribute("termekLista", termekLista);
        return "termek/edit";
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createTermekLista(final Model model,
                                    final @RequestParam(value = "id", required = false) Long id,
                                    final TermekLista termekListaChange){
        final TermekLista termekLista = termekListaService.updateTermekLista(id, termekListaChange);
        model.addAttribute("termekLista", termekLista);
        return "termek/edit";
    }

    @GetMapping("/create")
    public String createTermekListaForm(final Model model) {

        return "termek/create";
        ;
    }

    @PostMapping("/create")
    public String createTermekLista(final Model model, final TermekLista termekLista) {
        final TermekLista savedTermekLista = termekListaService.createTermekLista(termekLista);
        model.addAttribute("termekLista", savedTermekLista);

        return "termek/edit";
    }

    @GetMapping("/{id/delete}")
    public String deleteTermekLista(final Model model, final @PathVariable("id")Long id) {
        try {
            termekListaService.deleteTermekLista(id);
        } catch (NotFoundException e) {
            // Ignored nem érdekel minket hogy ha nem létezik az adott erőforrás
        }
        final List<TermekLista> termekListak = termekListaService.getAllTermekListak();
        model.addAttribute("termekListak", termekListak);
        return "termek/list";
    }
}
