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
    @NotBlank
    @Length(min = 2, max = 100)
    @Column(length = 100, nullable = false)
    private String marcaProduto;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fichaTec_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private FichaTec fichaTec;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNomeProduto() {
        return nomeProduto;
    }


    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }


    public String getMarcaProduto() {
        return marcaProduto;
    }


    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }


    public FichaTec getFichaTec() {
        return fichaTec;
    }


    public void setFichaTec(FichaTec fichaTec) {
        this.fichaTec = fichaTec;
    }


    @Override
    public String toString() {
        return "Produto [id=" + id + ", nomeProduto=" + nomeProduto + ", marcaProduto=" + marcaProduto + ", fichaTec="
                + fichaTec + "]";
    }




}
