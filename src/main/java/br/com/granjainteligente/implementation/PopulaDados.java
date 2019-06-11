/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.implementation;

import br.com.granjainteligente.model.Alimento;
import br.com.granjainteligente.model.Baia;
import br.com.granjainteligente.model.Luminosidade;
import br.com.granjainteligente.model.Sensor;
import br.com.granjainteligente.model.Temperatura;
import java.util.HashSet;

/**
 *
 * @author felip
 */
public class PopulaDados {
    
    private long i = 1;
    public HashSet<Baia> newBaias(){
        HashSet<Baia> baias = new HashSet<Baia>();

        baias.add(new Baia(1,true, 2, "Joao",populaSensorAlimentacao(), populaSensorTemperatura(), populaSensorLuminosidade()));
        baias.add(new Baia(2, false, 0, "Lucas",populaSensorAlimentacao(), populaSensorTemperatura(), populaSensorLuminosidade()));
        return baias;
    }

    private Alimento populaSensorAlimentacao() {
        Alimento a = new Alimento();
        a.setNivelSet(60);
        a.setNivel(30);
        a.setEstado(true);
        a.setId(i);
        i++;
        a.setDescricao("SensorAlimentação");
        return a;
    }

    private Luminosidade populaSensorLuminosidade() {
        Luminosidade a = new Luminosidade();
        a.setEstado(true);
        a.setLuminosidade(true);
        a.setId(i);
        i++;
        a.setDescricao("SensorIluminação");
        return a;
       
    }

    private Temperatura populaSensorTemperatura() {
        Temperatura a = new Temperatura();
        a.setTemperatureSet(26);
        a.setCurrentTemperature(21);
        a.setEstado(true);
        a.setDescricao("SensorAlimentação");
        a.setId(i);
        i++;
        return a;
    }
}
    