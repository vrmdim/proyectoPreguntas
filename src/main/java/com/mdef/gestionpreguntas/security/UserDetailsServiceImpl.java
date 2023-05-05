package com.mdef.gestionpreguntas.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mdef.gestionpreguntas.repositorios.UsuarioRepositorio;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private UsuarioRepositorio repositorio;
	
	public UserDetailsServiceImpl(UsuarioRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//System.err.println(username);
		return repositorio.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(
						"Usuario " + username + " no encontrado"));
	}

}