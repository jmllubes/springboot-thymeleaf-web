package com.example.springbootthymeleafweb.controller;

import com.example.springbootthymeleafweb.model.Llibre;
import com.example.springbootthymeleafweb.repository.LlibreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class LlibreController {

    private LlibreRepository repository;

    public LlibreController(LlibreRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/llibres")
    public String getLlibres(Model model, @RequestParam(name = "error", required = false) String error) {
        List<Llibre> llibres = repository.findAll();
        model.addAttribute("llibres", llibres);
        model.addAttribute("error", error); // Agrega el mensaje de error al modelo
        return "mostrar";

    }
        @GetMapping("/esborrar/{isbn}")
    public String esborrarLlibre(@PathVariable("isbn") String isbn, Model model){
        try{
            repository.deleteById(isbn);
        } catch (Exception e) {
            String error = "No s'ha pogut esborrar el llibre amb isbn: " + isbn;
            return "redirect:/llibres?error=" + URLEncoder.encode(error, StandardCharsets.UTF_8);
        }
        return "redirect:/llibres";
    }


}
