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

    /**
     * Classe para as Baias do aviário, com os sensores e seus dados.
     */
    public Baia() {
    }

    /**
     *
     * @return
     */
    public long getId() {
        return Id;
    }

    /**
     *
     * @param Id
     */
    public void setId(long Id) {
        this.Id = Id;
    }

    /**
     * Se a Baia se encontra ativa ou desativada
     * @return
     */
    public boolean isStatus() {
        return Status;
    }

    /**
     * Determina se o sensor está ativo (true) ou desativo (false)
     * @param Status
     */
    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    /**
     * Associa o sensor de Alimento
     * @param Alimento
     */
    public void setAlimento(Alimento Alimento) {
        this.Alimento = Alimento;
    }

    /**
     * Associa o sensor de Temperatura
     * @param Temperatura
     */
    public void setTemperatura(Temperatura Temperatura) {
        this.Temperatura = Temperatura;
    }

    /**
     * Associa o sensor de Luminosidade
     * @param Luminosidade
     */
    public void setLuminosidade(Luminosidade Luminosidade) {
        this.Luminosidade = Luminosidade;
    }

    /**
     *
     * @return
     */
    public Alimento getAlimento() {
        return Alimento;
    }

    /**
     *
     * @return
     */
    public Temperatura getTemperatura() {
        return Temperatura;
    }

    /**
     *
     * @return
     */
    public Luminosidade getLuminosidade() {
        return Luminosidade;
    }

    /**
     *
     * @return
     */
    public int getAge() {
        return Age;
    }

    /**
     * Valor em dias para a idade das aves da baia
     * @param Age
     */
    public void setAge(int Age) {
        this.Age = Age;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return Name;
    }

    /**
     *
     * @param Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     *
     * @return
     */
    public Agua getAgua() {
        return Agua;
    }

    /**
     * Associa o sensor de Agua
     * @param Agua
     */
    public void setAgua(Agua Agua) {
        this.Agua = Agua;
    }

    /**
     *
     * @param Id
     * @param Status
     * @param Age
     * @param Name
     * @param Alimento
     * @param Temperatura
     * @param Luminosidade
     */
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
