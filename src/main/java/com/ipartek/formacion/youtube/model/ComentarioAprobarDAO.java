package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Usuario;

public class ComentarioAprobarDAO implements CrudAble<Comentario> {

	private static ComentarioAprobarDAO INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT c.id, c.fecha, c.texto, c.id_video, u.nombre" + 
			" FROM comentario AS c, usuario u" + 
			" WHERE c.id_usuario=u.id AND aprobado=0;";
	private final String SQL_GET_BY_ID = "";
	private final String SQL_UPDATE = "";
	private final String SQL_DELETE = "";
	private final String SQL_INSERT = "";

	private ComentarioAprobarDAO() {
		super();
	}

	public static synchronized ComentarioAprobarDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ComentarioAprobarDAO();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Comentario pojo) throws Exception {
		return false;
	}

	@Override
	public List<Comentario> getAll() throws Exception {
		Comentario comentario = null;

		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				comentarios.add(rowMapper(rs));
			}

		} 

		return comentarios;
	}

	public List<Comentario> getAllByVideo(long videoId) throws Exception {
		return null;
		
	}

	@Override
	public Comentario getById(long id) throws Exception {
		return null;
	
	}

	@Override
	public boolean update(Comentario pojo) throws Exception {

		return false;
	}

	@Override
	public boolean delete(long id) throws Exception {
		return false;
	}

	private Comentario rowMapper(ResultSet rs) throws Exception {
		Comentario c= new Comentario();
		if (rs != null) {
			c.setId(rs.getLong("id"));
			c.setFecha(rs.getTimestamp("fecha"));
			c.setTexto(rs.getString("texto"));
			
			Usuario u = new Usuario();
			u.setNombre(rs.getString("nombre"));
			c.setUsuario(u);
		}
		return c;
		
	}

}
