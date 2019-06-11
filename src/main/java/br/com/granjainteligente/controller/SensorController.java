package br.com.granjainteligente.controller;
import br.com.granjainteligente.model.Alimento;
import br.com.granjainteligente.model.Baia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController    
@RequestMapping("sensor")

public class SensorController {
    
    @PutMapping("/Alimento/{id}")
    public void Put(@PathVariable("id") int id,@RequestBody Alimento model){
        
    }
    
}
