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
        return new InsumoDTO(insumo.getId(), insumo.getNome_insumo(), "BE");
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
        insumo.setMarca_insumo(Marca.FE);
        //insumo.setMarca_insumo(insumoDTO.marca_insumo());
        return insumo;
    }

}
