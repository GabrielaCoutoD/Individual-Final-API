package br.com.serratec.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.serratec.exception.EnumException;

public enum EnumPreparo {
	QUENTE, AMBIENTE, GELADA;
	
	@JsonCreator
	public static EnumPreparo verificar(String valor) {
		for (EnumPreparo c : EnumPreparo.values()) {
			if (c.name().equals(valor)) {
				return c;
			}
		}
		throw new EnumException("Preparo inválido");
	}
	
}
