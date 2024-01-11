package com.example.springbootthymeleafweb.controller;

import com.example.springbootthymeleafweb.model.Llibre;
import com.example.springbootthymeleafweb.repository.LlibreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class LlibreController {

    private LlibreRepository repository;

    public LlibreController(LlibreRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/llibres")
    public String getLlibres(Model model) {
        List<Llibre> llibres = repository.findAll();
        model.addAttribute("llibres", llibres);
        return "mostrar";
    }


}
