/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.implementation;

import br.com.granjainteligente.Interface.IAtuador;
import br.com.granjainteligente.model.Agua;

/**
 *
 * @author felip
 */
public class Bebedouro implements IAtuador<Agua>{
    private float intervalo = 5;
    
    @Override
    public Agua Aumenta(Agua sensor) {
        sensor.setNivel(sensor.getNivel()+intervalo);
        return sensor;
    }

    @Override
    public Agua Diminui(Agua sensor) {
        sensor.setNivel(sensor.getNivel()-intervalo);
        return sensor;
    }
    
    
}
