/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "temperatura")
public class Temperatura extends Sensor {

    /**
     * Retorna a informação da última temperatura lida pelo sensor.
     * @return temperatura
     */
    public float getCurrentTemperature() {
        return CurrentTemperature;
    }

    /**
     *
     * @param CurrentTemperature
     */
    public void setCurrentTemperature(float CurrentTemperature) {
        this.CurrentTemperature = CurrentTemperature;
    }

    /**
     * Retorna a informação da temperatura esperada que o sensor atinja e se
     * mantenha.
     * @return temperatura esperada
     */
    public float getTemperatureSet() {
        return TemperatureSet;
    }

    /**
     *
     * @param TemperatureSet
     */
    public void setTemperatureSet(float TemperatureSet) {
        this.TemperatureSet = TemperatureSet;
    }

    /**
     * Retorna a informação do aparelho aquecedor estando ligado (true) ou
     * desligado (false).
     * @return true - ativo; false - inativo
     */
    public boolean isAquecedor() {
        return Aquecedor;
    }

    /**
     *
     * @param Aquecedor
     */
    public void setAquecedor(boolean Aquecedor) {
        this.Aquecedor = Aquecedor;
    }

    /**
     * Retorna a informação do aparelho ventilador estando ligado (true) ou
     * desligado (false).
     * @return true - ativo; false - inativo
     */
    public boolean isVentilador() {
        return Ventilador;
    }

    /**
     *
     * @param Ventilador
     */
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
