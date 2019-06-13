/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.controller;

import br.com.granjainteligente.granja.Service.AguaService;
import br.com.granjainteligente.granja.model.Agua;
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
public class AguaController {
    
    @Autowired
    AguaService aguaService;
    
    @GetMapping("/agua")
    public List<Agua> getAllAgua(){
        return aguaService.getAllAguas();
    }
    @PutMapping("/agua/{id}")
    public Agua putAgua(@PathVariable(value="id")long aguaId,@Valid @RequestBody Agua model){
                
        return aguaService.updateAgua(aguaId, model);
        
    }
    @GetMapping("/agua/{id}")
    public Agua getAguaById(@PathVariable(value = "id") Long aguaId) {
        return aguaService.getAgua(aguaId);
    }
    @PostMapping("/agua")
    public Agua createTempSensor(Agua model){
        return aguaService.createAgua(model);
    }
}
