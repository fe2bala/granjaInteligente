/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.implementation;

import br.com.granjainteligente.Interface.IAtuador;
import br.com.granjainteligente.model.Alimento;

/**
 *
 * @author felip
 */
public class Alimentador implements IAtuador<Alimento>{
    private float intervalo = 5;
    
    @Override
    public Alimento Aumenta(Alimento sensor) {
        sensor.setNivel(sensor.getNivel()+intervalo);
        return sensor;
    }

    @Override
    public Alimento Diminui(Alimento sensor) {
        sensor.setNivel(sensor.getNivel()-intervalo);
        return sensor;
    }
    
    private Alimento popula(Alimento model) {
        Alimento a = new Alimento();
        a.setNivelSet(model.getNivelSet());
        a.setNivel(model.getNivel());
        a.setEstado(model.isEstado());
        a.setDescricao(model.getDescricao());
        return a;
    }
    
}
