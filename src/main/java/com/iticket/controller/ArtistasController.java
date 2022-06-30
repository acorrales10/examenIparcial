/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iticket.controller;

import com.iticket.entity.Artistas;
import com.iticket.service.IArtistasService;
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
public class ArtistasController {
    
    @Autowired
    private IArtistasService artistasService;

       @GetMapping("/artistas")
    public String index(Model model) {
        List<Artistas> listaArtistas = artistasService.ListArtistas();
        model.addAttribute("titulo", "Tabla Artistas");
        model.addAttribute("artistas", listaArtistas);
        return "artistas";
    }

    @GetMapping("/artistasN")
    public String crearArtistas(Model model) {
        model.addAttribute("artista", new Artistas());
        return "artista-crear";

    }

    @PostMapping("/saveA")
    public String guardarArtistas(@ModelAttribute Artistas artistas) {
        artistasService.saveArtistas(artistas);
        return "redirect:/artistas";
    }

    @GetMapping("/editArtistas/{id}")
    public String editarArtista(@PathVariable("id") Long idArtista, Model model) {
        Artistas artistas = artistasService.getArtistasById(idArtista);
        List<Artistas> listaArtistas = artistasService.ListArtistas();
        model.addAttribute("Artistas", artistas);
        model.addAttribute("artistas", listaArtistas);
        return "artista-crear";

    }

    @GetMapping("/deleteA/{id}")
    public String eliminarArtistas(@PathVariable("id") Long idartistas, Model model) {
        artistasService.delete(idartistas);
        return "redirect:/artistas";

    }
    
    
    
    
}
