/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.controller;

import br.com.granjainteligente.granja.Exception.ResourceNotFoundException;
import br.com.granjainteligente.granja.Repository.AlimentoRepository;
import br.com.granjainteligente.granja.model.Alimento;
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
public class AlimentoController {
    
    @Autowired
    AlimentoRepository alimentoService;
    
    @GetMapping("/alimento")
    public List<Alimento> getAllAlimento(){
        return alimentoService.findAll();
    }
    @PutMapping("/alimento/{id}")
    public Alimento putAlimento(@PathVariable(value="id")long alimentoId,@Valid @RequestBody Alimento model){
        
        Alimento sensor = alimentoService.findById(alimentoId).orElseThrow(() -> new ResourceNotFoundException("Alimento", "id", alimentoId));
        sensor.setEstado(model.isEstado());
        sensor.setAuto(model.isAuto());
        sensor.setNivel(model.getNivel());
        sensor.setNivelSet(model.getNivelSet());
        Alimento updateAlimento = alimentoService.save(sensor);
                
        return updateAlimento;
        
    }
    @GetMapping("/alimento/{id}")
    public Alimento getBaiaById(@PathVariable(value = "id") Long alimentoId) {
        //fazer verifacao aqui
        return alimentoService.findById(alimentoId).orElseThrow(() -> new ResourceNotFoundException("Alimento", "id", alimentoId));
    }
}
