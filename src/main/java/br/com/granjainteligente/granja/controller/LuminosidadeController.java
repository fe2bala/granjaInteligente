/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.controller;

import br.com.granjainteligente.granja.Exception.ResourceNotFoundException;
import br.com.granjainteligente.granja.Repository.LuminosidadeRepository;
import br.com.granjainteligente.granja.model.Luminosidade;
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
public class LuminosidadeController {

    @Autowired
    LuminosidadeRepository luminosidadeService;

    @GetMapping("/Luminosidade")
    public List<Luminosidade> getAllLuminosidade() {
        return luminosidadeService.findAll();
    }

    @PostMapping("/Luminosidade")
    public Luminosidade createLuminosidade(@Valid @RequestBody Luminosidade luminosidade) {
        return luminosidadeService.save(luminosidade);
    }

    @PutMapping("/Luminosidade/{id}")
    public Luminosidade updateLuminosidade(@PathVariable(value = "id") long luminosidadeId, @Valid @RequestBody Luminosidade model) {
        Luminosidade sensor = luminosidadeService.findById(luminosidadeId).orElseThrow(() -> new ResourceNotFoundException("Luminosidade", "id", luminosidadeId));
        sensor.setAuto(model.isAuto());
        sensor.setData(model.getData());
        sensor.setDescricao(model.getDescricao());
        sensor.setEstado(model.isEstado());
        sensor.setLuminosidade(model.isLuminosidade());
        
        Luminosidade updateSensor = luminosidadeService.save(sensor);

        return updateSensor;

    }

}
