/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.controller;

import br.com.granjainteligente.granja.Exception.ResourceNotFoundException;
import br.com.granjainteligente.granja.Repository.BaiaRepository;
import br.com.granjainteligente.granja.model.Baia;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    BaiaRepository baiaService;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/baias")
    public List<Baia> getAllBaias(){
        return baiaService.findAll();
    }
    
    @PostMapping("/baias")
    public Baia createBaia(@Valid @RequestBody Baia baia) {
        System.out.println(baia.getName());
        return baiaService.save(baia);
    }
    @PutMapping("/baias/{id}")
    public Baia updateBaia(@PathVariable(value="id")long baiaId, @Valid @RequestBody Baia model){
        
        Baia baia= baiaService.findById(baiaId).orElseThrow(() -> new ResourceNotFoundException("Baia", "id", baiaId));
        baia.setAge(model.getAge());
        baia.setName(model.getName());
        baia.setStatus(model.isStatus());
        Baia updateBaia = baiaService.save(baia);
        
        return updateBaia;
        
        
    }
}
