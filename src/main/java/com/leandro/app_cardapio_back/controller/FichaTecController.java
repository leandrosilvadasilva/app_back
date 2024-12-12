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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.app_cardapio_back.dto.FichaTecDTO;
import com.leandro.app_cardapio_back.dto.FichaTecPageDTO;
import com.leandro.app_cardapio_back.service.FichaTecService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;



@Validated
@RestController
@RequestMapping("/api/insumos")
public class FichaTecController {


    private final FichaTecService insumoService;

    public FichaTecController(
           FichaTecService insumoService)
        {
        this.insumoService = insumoService;
    }

    @GetMapping
    public FichaTecPageDTO list(@RequestParam(defaultValue = "0" ) @PositiveOrZero int page, 
                @RequestParam(defaultValue = "10" ) @Positive @Max(100) int size){
        
                return insumoService.list(page, size);
    }


  //  @GetMapping
   // public FichaTecPageDTO list(){
   //     return insumoService.list();
    //}

    @GetMapping("/{id}")
    public FichaTecDTO findById(@PathVariable @NotNull @Positive Long id){

        return insumoService.findById(id);
    }

    
    @PostMapping
    @ResponseStatus(code =  HttpStatus.CREATED)
    public FichaTecDTO create(@RequestBody @Valid @NotNull FichaTecDTO insumo){
    
        return insumoService.create(insumo);
    
    }

    @PutMapping("/{id}")
    public FichaTecDTO update(@PathVariable @NotNull @Positive Long id, 
            @RequestBody @Valid FichaTecDTO insumo){
          
        return insumoService.update(id, insumo);
    
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code =  HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id){
        
        insumoService.delete(id);

    }
}