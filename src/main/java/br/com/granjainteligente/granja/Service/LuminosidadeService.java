/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.Service;

import br.com.granjainteligente.granja.Exception.ResourceNotFoundException;
import br.com.granjainteligente.granja.Repository.LuminosidadeRepository;
import br.com.granjainteligente.granja.model.Luminosidade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class LuminosidadeService {

    @Autowired
    LuminosidadeRepository luminosidadeRepository;
    @Autowired
    SensorService sensorService;

    /**
     * Busca pelo objeto que possui o id indicado
     * @param id
     * @return Sensor Luminosidade com o id requisitado
     */
    public Luminosidade getLuminosidade(long id){
        return luminosidadeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Luminosidade", "id", id));
    }

    /**
     * Atualiza o objeto que possui o id indicado
     * @param luminosidadeId
     * @param model
     * @return Objeto Luminosidade atualizado
     */
    public Luminosidade updateLuminosidade(long luminosidadeId,Luminosidade model){
        
        Luminosidade sensor = luminosidadeRepository.findById(luminosidadeId).orElseThrow(() -> new ResourceNotFoundException("Luminosidade", "id", luminosidadeId));
        sensor = (Luminosidade) sensorService.update(sensor,model);
        sensor.setLuminosidade(model.isLuminosidade());
        Luminosidade updateLuminosidade = luminosidadeRepository.save(sensor);
        
        return updateLuminosidade; 
    }

    /**
     * Cria uma nova instância de Luminosidade
     * @param luminosidade
     * @return Objeto Luminosidade criado
     */
    public Luminosidade createLuminosidade(Luminosidade luminosidade) {
        Luminosidade createdLuminosidade = luminosidadeRepository.save(luminosidade);
        return createdLuminosidade;
    }
        
    /**
     * Busca por todas as instâncias de Luminosidade
     * @return Lista com todos os objetos Luminosidade
     */
    public List<Luminosidade> getAllLuminosidades(){
        List<Luminosidade> luminosidades =  luminosidadeRepository.findAll();
        return luminosidades;
    }

}
