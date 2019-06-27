/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.Service;

import br.com.granjainteligente.granja.model.Sensor;

public class SensorService {

    /**
     * Método para atualizar os dados da classe Sensor, que todas as demais 
     * classes de sensores herdam
     * Atualiza sensor com os dados de model
     * @param sensor
     * @param model
     * @return Objeto Sensor atualizado
     */
    public Sensor update(Sensor sensor,Sensor model) {
        sensor.setAuto(model.isAuto());
        sensor.setData(model.getData());
        sensor.setDescricao(model.getDescricao());
        sensor.setEstado(model.isEstado());
        return sensor;
        
    }
    
}
