package com.leandro.app_cardapio_back.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.leandro.app_cardapio_back.dto.FichaTecDTO;
import com.leandro.app_cardapio_back.dto.mapper.FichaTecMapper;
import com.leandro.app_cardapio_back.exception.RecordNotFoundException;
import com.leandro.app_cardapio_back.model.FichaTec;
import com.leandro.app_cardapio_back.repository.FichaTecRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class FichaTecService {

    private final FichaTecRepository insumoRepository;
    private final FichaTecMapper insumoMapper;
    
    public FichaTecService(FichaTecRepository insumoRepository, FichaTecMapper insumoMapper){
        this.insumoRepository = insumoRepository;
        this.insumoMapper = insumoMapper;
    }

    public List<FichaTecDTO> list(){
        return insumoRepository.findAll()
            .stream()
            .map(insumoMapper::toDTO)
            .collect(Collectors.toList());
    }

    public FichaTecDTO findById(@NotNull @Positive Long id){

        return insumoRepository.findById(id)
        .map(insumoMapper::toDTO)
        .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public FichaTecDTO create(@Valid @NotNull FichaTecDTO insumo){

        return insumoMapper.toDTO(insumoRepository.save(insumoMapper.toEntity(insumo)));
    }

    public FichaTecDTO update(@NotNull @Positive Long id, 
            @Valid @NotNull FichaTecDTO fichaTecDTO){
          
        return insumoRepository.findById(id)
            .map(recordFound -> {
                FichaTec fichaTec = insumoMapper.toEntity(fichaTecDTO);
                recordFound.setNome_insumo(fichaTecDTO.nome_insumo());   
                recordFound.setMarca_insumo(insumoMapper.convertMarcaValue(fichaTecDTO.marca_insumo()));
                //recordFound.setProdutos(fichaTec.getProdutos());    
                recordFound.getProdutos().clear();
                fichaTec.getProdutos().forEach(recordFound.getProdutos()::add);
                return insumoMapper.toDTO(insumoRepository.save(recordFound));
             }).orElseThrow(() -> new RecordNotFoundException(id));
                  
    }


    public void delete(@NotNull @Positive Long id){
        insumoRepository.delete(insumoRepository.findById(id)
            .orElseThrow(() -> new RecordNotFoundException(id)));
            
        }
    }
