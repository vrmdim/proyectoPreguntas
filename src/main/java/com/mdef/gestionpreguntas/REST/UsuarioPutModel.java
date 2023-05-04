package com.mdef.gestionpreguntas.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.mdef.gestionpreguntas.entidades.NoAdministrador.Departamento;
import com.mdef.gestionpreguntas.entidades.NoAdministrador.Tipo;
import com.mdef.gestionpreguntas.entidades.Usuario.Role;


@Relation(itemRelation = "usuario")
public class UsuarioPutModel extends RepresentationModel<UsuarioPutModel>{
	
	private String nombre;
	private String nombreUsuario;
	private Departamento departamento;
	private Tipo tipo;
	private String telefono;
	private Role role;
	
	// SECURITY
	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;
	

	public String getNombre() {
		return nombre;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "UsuarioPutModel [nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", departamento="
				+ departamento + ", tipo=" + tipo + ", telefono=" + telefono + ", role=" + role + "]";
	}
	
	
	// METODOS SEGURIDAD
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


}
