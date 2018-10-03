package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;

public class UsuarioDAO implements CrudAble<Usuario> {

	private static UsuarioDAO INSTANCE = null;
//select * from usuario WHERE LTRIM(RTRIM(UPPER(LOWER(nombre))))=UPPER(LOWER("?"));
	private final String SQL_GET_ALL = "SELECT `id`, `nombre`, `password`, `rol` FROM usuario ORDER BY id DESC LIMIT 1000;";
	private final String SQL_GET_BY_ID = "SELECT `id`, `nombre`, `password`, `rol` FROM usuario WHERE id = ?;";
	private final String SQL_UPDATE = "UPDATE usuario SET nombre = ?, password = ? WHERE id = ?;";
	private final String SQL_DELETE = "DELETE FROM usuario WHERE id=?;";
	private final String SQL_INSERT = "INSERT INTO usuario (nombre, password) VALUES (? , ?);";
	private final String SQL_LOGIN = "SELECT `id`, `nombre`, `password`, `rol` FROM usuario WHERE nombre=? AND password=? ";

	private UsuarioDAO() {
		super();
	}

	public static synchronized UsuarioDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}
		return INSTANCE;
	}

	/**
	 * Comprueba que exista el nombre y password del usuario, case sensitive
	 * 
	 * @param pojo Usuario a comprobar
	 * @return null si no encuentra
	 */
	public Usuario login(Usuario pojo) {
		Usuario resul = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_LOGIN)) {

			ps.setString(1, pojo.getNombre());
			ps.setString(2, pojo.getPassword());

			try (ResultSet rs = ps.executeQuery()) {

				if (rs != null && rs.next()) {
					resul = rowMapper(rs, pojo);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	@Override
	public boolean insert(Usuario pojo) {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, pojo.getNombre().trim());
			ps.setString(2, pojo.getPassword().trim());

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				try (ResultSet rs = ps.getGeneratedKeys()) {
					while (rs.next()) {
						pojo.setId(rs.getLong(1));
						resul = true;
					}
				}
			} // affectedRows == 1

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	@Override
	public List<Usuario> getAll() {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				usuarios.add(rowMapper(rs, null));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	@Override
	public Usuario getById(String id) {
		Usuario usuario = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {

			ps.setString(1, id);

			/*
			 * try (ResultSet rs = ps.executeQuery()) { while (rs.next()) { usuario =
			 * rowMapper(rs); }
			 * 
			 * }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;
	}

	@Override
	public boolean update(Usuario pojo) {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

			ps.setString(1, pojo.getNombre());
			ps.setString(2, pojo.getPassword());
			ps.setLong(3, pojo.getId());

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				resul = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	@Override
	public boolean delete(long l) {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);) {

			ps.setLong(1, l);
			if (ps.executeUpdate() == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	private Usuario rowMapper(ResultSet rs, Usuario u) throws Exception {

		if (u == null) {
			u = new Usuario();
		}

		if (rs != null) {
			u.setId(rs.getLong("id"));
			u.setNombre(rs.getString("nombre"));
			u.setPassword(rs.getString("password"));
			u.setRol(rs.getInt("rol"));
		}
		return u;
	}

}