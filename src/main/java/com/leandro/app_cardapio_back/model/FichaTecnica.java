package com.leandro.app_cardapio_back.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class FichaTecnica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(length = 100, nullable = false)
    private String nomeFicha;

    @Column(length = 100, nullable = false)
    private double quantidadeLiquida;

    @Column(length = 100, nullable = false)
    private String unidade;

    @Column(length = 100, nullable = false)
    private double precoBruto;

    @Column(length = 100, nullable = false)
    private double quantidadeBruta;

    @Column(length = 100, nullable = false)
    private double precoLiquido;


}
