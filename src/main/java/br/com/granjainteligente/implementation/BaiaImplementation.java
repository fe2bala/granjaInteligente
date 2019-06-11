/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.implementation;

import br.com.granjainteligente.model.Baia;

/**
 *
 * @author felip
 */
public class BaiaImplementation {

    private Baia checaTemperatura(Baia baia) {

        if (baia.getTemperatura() == null) {
            return baia;
        }
        float currTemp = baia.getTemperatura().getCurrentTemperature();
        float setTemp = baia.getTemperatura().getTemperatureSet();
        Climatizador c = new Climatizador();

        if (currTemp > setTemp) {
            baia.setTemperatura(c.Diminui(baia.getTemperatura()));
        } else {
            baia.setTemperatura(c.Aumenta(baia.getTemperatura()));
        }
        return baia;
    }

    private Baia checaAlimento(Baia baia) {
        if (baia.getAlimento() == null) {
            return baia;
        }
        Alimentador c = new Alimentador();

        if (baia.getAlimento().getNivel() < baia.getAlimento().getNivelSet()) {
            baia.setAlimento(c.Aumenta(baia.getAlimento()));
        }
        return baia;
    }

    private Baia checaAgua(Baia baia) {
        if (baia.getAgua() == null) {
            return baia;
        }
        Bebedouro b = new Bebedouro();

        if (baia.getAgua().getNivel() < baia.getAgua().getNivelSet()) {
            baia.setAlimento(b.Aumenta(baia.getAgua()));
        }
        return baia;
    }
}
