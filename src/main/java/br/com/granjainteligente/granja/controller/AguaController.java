/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.controller;

import br.com.granjainteligente.granja.Exception.ResourceNotFoundException;
import br.com.granjainteligente.granja.Repository.AguaRepository;
import br.com.granjainteligente.granja.model.Agua;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author felip
 */
@RestController
@RequestMapping("/api")
public class AguaController {
    
    @Autowired
    AguaRepository aguaService;
    
    @GetMapping("/agua")
    public List<Agua> getAllAgua(){
        return aguaService.findAll();
    }
    @PutMapping("/agua/{id}")
    public Agua putAgua(@PathVariable(value="id")long aguaId,@Valid @RequestBody Agua model){
        
        Agua sensor = aguaService.findById(aguaId).orElseThrow(() -> new ResourceNotFoundException("Agua", "id", aguaId));
        sensor.setEstado(model.isEstado());
        sensor.setAuto(model.isAuto());
        sensor.setNivel(model.getNivel());
        sensor.setNivelSet(model.getNivelSet());
        Agua updateAgua = aguaService.save(sensor);
                
        return updateAgua;
        
    }
    @GetMapping("/agua/{id}")
    public Agua getBaiaById(@PathVariable(value = "id") Long aguaId) {
        //fazer verificacao aqui
        return aguaService.findById(aguaId).orElseThrow(() -> new ResourceNotFoundException("Agua", "id", aguaId));
    }
}
