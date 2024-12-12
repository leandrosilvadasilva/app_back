package com.leandro.app_cardapio_back.dto;

import java.util.List;

public record FichaTecPageDTO(List<FichaTecDTO> insumos, long totalElements, int totalPages) {
    
}
