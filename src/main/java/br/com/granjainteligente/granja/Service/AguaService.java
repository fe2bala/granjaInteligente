/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.Service;

import br.com.granjainteligente.granja.Exception.ResourceNotFoundException;
import br.com.granjainteligente.granja.Repository.AguaRepository;
import br.com.granjainteligente.granja.model.Agua;
import br.com.granjainteligente.granja.model.Agua;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author felip
 */
public class AguaService {
    
    @Autowired
    AguaRepository aguaRepository;
    @Autowired
    SensorService sensorService;
    public Agua getAgua(long id){
        //verificar aqui?
        return aguaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Agua", "id", id));
    }
    public Agua updateAgua(long aguaId,Agua model){
        
        Agua sensor = aguaRepository.findById(aguaId).orElseThrow(() -> new ResourceNotFoundException("Agua", "id", aguaId));
        sensor = (Agua) sensorService.update(sensor,model);
        sensor.setNivel(model.getNivel());
        sensor.setNivelSet(model.getNivelSet());
        Agua updateAgua = aguaRepository.save(sensor);
        
        return updateAgua; 
    }
    public Agua createAgua(Agua agua) {
        Agua createdAgua = aguaRepository.save(agua);
        return createdAgua;
    }
        

    public List<Agua> getAllAguas(){
        List<Agua> aguas =  aguaRepository.findAll();
        //verificar aqui? foreach agua verifySensors
        return aguas;
    }

    public Agua verifySensor(Agua agua) {
        if (agua != null && agua.isAuto()) {
            float currNivel = agua.getNivel();
            Random rand = new Random();
            if (currNivel < agua.getNivelSet()) {
                // aumenta o nivel do agua em ate 5 por cento
                agua.setNivel((5 * rand.nextFloat()) + currNivel);
            }
            return updateAgua(agua.getId(), agua);
        } else {
            return null;
        }
    }


    
}
