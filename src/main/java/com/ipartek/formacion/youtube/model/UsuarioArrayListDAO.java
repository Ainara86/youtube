package com.ipartek.formacion.youtube.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;



public class UsuarioArrayListDAO  {
	private static List<Usuario> usuario = null;
	
	private UsuarioArrayListDAO() {
		usuario = new ArrayList<Usuario>();
		try {
			usuario.add(new Usuario("Pepe", "Pepe"));
			usuario.add(new Usuario("Manoli", "Manoli"));
			usuario.add(new Usuario("Josepe", "Josepe"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public List<Usuario> getAll() {
		return usuario;
	}
	
	
}
