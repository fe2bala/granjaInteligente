/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.model;

import java.util.Date;

/**
 *
 * @author felip
 */
public class Sensor {

    protected String Descricao;

    protected Date Data;

    protected boolean Estado;

    protected Long Id;

    protected boolean Auto;

    public Sensor(String Descricao, boolean Estado, Long Id, boolean Auto) {
        this.Descricao = Descricao;
        this.Data = Data;
        this.Estado = Estado;
        this.Id = Id;
        this.Auto = Auto;
    }

    public Sensor() {
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public boolean isAuto() {
        return Auto;
    }

    public void setAuto(boolean Auto) {
        this.Auto = Auto;
    }

}
