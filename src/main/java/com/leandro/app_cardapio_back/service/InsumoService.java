package com.leandro.app_cardapio_back.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.leandro.app_cardapio_back.dto.InsumoDTO;
import com.leandro.app_cardapio_back.dto.mapper.InsumoMapper;
import com.leandro.app_cardapio_back.enums.Marca;
import com.leandro.app_cardapio_back.exception.RecordNotFoundException;
import com.leandro.app_cardapio_back.repository.InsumoRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class InsumoService {

    private final InsumoRepository insumoRepository;
    private final InsumoMapper insumoMapper;
    
    public InsumoService(InsumoRepository insumoRepository, InsumoMapper insumoMapper){
        this.insumoRepository = insumoRepository;
        this.insumoMapper = insumoMapper;
    }

    public List<InsumoDTO> list(){
        return insumoRepository.findAll()
            .stream()
            .map(insumoMapper::toDTO)
            .collect(Collectors.toList());
    }

    public InsumoDTO findById(@PathVariable @NotNull @Positive Long id){

        return insumoRepository.findById(id)
        .map(insumoMapper::toDTO)
        .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public InsumoDTO create(@Valid @NotNull InsumoDTO insumo){
        //System.out.println(insumo.getNome_insumo());
        return insumoMapper.toDTO(insumoRepository.save(insumoMapper.toEntity(insumo)));
        //return ResponseEntity.status(HttpStatus.CREATED)
        //.body(insumoRepository.save(insumo));
    }

    public InsumoDTO update(@NotNull @Positive Long id, 
            @Valid @NotNull InsumoDTO insumo){
          
        return insumoRepository.findById(id)
            .map(recordFound -> {
                recordFound.setNome_insumo(insumo.nome_insumo());   
                recordFound.setMarca_insumo(Marca.BE);
                //recordFound.setMarca_insumo(insumo.marca_insumo());
                return insumoMapper.toDTO(insumoRepository.save(recordFound));
             }).orElseThrow(() -> new RecordNotFoundException(id));
                  
    }


    public void delete(@PathVariable @NotNull @Positive Long id){
        insumoRepository.delete(insumoRepository.findById(id)
            .orElseThrow(() -> new RecordNotFoundException(id)));


      /*   insumoRepository.findById(id)
        .map(recordFound -> {
                insumoRepository.deleteById(id);
                return true;
            }).orElseThrow(() -> new RecordNotFoundException(id));
            */
            
        }
    }
