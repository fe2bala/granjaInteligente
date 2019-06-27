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

public class TemperaturaService {

    @Autowired
    TemperaturaRepository temperaturaRepository;
    @Autowired
    SensorService sensorService;

    /**
     * Busca pelo objeto que possui o id indicado
     * @param id
     * @return Sensor Temperatura com o id requisitado
     */
    public Temperatura getTemperatura(long id) {
        return temperaturaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Temperatura", "id", id));
    }

    /**
     * Atualiza o objeto que possui o id indicado
     * @param temperaturaId
     * @param model
     * @return Objeto Temperatura atualizado
     */
    public Temperatura updateTemperatura(long temperaturaId, Temperatura model) {

        Temperatura sensor = temperaturaRepository.findById(temperaturaId).orElseThrow(() -> new ResourceNotFoundException("Temperatura", "id", temperaturaId));
        sensor = (Temperatura) sensorService.update(sensor, model);
        sensor.setCurrentTemperature(model.getCurrentTemperature());
        sensor.setTemperatureSet(model.getTemperatureSet());
        Temperatura updateTemperatura = temperaturaRepository.save(sensor);

        return updateTemperatura;
    }

    /**
     * Cria uma nova instância de Temperatura
     * @param temperatura
     * @return Objeto Temperatura criado
     */
    public Temperatura createTemperatura(Temperatura temperatura) {
        Temperatura createdTemperatura = temperaturaRepository.save(temperatura);
        return createdTemperatura;
    }

    /**
     * Busca por todas as instâncias de Temperatura
     * @return Lista com todos os objetos Temperatura
     */
    public List<Temperatura> getAllTemperaturas() {
        List<Temperatura> temperaturas = temperaturaRepository.findAll();
        return temperaturas;
    }

    /**
     * Método que aplica as regras de negócio para o sensor
     * Simulando a alteração nos valores, em resposta
     * @param temperatura
     * @return sensor com dados atualizados em resposta às regras de negócio
     */
    public Temperatura verifySensor(Temperatura temperatura) {
        if (temperatura != null && temperatura.isAuto()) {
            float currTemp = temperatura.getCurrentTemperature();
            Random rand = new Random();

            // comanda os climatizadores
            if (currTemp < (temperatura.getTemperatureSet() - 2)) {
                temperatura.setAquecedor(true);
                temperatura.setVentilador(false);
                temperatura.setCurrentTemperature(currTemp + (3 * rand.nextFloat()));
            } else if (currTemp > (temperatura.getTemperatureSet() + 2)) {
                temperatura.setAquecedor(false);
                temperatura.setVentilador(true);
                temperatura.setCurrentTemperature(currTemp - (3 * rand.nextFloat()));
            } else {
                temperatura.setAquecedor(false);
                temperatura.setVentilador(false);
            }

            return updateTemperatura(temperatura.getId(), temperatura);
        } else {
            return null;
        }
    }

}
