/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.Service;

import br.com.granjainteligente.granja.Exception.ResourceNotFoundException;
import br.com.granjainteligente.granja.Repository.AlimentoRepository;
import br.com.granjainteligente.granja.model.Alimento;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;

public class AlimentoService {

    @Autowired
    AlimentoRepository alimentoRepository;
    @Autowired
    SensorService sensorService;

    /**
     * Busca pelo objeto que possui o id indicado
     * @param id
     * @return Sensor Alimento com o id requisitado
     */
    public Alimento getAlimento(long id) {
        return alimentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Alimento", "id", id));
    }

    /**
     * Atualiza o objeto que possui o id indicado
     * @param alimentoId
     * @param model
     * @return Objeto Alimento atualizado
     */
    public Alimento updateAlimento(long alimentoId, Alimento model) {

        Alimento sensor = alimentoRepository.findById(alimentoId).orElseThrow(() -> new ResourceNotFoundException("Alimento", "id", alimentoId));
        sensor = (Alimento) sensorService.update(sensor, model);
        sensor.setNivel(model.getNivel());
        sensor.setNivelSet(model.getNivelSet());
        Alimento updateAlimento = alimentoRepository.save(sensor);

        return updateAlimento;
    }

    /**
     * Cria uma nova instância de Alimento
     * @param alimento
     * @return Objeto Alimento criado
     */
    public Alimento createAlimento(Alimento alimento) {
        Alimento createdAlimento = alimentoRepository.save(alimento);
        return createdAlimento;
    }

    /**
     * Busca por todas as intâncias de Alimento
     * @return Lista com todos os objetos Alimento
     */
    public List<Alimento> getAllAlimentos() {
        List<Alimento> alimentos = alimentoRepository.findAll();
        //verificar aqui? foreach alimento verifySensors
        return alimentos;
    }

    /**
     * Método que aplica as regras de negócio para o sensor
     * Simulando a alteração nos valores, em resposta
     * @param alimento
     * @return sensor com dados atualizados em resposta às regras de negócio
     */
    public Alimento verifySensor(Alimento alimento) {
        if (alimento != null && alimento.isAuto()) {
            float currNivel = alimento.getNivel();
            Random rand = new Random();
            if (currNivel < alimento.getNivelSet()) {
                // aumenta o nivel do alimento em ate 5 por cento
                alimento.setNivel((5 * rand.nextFloat()) + currNivel);
            }
            return updateAlimento(alimento.getId(), alimento);
        } else {
            return null;
        }
    }

}
