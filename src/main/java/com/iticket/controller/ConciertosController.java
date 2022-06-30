/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iticket.controller;

import com.iticket.entity.Artistas;
import com.iticket.entity.Conciertos;
import com.iticket.service.ConciertosService;
import com.iticket.service.IArtistasService;
import com.iticket.service.IConciertosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author AMCG_
 */

@Controller
public class ConciertosController {
    
    @Autowired
    private IConciertosService conciertosService;

    @Autowired
    private IArtistasService artistasService;
    
       @GetMapping("/conciertos")
    public String index(Model model) {
        List<Conciertos> listaConciertos = conciertosService.getallConciertos();
        model.addAttribute("titulo", "Tabla conciertos");
        model.addAttribute("conciertos", listaConciertos);
        return "conciertos";
    }

    @GetMapping("/conciertosN")
    public String crearPersona(Model model) {

        List<Artistas> listaartistas = artistasService.ListArtistas();
        model.addAttribute("concierto", new Conciertos());
        model.addAttribute("artistas", listaartistas);
        return "crear";

    }

    @PostMapping("/save")
    public String guardarConcierto(@ModelAttribute Conciertos concierto) {
        conciertosService.saveConciertos(concierto);
        return "redirect:/conciertos";
    }

    @GetMapping("/editConcierto/{id}")
    public String editarConcierto(@PathVariable("id") Long idConcierto, Model model) {
        Conciertos concierto = conciertosService.getConciertosById(idConcierto);
        List<Artistas> listaArtistas = artistasService.ListArtistas();
        model.addAttribute("concierto", concierto);
        model.addAttribute("artistas", listaArtistas);
        return "crear";

    }

    @GetMapping("/delete/{id}")
    public String eliminarConcierto(@PathVariable("id") Long idconcierto, Model model) {
        conciertosService.delete(idconcierto);
        return "redirect:/conciertos";

    }
    
    
    
    
}
