package com.leandro.app_cardapio_back.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.app_cardapio_back.model.Insumo;
import com.leandro.app_cardapio_back.repository.InsumoRepository;

import lombok.AllArgsConstructor;




//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/insumos")
@AllArgsConstructor
public class InsumoController {

   
    private final InsumoRepository insumoRepository;
 
    @GetMapping
    public @ResponseBody List<Insumo> list(){
        return insumoRepository.findAll();
    }
}
