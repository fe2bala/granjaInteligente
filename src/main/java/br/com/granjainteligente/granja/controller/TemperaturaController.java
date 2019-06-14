/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.controller;

import br.com.granjainteligente.granja.Service.TemperaturaService;
import br.com.granjainteligente.granja.model.Temperatura;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
public class TemperaturaController {
    
    @Autowired
    TemperaturaService temperaturaService;
    
    @GetMapping("/temperatura")
    public List<Temperatura> getAllTemperatura(){
        return temperaturaService.getAllTemperaturas();
    }
    @PutMapping("/temperatura/{id}")
    public Temperatura putTemperatura(@PathVariable(value="id")long temperaturaId,@Valid @RequestBody Temperatura model){
        
        return temperaturaService.updateTemperatura(temperaturaId, model);
    }
    @GetMapping("/temperatura/{id}")
    public Temperatura getBaiaById(@PathVariable(value = "id") Long temperaturaId) {
        return temperaturaService.getTemperatura(temperaturaId);
    }
    @PostMapping("/temperatura")
    public Temperatura createTempSensor(Temperatura model){
        return temperaturaService.createTemperatura(model);
    }
}
