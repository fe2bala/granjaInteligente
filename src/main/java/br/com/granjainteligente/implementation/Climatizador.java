/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.implementation;

import br.com.granjainteligente.model.Temperatura;
import br.com.granjainteligente.Interface.IAtuador;

/**
 *
 * @author felip
 */
public class Climatizador implements IAtuador<Temperatura> {

    private float intervalo = 1;
    @Override
    public Temperatura Aumenta(Temperatura sensor) {
        sensor.setCurrentTemperature(sensor.getCurrentTemperature()+intervalo);
        return sensor;
    }

    @Override
    public Temperatura Diminui(Temperatura sensor) {
        sensor.setCurrentTemperature(sensor.getCurrentTemperature()-intervalo);
        return sensor;
    }
    private Temperatura populaSensorTemperatura(Temperatura temperatura) {
        Temperatura a = new Temperatura();
        a.setTemperatureSet(temperatura.getTemperatureSet());
        a.setCurrentTemperature(temperatura.getCurrentTemperature());
        a.setEstado(temperatura.isEstado()); 
        a.setDescricao(temperatura.getDescricao());
        return a;
    }
}
