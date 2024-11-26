package com.leandro.app_cardapio_back.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


//@Table(name = "insumos") Se precisar nomear diferente do nome da classe
@Data
@Entity
public class Insumo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@JsonProperty("cod_insumo")
    private Long id;

    @Column(name = "nome_insumo", length = 45, nullable = false)
    private String nomeInsumo;
    
    @Column(name = "marca_insumo", length = 45, nullable = false)
    private String marcaInsumo;
    
    @Column(name = "preco_insumo", length = 12, nullable = false)
    private double precoInsumo;//decimal no postgres
    
    @Column(name = "quantidade_insumo", length = 12, nullable = false)
    private int quantidadeInsumo;

    //tipo_unidade int not null REFERENCES unidade (id_unidade)
    //tabela de unidade do insumo
    
}
