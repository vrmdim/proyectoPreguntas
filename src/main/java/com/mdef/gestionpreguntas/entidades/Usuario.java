package com.mdef.gestionpreguntas.entidades;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class Usuario implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	public static enum Role {
		Administrador,
		NoAdministrador
	}
	
	private Long id;
	private String nombre;
	private String username;
	private String password;
	private Role role;

	List<Pregunta> preguntas;
	
	// VARIABLES SECURITY JWT
	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;

	
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setUsername(String nombreUsuario) {
		this.username = nombreUsuario;
	}
	public void setPassword(String contrasena) {
		this.password = contrasena;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", nombreUsuario=" + username + ", contrasena="
				+ password + ", role=" + role + ", preguntas=" + preguntas + "]";
	}

	// METODOS DE SEGURiDAD
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<SimpleGrantedAuthority>(
				Arrays.asList(new SimpleGrantedAuthority(getRole().toString()))
				);
	}
	
}

