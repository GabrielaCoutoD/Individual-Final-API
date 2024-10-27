package br.com.serratec.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Endereco {
//6 ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Schema(description = "Identificador único do endereco")
	private Long id;
	@Schema(description = "Código de endereçamento postal")
	private String cep;
	@Schema(description = "Ruas, avenidas, praças, viadutos ou travessas que dão acesso ao lote")
	private String logradouro;
	@Schema(description = "Comunidade ou região dentro de uma cidade ou município")
	private String bairro;
	@Schema(description = "Espaço territorial político dentro de um estado ou unidade federativa")
	private String localidade;
	@Schema(description = "Refere-se aos 26 estados brasileiros, mais o Distrito Federal")
	private String uf;
	
//gets sets
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
}
