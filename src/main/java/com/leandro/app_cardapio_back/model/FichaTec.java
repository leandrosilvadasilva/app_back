package com.leandro.app_cardapio_back.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.validator.constraints.Length;

import com.leandro.app_cardapio_back.enums.Marca;
import com.leandro.app_cardapio_back.enums.Status;
import com.leandro.app_cardapio_back.enums.converters.MarcaConverter;
import com.leandro.app_cardapio_back.enums.converters.StatusConverter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;



//@Table(name = "insumos") Se precisar nomear diferente do nome da classe


@Entity
@SQLDelete(sql = "UPDATE Insumo SET status = 'Inativo' WHERE id = ?")
@SQLRestriction("status <> 'Inativo'")
public class FichaTec {

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
    @Column(length = 10, nullable = false)
    //@Enumerated(EnumType.STRING)
    @Convert(converter = MarcaConverter.class)
    private Marca marca_insumo;


    @NotNull
    //@Length(max = 10)
    //@Pattern(regexp = "Ativo|Inativo")
    @Column(length = 10, nullable = false)
    @Convert(converter = StatusConverter.class)
    private Status status = Status.ATIVO;

    
    @NotNull
    @NotEmpty
    @Valid
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "fichaTec")
    private List<Produto> produtos = new ArrayList<>();


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNome_insumo() {
        return nome_insumo;
    }


    public void setNome_insumo(String nome_insumo) {
        this.nome_insumo = nome_insumo;
    }


    public Marca getMarca_insumo() {
        return marca_insumo;
    }


    public void setMarca_insumo(Marca marca_insumo) {
        this.marca_insumo = marca_insumo;
    }


    public Status getStatus() {
        return status;
    }


    public void setStatus(Status status) {
        this.status = status;
    }


    public List<Produto> getProdutos() {
        return produtos;
    }


    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }










    
}
