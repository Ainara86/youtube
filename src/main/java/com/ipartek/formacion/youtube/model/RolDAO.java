package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Rol;
import com.ipartek.formacion.youtube.pojo.Usuario;

public class RolDAO implements CrudAbleRol<Rol> {

	private static RolDAO INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT `id`, `nombre` FROM rol ORDER BY id DESC LIMIT 500;";
	private final String SQL_GET_BY_ID = "SELECT `id`, `nombre` FROM rol WHERE id = ?;";
	private final String SQL_UPDATE = "UPDATE rol SET nombre = ? WHERE id = ?;";
	private final String SQL_DELETE = "DELETE FROM rol WHERE id=?;";
	private final String SQL_INSERT = "INSERT INTO rol (nombre) VALUES (?);";

	private RolDAO() {
		super();
	}

	public static synchronized RolDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RolDAO();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Rol pojo) throws Exception {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
;
			ps.setString(1, pojo.getNombre().trim());
			

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
	public List<Rol> getAll() throws Exception {

		ArrayList<Rol> r = new ArrayList<Rol>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				r.add(rowMapper(rs, null));
			}

		}

		return r;
	}

	@Override
	public Rol getById(String id) throws Exception {
		Rol r = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {

			ps.setString(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					r = rowMapper(rs, r);
				}
			}

		}

		return r;
	}

	@Override
	public boolean update(Rol pojo) throws Exception {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

			ps.setString(1, pojo.getNombre());
			ps.setLong(2, pojo.getId());
			
			

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				resul = true;

			}

		}
		return resul;
	}
	
	public boolean delete(String id) throws Exception {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);) {

			ps.setString(1, id);
			if (ps.executeUpdate() == 1) {
				resul = true;
			}

		}
		return resul;
	}


	private Rol rowMapper(ResultSet rs, Rol r) throws Exception {

		if (r == null) {
			r = new Rol();
		}

		if (rs != null) {
			r.setId(rs.getLong("id"));
			r.setNombre(rs.getString("nombre"));
		}
		return r;
	}

	@Override
	public Rol getById(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}