package br.com.serratec.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.serratec.exception.EnumException;

public enum StatusPedido {
	
	    REALIZADO,
	    PROCESSANDO,
	    ENVIADO,
	    ENTREGUE,
	    CANCELADO;
	    
	    @JsonCreator
		public static StatusPedido verificar(String valor) {
			for (StatusPedido s : StatusPedido.values()) {
				if (s.name().equalsIgnoreCase(valor)) {
					return s;
				}
			}
			throw new EnumException("Status inválido");
		}		
	}
