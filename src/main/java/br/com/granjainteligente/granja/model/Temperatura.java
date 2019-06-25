/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author felip
 */

@Entity
@Table(name = "temperatura")
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

    public boolean isAquecedor() {
        return Aquecedor;
    }

    public void setAquecedor(boolean Aquecedor) {
        this.Aquecedor = Aquecedor;
    }

    public boolean isVentilador() {
        return Ventilador;
    }

    public void setVentilador(boolean Ventilador) {
        this.Ventilador = Ventilador;
    }
    
    private float CurrentTemperature;
    private float TemperatureSet;
    private boolean Aquecedor;
    private boolean Ventilador;
    @OneToOne(mappedBy = "Temperatura")
    private Baia baia;



}
