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


@RestController
@RequestMapping("/api")
public class AguaController {
    
    @Autowired
    AguaService aguaService;
    
    /**
     * Método para retornar todos os sensores do tipo Agua
     * @return List com as instâncias de Agua
     */
    @GetMapping("/agua")
    public List<Agua> getAllAgua(){
        return aguaService.getAllAguas();
    }

    /**
     * Realiza uma operação de PUT na instância com identificador = aguaId
     * atualizando os dados do sensor com os dados do model.
     * @param aguaId
     * @param model
     * @return Objeto atualizado
     */
    @PutMapping("/agua/{id}")
    public Agua putAgua(@PathVariable(value="id")long aguaId,@Valid @RequestBody Agua model){
                
        return aguaService.updateAgua(aguaId, model);
        
    }

    /**
     * Metodo retorna de um único objeto Agua, identificado por seu identificador
     * @param aguaId
     * @return Objeto Agua com o id procurado
     */
    @GetMapping("/agua/{id}")
    public Agua getAguaById(@PathVariable(value = "id") Long aguaId) {
        return aguaService.getAgua(aguaId);
    }

    /**
     * Requisição de criar um novo model no banco de dados
     * @param model
     * @return Objeto Agua criado
     */
    @PostMapping("/agua")
    public Agua createAgua(Agua model){
        return aguaService.createAgua(model);
    }
}
