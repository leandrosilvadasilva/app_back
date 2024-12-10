package com.leandro.app_cardapio_back.enums;

public enum Marca {
    
    BE("BE"), FE("FE");

    private String value;

    private Marca(String value){
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

