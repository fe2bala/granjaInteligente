/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.Service;

import br.com.granjainteligente.granja.Exception.ResourceNotFoundException;
import br.com.granjainteligente.granja.Repository.LuminosidadeRepository;
import br.com.granjainteligente.granja.model.Luminosidade;
import br.com.granjainteligente.granja.model.Luminosidade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author felip
 */
public class LuminosidadeService {

    @Autowired
    LuminosidadeRepository luminosidadeRepository;
    @Autowired
    SensorService sensorService;
    public Luminosidade getLuminosidade(long id){
        //verificar aqui?
        return luminosidadeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Luminosidade", "id", id));
    }
    public Luminosidade updateLuminosidade(long luminosidadeId,Luminosidade model){
        
        Luminosidade sensor = luminosidadeRepository.findById(luminosidadeId).orElseThrow(() -> new ResourceNotFoundException("Luminosidade", "id", luminosidadeId));
        sensor = (Luminosidade) sensorService.update(sensor,model);
        sensor.setLuminosidade(model.isLuminosidade());
        Luminosidade updateLuminosidade = luminosidadeRepository.save(sensor);
        
        return updateLuminosidade; 
    }
    public Luminosidade createLuminosidade(Luminosidade luminosidade) {
        Luminosidade createdLuminosidade = luminosidadeRepository.save(luminosidade);
        return createdLuminosidade;
    }
        

    public List<Luminosidade> getAllLuminosidades(){
        List<Luminosidade> luminosidades =  luminosidadeRepository.findAll();
        //verificar aqui? foreach luminosidade verifySensors
        return luminosidades;
    }

    
}
