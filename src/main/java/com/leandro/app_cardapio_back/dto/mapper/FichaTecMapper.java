package com.leandro.app_cardapio_back.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.leandro.app_cardapio_back.dto.FichaTecDTO;
import com.leandro.app_cardapio_back.dto.ProdutoDTO;
import com.leandro.app_cardapio_back.enums.Marca;
import com.leandro.app_cardapio_back.model.FichaTec;

@Component
public class FichaTecMapper {

    public FichaTecDTO toDTO(FichaTec fichaTec){
        if(fichaTec == null){
            return null;
        }

        List<ProdutoDTO> produtos = fichaTec.getProdutos()
            .stream()
            .map(produto -> new ProdutoDTO(produto.getId(), produto.getNomeProduto(), 
                produto.getMarcaProduto()))
                .collect(Collectors.toList());
        return new FichaTecDTO(fichaTec.getId(), fichaTec.getNome_insumo(), 
            fichaTec.getMarca_insumo().getValue(),
            produtos
        );
        // insumo.getMarca_insumo());
    }

    public FichaTec toEntity(FichaTecDTO fichaTecDTO){
        
        if(fichaTecDTO == null){
            return null;
        }

        FichaTec insumo = new FichaTec();
        if (fichaTecDTO.id() != null){
            insumo.setId(fichaTecDTO.id());
        }
        insumo.setNome_insumo(fichaTecDTO.nome_insumo());
        
        insumo.setMarca_insumo(convertMarcaValue(fichaTecDTO.marca_insumo()));
        
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
