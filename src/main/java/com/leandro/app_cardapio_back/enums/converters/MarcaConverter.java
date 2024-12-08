package com.leandro.app_cardapio_back.enums.converters;

import com.leandro.app_cardapio_back.enums.Marca;

import java.util.stream.Stream;

import jakarta.persistence.AttributeConverter;

import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MarcaConverter implements AttributeConverter<Marca, String>{

    @Override
    public String convertToDatabaseColumn(Marca marca) {
        
        if(marca == null){
            return null;
        }

        
        return marca.getValue();
    }

    @Override
    public Marca convertToEntityAttribute(String value) {
        
        if(value == null){
            return null;
        }
        return Stream.of(Marca.values())
            .filter(c -> c.getValue().equals(value))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
    
    
}
