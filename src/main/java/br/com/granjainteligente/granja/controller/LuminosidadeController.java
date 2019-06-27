/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.controller;

import br.com.granjainteligente.granja.Service.LuminosidadeService;
import br.com.granjainteligente.granja.model.Luminosidade;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
@RequestMapping("/api")
public class LuminosidadeController {
    
    @Autowired
    LuminosidadeService luminosidadeService;
    
    /**
     * Método para retornar todos os sensores do tipo Luminosidade
     * @return List com as instâncias de Luminosidade
     */
    @GetMapping("/luminosidade")
    public List<Luminosidade> getAllLuminosidade(){
        return luminosidadeService.getAllLuminosidades();
    }

    /**
     * Realiza uma operação de PUT na instância com id luminosidadeId
     * atualizando os dados com os dados de model.
     * @param luminosidadeId
     * @param model
     * @return Objeto atualizado
     */
    @PutMapping("/luminosidade/{id}")
    public ResponseEntity putLuminosidade(@PathVariable(value="id")long luminosidadeId,@Valid @RequestBody Luminosidade model){
            Luminosidade l = luminosidadeService.updateLuminosidade(luminosidadeId, model);
        return ResponseEntity.ok(l) ;
        
    }

    /**
     * Requisição que retorna de um único objeto luminosidade, identificado por luminosidadeId
     * @param luminosidadeId
     * @return Objeto Luminosidade com o id procurado
     */
    @GetMapping("/luminosidade/{id}")
    public Luminosidade getLuminosidadeById(@PathVariable(value = "id") Long luminosidadeId) {
        return luminosidadeService.getLuminosidade(luminosidadeId);
    }

    /**
     * Requisição para criar um novo model no banco de dados
     * @param model
     * @return Objeto Luminosidade inserido
     */
    @PostMapping("/luminosidade")
    public Luminosidade createLuminosidadeSensor(Luminosidade model){
        return luminosidadeService.createLuminosidade(model);
    }
}
