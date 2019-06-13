/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.Service;

import br.com.granjainteligente.granja.Exception.ResourceNotFoundException;
import br.com.granjainteligente.granja.Repository.BaiaRepository;
import br.com.granjainteligente.granja.model.Baia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author felip
 */
public class BaiaService {
    @Autowired
    BaiaRepository baiaRepository;
    public Baia getBaia(long id){
        //verificar aqui?
        return baiaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Baia", "id", id));
    }
    public Baia updateBaia(long baiaId,Baia model){
        
        Baia baia= baiaRepository.findById(baiaId).orElseThrow(() -> new ResourceNotFoundException("Baia", "id", baiaId));
        baia.setAge(model.getAge());
        baia.setName(model.getName());
        baia.setStatus(model.isStatus());
        Baia updateBaia = baiaRepository.save(baia);
        
        return updateBaia; 
    }
    public Baia createBaia(Baia baia) {
        Baia createdBaia = baiaRepository.save(baia);
        return createdBaia;
    }
        
    private void verifySensors(Baia baia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Baia> getAllBaias(){
        List<Baia> baias =  baiaRepository.findAll();
        //verificar aqui? foreach baia verifySensors
        return baias;
    }
    
}