package br.com.serratec.dto;

import br.com.serratec.enums.UsuarioRole;

public record CadastroRequestDTO (String nome, String email, UsuarioRole role, String cpf, String senha) {}