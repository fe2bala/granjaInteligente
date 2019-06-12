/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author felip
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "alimento")
public class Alimento extends Sensor {

    private float Nivel;


    private float NivelSet;
    @OneToOne(mappedBy = "Alimento")
    private Baia baia;

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
