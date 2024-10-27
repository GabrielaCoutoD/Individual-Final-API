package br.com.serratec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.serratec.dto.EnderecoResponseDTO;
import br.com.serratec.entity.Endereco;
import br.com.serratec.repository.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	private EnderecoRepository repository;
	
	//metodo para fazer a busca
	public EnderecoResponseDTO buscar(String cep) {
		//cep.replaceAll("-", ""); criticar os - e os .
		var endereco = Optional.ofNullable(repository.findByCep(cep));
		//var é tipo o infer, ele é qualquer coisa até receber o valor
		if(endereco.isPresent()) {
			return new EnderecoResponseDTO(endereco.get()); //esse que manda pro construtor cheio do dto
		}else {
			//para dados de terceiros como o via cep, utiliza o rest template
			RestTemplate rs = new RestTemplate();
			String uri = "https://viacep.com.br/ws/"+cep+"/json/";
			Optional<Endereco>enderecoViaCep = Optional.ofNullable(
					rs.getForObject(uri, Endereco.class));
								//pega no uri e passa pro Endereco.class
			if(enderecoViaCep.get().getCep() != null) {
				String cepSemTraco = enderecoViaCep.get().getCep()
						.replaceAll("-", "");
								//pega o "-" e torna ""
				enderecoViaCep.get().setCep(cepSemTraco);
				return inserir(enderecoViaCep.get());
				//ESSE RETURN CHAMA O MÉTODO PRIVATE ABAIXO
				//QUE INSERE OS DADOS NO BANCO COM O QUE
				//FOI ENCONTRADO E SALVO NO enderecoViaCep.get().setCep(cepSemTraco)
			}else {
				throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
			}
		}
	}	
	private EnderecoResponseDTO inserir(Endereco endereco) {
		endereco = repository.save(endereco);
		return new EnderecoResponseDTO(endereco);
	}
}
