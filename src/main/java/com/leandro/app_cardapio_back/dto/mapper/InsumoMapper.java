package com.leandro.app_cardapio_back.dto.mapper;

import org.springframework.stereotype.Component;

import com.leandro.app_cardapio_back.dto.InsumoDTO;
import com.leandro.app_cardapio_back.enums.Marca;
import com.leandro.app_cardapio_back.model.Insumo;

@Component
public class InsumoMapper {

    public InsumoDTO toDTO(Insumo insumo){
        if(insumo == null){
            return null;
        }
        return new InsumoDTO(insumo.getId(), insumo.getNome_insumo(), insumo.getMarca_insumo().getValue());
        // insumo.getMarca_insumo());
    }

    public Insumo toEntity(InsumoDTO insumoDTO){
        
        if(insumoDTO == null){
            return null;
        }

        Insumo insumo = new Insumo();
        if (insumoDTO.id() != null){
            insumo.setId(insumoDTO.id());
        }
        insumo.setNome_insumo(insumoDTO.nome_insumo());
        
        insumo.setMarca_insumo(convertMarcaValue(insumoDTO.marca_insumo()));
        
        //insumo.setStatus("Ativo");
        //insumo.setMarca_insumo(insumoDTO.marca_insumo());
        return insumo;
    }

    public Marca convertMarcaValue(String value){
        if(value == null){
            return null;
        }
        return switch (value){
            case "BE" -> Marca.BE;
            case "FE" -> Marca.FE;
            default -> throw new IllegalArgumentException("Marca Inválida" + value);
        };

    }

}
