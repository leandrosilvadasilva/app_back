package com.leandro.app_cardapio_back.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record FichaTecDTO(
    Long id, 
    @NotBlank @NotNull @Length(min = 2, max = 100) String nome_insumo,
    @NotNull @Length(max = 100) @Pattern(regexp = "BE|FE")String marca_insumo,
    List<ProdutoDTO> produtos
    ) {
}
