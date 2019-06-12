/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.model;

import java.util.Date;
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
@Table(name = "luminosidade")
public class Luminosidade extends Sensor {
    private boolean Luminosidade;

    public boolean isLuminosidade() {
        return Luminosidade;
    }

    public void setLuminosidade(boolean Luminosidade) {
        this.Luminosidade = Luminosidade;
    }

    @OneToOne(mappedBy = "Luminosidade")
    private Baia baia;


    
}
