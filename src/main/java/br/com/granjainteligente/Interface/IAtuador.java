package br.com.granjainteligente.Interface;


import br.com.granjainteligente.model.Sensor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author felip
 */
public interface IAtuador<T>  {
    
    public T Aumenta(T sensor);
    public T Diminui(T sensor);
    
}
