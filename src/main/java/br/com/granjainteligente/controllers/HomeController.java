/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.granjainteligente.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author fbalascio
 */
@Controller
public class HomeController {
    
    @RequestMapping("/")
    public String index(){
        System.out.println("indo para home");
        return "home";
    }
}
