package com.leandro.app_cardapio_back.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.validator.constraints.Length;

import com.leandro.app_cardapio_back.enums.Marca;
import com.leandro.app_cardapio_back.enums.converters.MarcaConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

//@Table(name = "insumos") Se precisar nomear diferente do nome da classe

@Data
@Entity
@SQLDelete(sql = "UPDATE Insumo SET status = 'Inativo' WHERE id = ?")
@SQLRestriction("status <> 'Inativo'")
public class Insumo {

    //@JsonProperty("cod_insumo")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 2, max = 100)
    @Column(name = "nome_insumo", length = 100, nullable = false)
    private String nome_insumo;
    
    @NotNull
    //@Length(max = 100)
    //@Pattern(regexp = "BE|FE")
    @Column(length = 10, nullable = false)
    //@Enumerated(EnumType.STRING)
    @Convert(converter = MarcaConverter.class)
    private Marca marca_insumo;


    /*@NotNull
    @Length(max = 100)
    @Pattern(regexp = "BE|FE")
    @Column(name = "marca_insumo", length = 100, nullable = false)
    private String marca_insumo;*/



    //@NotNull
    //@Length(max = 100)
    //@Column(name = "marca_insumo", length = 100, nullable = false)
    //private String unidade_insumo;


    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "Ativo|Inativo")
    @Column(length = 10, nullable = false)
    private String status = "Ativo";

    
    /*@Column(name = "preco_insumo", length = 12, nullable = false)
    private double precoInsumo;//decimal no postgres
    
    @Column(name = "quantidade_insumo", length = 12, nullable = false)
    private int quantidadeInsumo;*/

    //tipo_unidade int not null REFERENCES unidade (id_unidade)
    //tabela de unidade do insumo
    
}
