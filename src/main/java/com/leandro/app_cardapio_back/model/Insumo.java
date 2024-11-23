package com.leandro.app_cardapio_back.model;


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
    private Long id;

    @Column(name = "nome_insumo")
    private String nomeInsumo;
    
    @Column(name = "marca_insumo", length = 45, nullable = false)
    private String marcaInsumo;
    
    @Column(name = "preco_insumo", length = 45, nullable = false)
    private String precoInsumo;
    
    @Column(name = "quantidade_insumo", length = 45, nullable = false)
    private String quantidadeInsumo;
    
}
