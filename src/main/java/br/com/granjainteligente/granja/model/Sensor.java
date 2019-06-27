/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 * Classe pai que os demais sensores herdam, pelos atributos em comum.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    /**
     *
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param Id
     */
    public void setId(long Id) {
        this.id = Id;
    }

    /**
     *
     */
    protected String Descricao;

    /**
     *
     */
    protected Date Data;

    /**
     * Indica se o sensor se encontra ativo (true) ou inativo (false)
     */
    protected boolean Estado;

    /**
     * Indica se o sensor está operando de forma automática: no caso de estar
     * tomando ações automaticamente quando há quebra das regras de negócio.
     */
    protected boolean Auto;

    /**
     *
     * @param Descricao
     * @param Estado
     * @param Auto
     */
    public Sensor(String Descricao, boolean Estado, boolean Auto) {
        this.Descricao = Descricao;
        this.Data = Data;
        this.Estado = Estado;
        this.Auto = Auto;
    }

    /**
     *
     */
    public Sensor() {
    }

    /**
     *
     * @return
     */
    public String getDescricao() {
        return Descricao;
    }

    /**
     *
     * @param Descricao
     */
    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    /**
     *
     * @return
     */
    public Date getData() {
        return Data;
    }

    /**
     *
     * @param Data
     */
    public void setData(Date Data) {
        this.Data = Data;
    }

    /**
     * Retorna a informação do estado do sensor, sendo ativo (true) e inativo 
     * (false)
     * @return
     */
    public boolean isEstado() {
        return Estado;
    }

    /**
     *
     * @param Estado
     */
    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    /**
     * Retorna a informação se o sensor esta atuando de forma automática (true)
     * ou não (false).
     * @return
     */
    public boolean isAuto() {
        return Auto;
    }

    /**
     *
     * @param Auto
     */
    public void setAuto(boolean Auto) {
        this.Auto = Auto;
    }

}
