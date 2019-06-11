/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.model;

/**
 *
 * @author felip
 */


public class Temperatura extends Sensor {

    public float getCurrentTemperature() {
        return CurrentTemperature;
    }

    public void setCurrentTemperature(float CurrentTemperature) {
        this.CurrentTemperature = CurrentTemperature;
    }

    public float getTemperatureSet() {
        return TemperatureSet;
    }

    public void setTemperatureSet(float TemperatureSet) {
        this.TemperatureSet = TemperatureSet;
    }
    private float CurrentTemperature;
    private float TemperatureSet;

}
