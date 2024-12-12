package com.leandro.app_cardapio_back.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDTO(
    Long id,
    @NotNull @NotBlank  @Length(min = 2, max = 100) String nomeProduto,
    @NotNull @NotBlank  @Length(min = 2, max = 100) String marcaProduto
) {

}
