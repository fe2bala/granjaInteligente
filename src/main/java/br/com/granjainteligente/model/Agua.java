/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.model;

/**
 *
 * @author felip
 */
public class Agua extends Alimento {
    private float Ph;

    public float getPh() {
        return Ph;
    }

    public void setPh(float Ph) {
        this.Ph = Ph;
    }

    public Agua() {
    }

    public Agua(float Ph) {
        this.Ph = Ph;
    }
    
    
}
