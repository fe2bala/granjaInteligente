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
public class Alimento extends Sensor {

    private float Nivel;
    private float NivelSet;

    public float getNivelSet() {
        return NivelSet;
    }

    public void setNivelSet(float NivelSet) {
        this.NivelSet = NivelSet;
    }

    public float getNivel() {
        return Nivel;
    }

    public void setNivel(float Nivel) {
        this.Nivel = Nivel;
    }
}
