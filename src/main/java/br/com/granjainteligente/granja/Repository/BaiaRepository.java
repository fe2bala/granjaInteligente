/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.granja.Repository;

import br.com.granjainteligente.granja.model.Baia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaiaRepository extends JpaRepository<Baia,Long>{
    
}
