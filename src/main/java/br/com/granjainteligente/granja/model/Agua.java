/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="agua")
public class Agua extends Sensor {
    private float Ph;
    @OneToOne(mappedBy = "Agua")
    private Baia baia;
    private float Nivel;
    private float NivelSet;
    private boolean PhAnormal;

    /**
     * Atributo utilizado como flag para a informar se o nível de Ph está fora
     * dos níveis definidos na regra de negócio.
     * @return true - ph fora do aceitável; false - ph dentro do aceitável.
     */
    public boolean isPhAnormal() {
        return PhAnormal;
    }

    /**
     * true - ph fora do aceitável;
     * false - ph dentro do aceitável.
     * @param PhAnormal
     */
    public void setPhAnormal(boolean PhAnormal) {
        this.PhAnormal = PhAnormal;
    }

    /**
     * Nível atual lido pelo sensor
     * @return valor no intervalo [0,100]
     */
    public float getNivel() {
        return Nivel;
    }

    /**
     * Registra o valor lido pelo sensor
     * @param Nivel
     */
    public void setNivel(float Nivel) {
        this.Nivel = Nivel;
    }

    /**
     * Valor esperado que o nível se mantenha
     * @return valor no intervalo [0,100]
     */
    public float getNivelSet() {
        return NivelSet;
    }

    /**
     * Valor esperado que o nível atinja e se mantenha
     * @param NivelSet valor no intervalo [0,100]
     */
    public void setNivelSet(float NivelSet) {
        this.NivelSet = NivelSet;
    }

    /**
     * 
     * @return
     */
    public float getPh() {
        return Ph;
    }

    /**
     *
     * @param Ph
     */
    public void setPh(float Ph) {
        this.Ph = Ph;
    }

    /**
     *
     */
    public Agua() {
    }

    /**
     *
     * @param Ph
     */
    public Agua(float Ph) {
        this.Ph = Ph;
    }
    
    
}
