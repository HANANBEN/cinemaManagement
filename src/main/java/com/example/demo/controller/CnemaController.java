package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entities.Cinema;
import com.example.demo.services.CinemaService;

@Controller
public class CnemaController {
    private CinemaService cs;

    // Injectez le service CinemaService via le constructeur
    public CnemaController(CinemaService cs) {
        this.cs = cs;
    }

    @GetMapping("/cinema")
    public String listcinemas(Model model) {
        List<Cinema> cinemas = cs.getAllCinemas();
        System.out.println("Nombre de cinémas récupérés : " + cinemas.size());
        model.addAttribute("list",cinemas);
        return "cin";
    }

}