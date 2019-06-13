/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author felip
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="baia")
public class Baia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private boolean Status;
    private int Age;
    private String Name;
    @OneToOne(cascade = CascadeType.ALL)
    
    @JoinColumn(name = "alimento_id", referencedColumnName = "id")
    private Alimento Alimento;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "temperatura_id", referencedColumnName = "id")
    private Temperatura Temperatura;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "luminosidade_id", referencedColumnName = "id")
    private Luminosidade Luminosidade;
    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "agua_id", referencedColumnName = "id")
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
