/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.controller;

import br.com.granjainteligente.granja.Service.BaiaService;
import br.com.granjainteligente.granja.model.Baia;
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
public class BaiaController {
    @Autowired
    BaiaService baiaService;
    
    @GetMapping("/baias")
    public List<Baia> getAllBaias(){
        return baiaService.getAllBaias();
    }
    
    @PostMapping("/baias")
    public Baia createBaia(@Valid @RequestBody Baia baia) {   
        return baiaService.createBaia(baia);
    }
    @PutMapping("/baias/{id}")
    public Baia updateBaia(@PathVariable(value="id")long baiaId, @Valid @RequestBody Baia model){
        
       return baiaService.updateBaia(baiaId, model);
    }
    @GetMapping("/baia/{id}")
    public Baia getBaiaById(@PathVariable(value = "id") Long baiaId) {
        //verificao aqui
       return baiaService.getBaia(baiaId);
    }

}
