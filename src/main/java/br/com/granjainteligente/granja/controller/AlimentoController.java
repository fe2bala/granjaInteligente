/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.controller;

import br.com.granjainteligente.granja.Service.AlimentoService;
import br.com.granjainteligente.granja.model.Alimento;
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

@RestController
@RequestMapping("/api")
public class AlimentoController {
    
    @Autowired
    AlimentoService alimentoService;
    
    /**
     * Método para recuperar todos os elementos do tipo Alimento
     * @return Lista com objetos da classe Alimento
     */
    @GetMapping("/alimento")
    public List<Alimento> getAllAlimento(){
        return alimentoService.getAllAlimentos();
    }
    
    /**
     * Realiza uma operação de PUT na instância com id alimentoId
     * atualizando os dados com os dados de model.
     * @param alimentoId 
     * @param model
     * @return Objeto atualizado
     */
    @PutMapping("/alimento/{id}")
    public Alimento putAlimento(@PathVariable(value="id")long alimentoId,@Valid @RequestBody Alimento model){
        
        return alimentoService.updateAlimento(alimentoId, model);
        
    }

    /**
     * Requisição de um único objeto, identificado por alimentoId
     * @param alimentoId 
     * @return Objeto Alimento com o id procurado
     */
    @GetMapping("/alimento/{id}")
    public Alimento getAlimentoById(@PathVariable(value = "id") Long alimentoId) {
        return alimentoService.getAlimento(alimentoId);
    }

    /**
     * Requisição de inserir model no banco de dados
     * @param model
     * @return Objeto Alimento inserido
     */
    @PostMapping("/alimento")
    public Alimento createAlimentoSensor(Alimento model){
        return alimentoService.createAlimento(model);
    }
}
