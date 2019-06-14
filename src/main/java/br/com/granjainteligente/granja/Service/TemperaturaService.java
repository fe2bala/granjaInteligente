/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.Service;

import br.com.granjainteligente.granja.Exception.ResourceNotFoundException;
import br.com.granjainteligente.granja.Repository.TemperaturaRepository;
import br.com.granjainteligente.granja.model.Temperatura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author felip
 */
public class TemperaturaService {
    @Autowired
    TemperaturaRepository temperaturaRepository;
    @Autowired
    SensorService sensorService;
    
    public Temperatura getTemperatura(long id){
        //verificar aqui?
        return temperaturaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Temperatura", "id", id));
    }
    public Temperatura updateTemperatura(long temperaturaId,Temperatura model){
        
        Temperatura sensor = temperaturaRepository.findById(temperaturaId).orElseThrow(() -> new ResourceNotFoundException("Temperatura", "id", temperaturaId));
        sensor = (Temperatura) sensorService.update(sensor, model);
        sensor.setCurrentTemperature(model.getCurrentTemperature());
        sensor.setTemperatureSet(model.getTemperatureSet());
        Temperatura updateTemperatura = temperaturaRepository.save(sensor);
        
        return updateTemperatura; 
    }
    public Temperatura createTemperatura(Temperatura temperatura) {
        Temperatura createdTemperatura = temperaturaRepository.save(temperatura);
        return createdTemperatura;
    }
        

    public List<Temperatura> getAllTemperaturas(){
        List<Temperatura> temperaturas =  temperaturaRepository.findAll();
        //verificar aqui? foreach temperatura verifySensors
        return temperaturas;
    }
        public void verifySensor(Temperatura temperatura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}