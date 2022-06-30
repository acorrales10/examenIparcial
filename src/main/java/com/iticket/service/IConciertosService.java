/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iticket.service;

import com.iticket.entity.Conciertos;
import java.util.List;

/**
 *
 * @author AMCG_
 */
public interface IConciertosService {
    
     public List<Conciertos> getallConciertos();
    public Conciertos getConciertosById (long id);
    public void saveConciertos(Conciertos concierto);
    public void delete (long id);
}
