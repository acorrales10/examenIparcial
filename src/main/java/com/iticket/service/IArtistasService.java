/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iticket.service;

import com.iticket.entity.Artistas;
import com.iticket.entity.Conciertos;
import java.util.List;

/**
 *
 * @author AMCG_
 */
public interface IArtistasService {
    
    public List<Artistas> ListArtistas();  
    public Conciertos getArtistasById (long id);
    public void saveArtistas(Artistas artistas);
    public void delete (long id);
}
    

