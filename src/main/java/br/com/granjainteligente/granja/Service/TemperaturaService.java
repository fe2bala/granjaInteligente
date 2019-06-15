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
import java.util.Random;

/**
 *
 * @author felip
 */
public class TemperaturaService {

    @Autowired
    TemperaturaRepository temperaturaRepository;
    @Autowired
    SensorService sensorService;

    public Temperatura getTemperatura(long id) {
        //verificar aqui?
        return temperaturaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Temperatura", "id", id));
    }

    public Temperatura updateTemperatura(long temperaturaId, Temperatura model) {

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

    public List<Temperatura> getAllTemperaturas() {
        List<Temperatura> temperaturas = temperaturaRepository.findAll();

        return temperaturas;
    }

    public Temperatura verifySensor(Temperatura temperatura) {
        if (temperatura != null) {
            float currTemp = temperatura.getCurrentTemperature();
            Random rand = new Random();

            if (currTemp < (temperatura.getTemperatureSet() - 2)) {
                // aumenta a temperatura em ate 3 graus
                temperatura.setCurrentTemperature(currTemp + (3 * rand.nextFloat()));
            } else if (currTemp > (temperatura.getTemperatureSet() + 2)) {
                temperatura.setCurrentTemperature(currTemp - (3 * rand.nextFloat()));
            }
            return updateTemperatura(temperatura.getId(), temperatura);
        } else {
            return null;
        }
    }

}
