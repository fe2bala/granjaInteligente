/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author felip
 */
public class Baia {

    private long Id;
    private boolean Status;
    private int Age;
    private String Name;
    private Alimento Alimento;
    private Temperatura Temperatura;
    private Luminosidade Luminosidade;
    private Agua Agua;

    public Baia() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public void setAlimento(Alimento Alimento) {
        this.Alimento = Alimento;
    }

    public void setTemperatura(Temperatura Temperatura) {
        this.Temperatura = Temperatura;
    }

    public void setLuminosidade(Luminosidade Luminosidade) {
        this.Luminosidade = Luminosidade;
    }

    public Alimento getAlimento() {
        return Alimento;
    }

    public Temperatura getTemperatura() {
        return Temperatura;
    }

    public Luminosidade getLuminosidade() {
        return Luminosidade;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Agua getAgua() {
        return Agua;
    }

    public void setAgua(Agua Agua) {
        this.Agua = Agua;
    }

    public Baia(long Id, boolean Status, int Age, String Name, Alimento Alimento, Temperatura Temperatura, Luminosidade Luminosidade) {
        this.Id = Id;
        this.Status = Status;
        this.Age = Age;
        this.Name = Name;
        this.Alimento = Alimento;
        this.Temperatura = Temperatura;
        this.Luminosidade = Luminosidade;
    }

}
