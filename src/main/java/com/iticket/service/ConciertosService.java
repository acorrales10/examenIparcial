/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iticket.service;

import com.iticket.entity.Conciertos;
import com.iticket.repository.ConciertosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AMCG_
 */
@Service
public class ConciertosService implements IConciertosService{
    
     @Autowired
    private ConciertosRepository conciertoRepository;

    @Override
    public List<Conciertos> getallConciertos() {
        return (List<Conciertos>)conciertoRepository.findAll();
    }

    @Override
    public Conciertos getConciertosById(long id) {
         return conciertoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveConciertos(Conciertos concierto) {
        conciertoRepository.save(concierto);
    }

    @Override
    public void delete(long id) {
        conciertoRepository.deleteById(id);
    }
    
    
}