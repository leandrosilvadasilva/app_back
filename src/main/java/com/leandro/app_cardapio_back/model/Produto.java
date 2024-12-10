package com.leandro.app_cardapio_back.model;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotBlank
    @NotNull
    @Length(min = 2, max = 100)
    @Column(length = 100, nullable = false)
    private String nomeProduto;
    
    //@Length(max = 100)
    //@Enumerated(EnumType.STRING)
    //@Convert(converter = MarcaConverter.class)
    @NotNull
    @Column(length = 100, nullable = false)
    private String marcaProduto;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fichaTec_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private FichaTec fichaTec;

}
