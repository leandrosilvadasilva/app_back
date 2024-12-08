package com.leandro.app_cardapio_back.exception;

public class RecordNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(Long id){
        super("Registro não encontrado com o id: " + id) ;
    }
    
}
