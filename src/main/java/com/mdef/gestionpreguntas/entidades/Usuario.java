package com.mdef.gestionpreguntas.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIOS")
//Herencia Administrador / NoAdministrador
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_usuario", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("null")
public class Usuario {
	
	public static enum Role {
		Administrador,
		NoAdministrador
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private String nombre;
	private String nombreUsuario;
	private String contrasena;
	private Role role;
	
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", contrasena="
				+ contrasena + "]";
	}
	
	
}

