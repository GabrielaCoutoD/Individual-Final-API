package br.com.serratec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AtividadeEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtividadeEcommerceApplication.class, args);
	}

}
/*
IDEIAS PARA O INDIVIDUAL

CONFIRMADOR DE SENHA (DTO e Service)
Uma entidade pode ter mais de um DTO, para atender situações diferentes. 
Como por exemplo, a entidade Usuario pode ter um UsuarioInsertDTO que além da
senha tenha um outro atributo confirmaSenha, e o service faria a verificação 
se as senhas são idênticas, se não forem ele poderia lançar a exceção
SenhasNaoBatemException.
*/