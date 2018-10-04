package com.ipartek.formacion.youtube.pojo;

public class Usuario {
	
	private long id;
	private String nombre;
	private String password;
	
	private int rol;//TODO crear pojo y tabla rol
	
	public static final int ROL_ADMIN = 0;
	public static final int ROL_USER = 1;
	
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "admin";
		this.password = "admin";
		//this.rol = ROL_USER;
	}

		
	public Usuario(String nombre, String password) {
		this();
		this.id = -1;
		this.nombre = nombre.trim();
		this.password = password.trim();
		//this.rol = rol;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password.trim();
	}


	public int getRol() {
		return rol;
	}


	public void setRol(int rol) {
		this.rol = rol;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + ", rol=" + rol + "]";
	}

	
	
}