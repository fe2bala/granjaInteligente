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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BaiaController {
    @Autowired
    BaiaService baiaService;
    
    /**
     * Método para retornar todas as Baias existentes na base de dados
     * @return List com as intâncias de Baia
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/baias")
    public List<Baia> getAllBaias(){
        return baiaService.getAllBaias();
    }
    
    /**
     * Requisição para criar um nova baia no banco de dados
     * @param baia
     * @return Objeto Baia inserido
     */
    @PostMapping("/baias")
    public Baia createBaia(@Valid @RequestBody Baia baia) {   
        return baiaService.createBaia(baia);
    }

    /**
     * Realiza uma operação de PUT na instância com id baiaId
     * atualizando os dados com os dados de model.
     * @param baiaId
     * @param model
     * @return Objeto atualizado
     */
    @PutMapping("/baias/{id}")
    public Baia updateBaia(@PathVariable(value="id")long baiaId, @Valid @RequestBody Baia model){
        
       return baiaService.updateBaia(baiaId, model);
    }
    
    /**
     * Requisição para recuperar um único objeto baia, identificado por baiaId
     * @param baiaId
     * @return Objeto Baia com o id procurado
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/baias/{id}")
    public Baia getBaiaById(@PathVariable(value = "id") Long baiaId) {
        //verificao aqui
       return baiaService.getBaia(baiaId);
    }

}
