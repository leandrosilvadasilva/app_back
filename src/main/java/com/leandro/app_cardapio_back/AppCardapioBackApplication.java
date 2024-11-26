package com.leandro.app_cardapio_back;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.leandro.app_cardapio_back.model.Insumo;
import com.leandro.app_cardapio_back.repository.InsumoRepository;

@SpringBootApplication
public class AppCardapioBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppCardapioBackApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(InsumoRepository insumoRepository){
		return args -> {
			insumoRepository.deleteAll();

			Insumo i = new Insumo();
			i.setNomeInsumo("Patinho");
			i.setMarcaInsumo("Zaffari");
			i.setPrecoInsumo(34.50);
			i.setQuantidadeInsumo(1400);

			insumoRepository.save(i);
		};

	}

}
