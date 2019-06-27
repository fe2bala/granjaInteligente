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

@RestController
@RequestMapping("/api")
public class TemperaturaController {
    
    @Autowired
    TemperaturaService temperaturaService;
    
    /**
     * Método para retornar todos os sensores do tipo Temperatura
     * @return List com as instâncias de Temperatura
     */
    @GetMapping("/temperatura")
    public List<Temperatura> getAllTemperatura(){
        return temperaturaService.getAllTemperaturas();
    }

    /**
     * Realiza uma operação de PUT na instância com id temperaturaId
     * atualizando os dados com os dados de model.
     * @param temperaturaId
     * @param model
     * @return Objeto atualizado
     */
    @PutMapping("/temperatura/{id}")
    public Temperatura putTemperatura(@PathVariable(value="id")long temperaturaId,@Valid @RequestBody Temperatura model){
        
        return temperaturaService.updateTemperatura(temperaturaId, model);
    }

    /**
     * Requisição de um único objeto, identificado por temperaturaId
     * @param temperaturaId
     * @return Objeto Temperatura com o id procurado
     */
    @GetMapping("/temperatura/{id}")
    public Temperatura getBaiaById(@PathVariable(value = "id") Long temperaturaId) {
        return temperaturaService.getTemperatura(temperaturaId);
    }

    /**
     * Requisição criar um novo model no banco de dados
     * @param model
     * @return
     */
    @PostMapping("/temperatura")
    public Temperatura createTempSensor(Temperatura model){
        return temperaturaService.createTemperatura(model);
    }
}
