package com.leandro.app_cardapio_back.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.leandro.app_cardapio_back.enums.Marca;
import com.leandro.app_cardapio_back.enums.validation.ValueOfEnum;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public record FichaTecDTO(
    Long id, 
    @NotBlank @NotNull @Length(min = 2, max = 100) String nome_insumo,
    @NotNull @Length(max = 100) @ValueOfEnum(enumClass = Marca.class ) String marca_insumo,
    @NotNull @NotEmpty @Valid List<ProdutoDTO> produtos
    ) {
}
