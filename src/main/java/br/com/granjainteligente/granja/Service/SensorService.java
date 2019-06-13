/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.Service;

import br.com.granjainteligente.granja.model.Sensor;



/**
 *
 * @author felip
 */
public class SensorService {

    public void update(Sensor sensor,Sensor model) {
        sensor.setAuto(model.isAuto());
        sensor.setData(model.getData());
        sensor.setDescricao(model.getDescricao());
        sensor.setEstado(sensor.isEstado());
        
    }
    
}
