/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.controller;

import br.com.granjainteligente.granja.Repository.AlimentoRepository;
import br.com.granjainteligente.granja.model.Alimento;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @GetMapping("/Alimento")
    public List<Alimento> getAllAlimento(){
        return alimentoService.findAll();
    }
    
    @PostMapping("/Alimento")
    public Alimento createAlimento(@Valid @RequestBody Alimento alimento){
        return alimentoService.save(alimento);
    } 
}
