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

public class BaiaService {
    @Autowired
    BaiaRepository baiaRepository;
    @Autowired 
    TemperaturaService temperaturaService;
    @Autowired
    AlimentoService alimentoService;
    @Autowired
    AguaService aguaService;
    
    /**
     * Busca pelo objeto que possui o id indicado
     * @param id
     * @return Baia como id requisitado
     */
    public Baia getBaia(long id){
        return baiaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Baia", "id", id));
    }
    
    /**
     * Atualiza o objeto que possui o id indicado
     * @param baiaId
     * @param model
     * @return Objeto Baia atualizado
     */
    public Baia updateBaia(long baiaId,Baia model){
        
        Baia baia= baiaRepository.findById(baiaId).orElseThrow(() -> new ResourceNotFoundException("Baia", "id", baiaId));
        baia.setAge(model.getAge());
        baia.setName(model.getName());
        baia.setStatus(model.isStatus());
        Baia updateBaia = baiaRepository.save(baia);
        
        return updateBaia; 
    }
    
    /**
     * Cria uma nova instância de Baia
     * @param baia
     * @return Objeto Baia criado
     */
    public Baia createBaia(Baia baia) {
        Baia createdBaia = baiaRepository.save(baia);
        return createdBaia;
    }
        
    /**
     * Método que aplica as regras de negócios nos sensores que compõem a Baia
     * @param baia 
     */
    private void verifySensors(Baia baia) {
        temperaturaService.verifySensor(baia.getTemperatura());
        alimentoService.verifySensor(baia.getAlimento());
        aguaService.verifySensor(baia.getAgua());
    }
    
    /**
     * Busca por todas as instâncias de Baia
     * @return Lista com todos os objetos Baia
     */
    public List<Baia> getAllBaias(){
        List<Baia> baias =  baiaRepository.findAll();
        
        for (Baia b : baias) {
            verifySensors(b);
        }
        return baias;
    }
    
}