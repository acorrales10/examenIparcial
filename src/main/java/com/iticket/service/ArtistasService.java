/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iticket.service;

import com.iticket.entity.Artistas;
import com.iticket.repository.ArtistasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AMCG_
 */
@Service
public class ArtistasService implements IArtistasService{
    
     @Autowired
    private ArtistasRepository artistasRepository;

    @Override
    public List<Artistas> ListArtistas() {
         return (List<Artistas>)artistasRepository.findAll();
    }

    @Override
    public Artistas getArtistasById(long id) {
        return artistasRepository.findById(id).orElse(null);
    }

    @Override
    public void saveArtistas(Artistas artistas) {
        artistasRepository.save(artistas);
    }

    @Override
    public void delete(long id) {
        artistasRepository.deleteById(id);
    }
    
}
