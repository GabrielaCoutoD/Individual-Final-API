package br.com.serratec.seguranca;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.serratec.entity.Usuario;
import br.com.serratec.repository.UsuarioRepository;


@Component
public class DetalheService implements UserDetailsService {
	@Autowired
	private UsuarioRepository repository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    Usuario usuario = this.repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));
	    return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getSenha(), new ArrayList<>());
	}	
}