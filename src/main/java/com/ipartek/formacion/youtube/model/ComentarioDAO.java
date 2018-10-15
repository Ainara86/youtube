package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;
import com.mysql.jdbc.Statement;

public class ComentarioDAO implements CrudAble<Comentario> {

	private static ComentarioDAO INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT c.id as 'id_comentario', u.id as 'id_usuario', fecha, texto, aprobado, u.nombre, c.id_video as 'id_video', v.nombre"+
			" FROM comentario as c , usuario as u, video as v" + 
			" WHERE c.id_usuario = u.id AND c.id_video=v.id"+
			" ORDER BY c.id DESC LIMIT 500;";
	private final String SQL_GET_ALL_BY_VIDEO_ID = "SELECT 	c.id as 'id_comentario',    u.id as 'id_usuario',    fecha,    texto,    aprobado,    u.nombre "
			+ " FROM comentario as c , usuario as u " + " WHERE c.id_usuario = u.id AND "
			+ " c.id_video = ? AND aprobado = 1 " + " ORDER BY c.id DESC LIMIT 500;";
	private final String SQL_GET_BY_ID = "SELECT c.id as 'id_comentario', u.id as 'id_usuario', fecha, texto, aprobado, u.nombre "
			+ " FROM comentario as c , usuario as u " + " WHERE c.id_usuario = u.id AND "
			+ " c.id = ? " + " ORDER BY c.id DESC LIMIT 500;";
	private final String SQL_UPDATE = "UPDATE comentario SET aprobado= ? WHERE id = ?;";
	private final String SQL_DELETE = "DELETE FROM comentario WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO `comentario` (`texto`, `id_video`, `id_usuario`) VALUES (?,?,?);";
	private final String SQL_GET_ALL_APROBADOS = "SELECT c.id as 'id_comentario', c.fecha, c.texto, c.id_video, c.aprobado, u.id as 'id_usuario', u.nombre" + 
			" FROM comentario AS c, usuario u" + 
			" WHERE c.id_usuario=u.id AND aprobado=0;";
	
	private final String SQL_UPDATE_APROBADOS="UPDATE comentario SET aprobado= ? WHERE id = ?;";

	private ComentarioDAO() {
		super();
	}

	public static synchronized ComentarioDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ComentarioDAO();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Comentario pojo) throws Exception {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, pojo.getTexto().trim());
			ps.setLong(2, pojo.getVideo().getId());
			ps.setLong(3, pojo.getUsuario().getId());

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				try (ResultSet rs = ps.getGeneratedKeys()) {
					while (rs.next()) {
						pojo.setId(rs.getLong(1));
						resul = true;
					}
				}
			}

		}
		return resul;
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

		Comentario comentario = null;
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL_BY_VIDEO_ID);) {

			ps.setLong(1, videoId);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					comentarios.add(rowMapper(rs));
				}
			}

		}
		return comentarios;
	}

	public List<Comentario> getAllByAprobado() throws Exception {
		Comentario comentario = null;

		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL_APROBADOS);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				comentarios.add(rowMapper(rs));
			}

		} 

		return comentarios;
	}
	
	@Override
	public Comentario getById(long id) throws Exception {
		Comentario comentario = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {

			ps.setLong(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					comentario = rowMapper(rs);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return comentario;
	}

	@Override
	public boolean update(Comentario pojo) throws Exception {

		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE_APROBADOS);) {

			ps.setBoolean(1, pojo.isAprobado());
			ps.setLong(2, pojo.getId());

			if (ps.executeUpdate() == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	@Override
	public boolean delete(long id) throws Exception {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);) {

			ps.setLong(1, id);
			
			if (ps.executeUpdate() == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	private Comentario rowMapper(ResultSet rs) throws Exception {
		Comentario c= new Comentario();
		if (rs != null) {
			c.setId(rs.getLong("id_comentario"));
			c.setAprobado(rs.getBoolean("aprobado"));
			c.setFecha(rs.getTimestamp("fecha"));
			c.setTexto(rs.getString("texto"));
			
			Usuario u = new Usuario();
			u.setId(rs.getLong("id_usuario"));
			u.setNombre(rs.getString("nombre"));
			c.setUsuario(u);
		}
		return c;
		
	}

}
