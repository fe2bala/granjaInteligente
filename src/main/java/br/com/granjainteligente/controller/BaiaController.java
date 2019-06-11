/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.controller;

import br.com.granjainteligente.implementation.BaiaImplementation;
import br.com.granjainteligente.implementation.PopulaDados;
import br.com.granjainteligente.model.Alimento;
import br.com.granjainteligente.model.Baia;
import br.com.granjainteligente.model.Sensor;
import java.util.HashSet;
import java.util.Set;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("baia")
public class BaiaController {

    private PopulaDados populaService;
    private BaiaImplementation baiaService;

    @RequestMapping("/inicial")
    public ResponseEntity GetAll() {
        populaService = new PopulaDados();
        Set<Baia> baias = populaService.newBaias();

        return ResponseEntity.ok(baias);
    }

}
