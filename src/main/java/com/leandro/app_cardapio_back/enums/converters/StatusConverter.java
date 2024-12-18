package com.leandro.app_cardapio_back.enums.converters;

import com.leandro.app_cardapio_back.enums.Status;

import java.util.stream.Stream;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;



@Converter(autoApply =  true)
public class StatusConverter implements AttributeConverter<Status, String>{

    @Override
    public String convertToDatabaseColumn(Status status) {
        
        if(status == null){
            return null;
        }

        
        return status.getValue();
    }

    @Override
    public Status convertToEntityAttribute(String value) {
        
        if(value == null){
            return null;
        }
        return Stream.of(Status.values())
            .filter(c -> c.getValue().equals(value))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
    
    
}
