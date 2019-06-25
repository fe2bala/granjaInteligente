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
@Table(name="agua")
public class Agua extends Sensor {
    private float Ph;
    @OneToOne(mappedBy = "Agua")
    private Baia baia;
    private float Nivel;
    private float NivelSet;
    private boolean PhAnormal;

    public boolean isPhAnormal() {
        return PhAnormal;
    }

    public void setPhAnormal(boolean PhAnormal) {
        this.PhAnormal = PhAnormal;
    }


    public float getNivel() {
        return Nivel;
    }

    public void setNivel(float Nivel) {
        this.Nivel = Nivel;
    }

    public float getNivelSet() {
        return NivelSet;
    }

    public void setNivelSet(float NivelSet) {
        this.NivelSet = NivelSet;
    }
    public float getPh() {
        return Ph;
    }

    public void setPh(float Ph) {
        this.Ph = Ph;
    }

    public Agua() {
    }

    public Agua(float Ph) {
        this.Ph = Ph;
    }
    
    
}
