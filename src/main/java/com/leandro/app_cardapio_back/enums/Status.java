package com.leandro.app_cardapio_back.enums;

public enum Status {
    
    ATIVO("Ativo"), INATIVO("INativo");

    private String value;

    private Status(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    @Override
    public String toString(){
        return value;
    }
}
