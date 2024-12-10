package com.leandro.app_cardapio_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leandro.app_cardapio_back.model.FichaTec;

@Repository
public interface FichaTecRepository extends JpaRepository<FichaTec,Long>{
    
}

