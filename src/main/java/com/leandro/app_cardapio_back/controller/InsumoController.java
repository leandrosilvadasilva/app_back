package com.leandro.app_cardapio_back.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.app_cardapio_back.dto.InsumoDTO;
import com.leandro.app_cardapio_back.service.InsumoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;



@Validated
@RestController
@RequestMapping("/api/insumos")
public class InsumoController {


    private final InsumoService insumoService;

    public InsumoController(
           InsumoService insumoService)
        {
        this.insumoService = insumoService;
    }

    @GetMapping
    public List<InsumoDTO> list(){
        return insumoService.list();
    }

    @GetMapping("/{id}")
    public InsumoDTO findById(@PathVariable @NotNull @Positive Long id){

        return insumoService.findById(id);
    }

    //@RequestMapping("path", method=RequestMethod.POST)
    @PostMapping
    @ResponseStatus(code =  HttpStatus.CREATED)
    public InsumoDTO create(@RequestBody @Valid @NotNull InsumoDTO insumo){
        //System.out.println(insumo.getNome_insumo());
        return insumoService.create(insumo);
        //return ResponseEntity.status(HttpStatus.CREATED)
        //.body(insumoRepository.save(insumo));
    }

    @PutMapping("/{id}")
    public InsumoDTO update(@PathVariable @NotNull @Positive Long id, 
            @RequestBody @Valid InsumoDTO insumo){
          
        return insumoService.update(id, insumo);
            //.map(recordFound -> ResponseEntity.ok().body(recordFound))
              //  .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code =  HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id){
        
        insumoService.delete(id);

        /*if (insumoService.delete(id)){
            return ResponseEntity.noContent().<Void>build();        
        }
            return (ResponseEntity.notFound().build());*/
    }
}