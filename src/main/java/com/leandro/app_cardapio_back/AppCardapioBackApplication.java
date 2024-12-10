package com.leandro.app_cardapio_back;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.leandro.app_cardapio_back.enums.Marca;
import com.leandro.app_cardapio_back.model.FichaTec;
import com.leandro.app_cardapio_back.model.Produto;
import com.leandro.app_cardapio_back.repository.FichaTecRepository;

@SpringBootApplication
public class AppCardapioBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppCardapioBackApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(FichaTecRepository insumoRepository){
		return args -> {
			insumoRepository.deleteAll();

			FichaTec i = new FichaTec();
			
			i.setNome_insumo("Patinho");
			i.setMarca_insumo(Marca.FE);
			
			Produto p = new Produto();
			p.setMarcaProduto("Zaffari");
			p.setNomeProduto("Arroz");
			p.setFichaTec(i);
			i.getProdutos().add(p);


			Produto p2 = new Produto();
			p2.setMarcaProduto("Granja");
			p2.setNomeProduto("Ovo");
			p2.setFichaTec(i);
			i.getProdutos().add(p2);

			insumoRepository.save(i);
		};

	}

}
