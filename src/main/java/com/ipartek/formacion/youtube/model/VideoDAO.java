package com.ipartek.formacion.youtube.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Video;

public class VideoDAO implements CrudAble<Video> {

	@Override
	public boolean insert(Video pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Video> getAll() {
		ArrayList<Video> videos = new ArrayList<Video>();
		try {
			//obtener conexion
			
			//Ejecutar SQL
			String sql="SELECT id, codigo, nombre FROM video ORDER BY id DESC;";
			
			//Obtener resultados ResulSet
			
			
			//Mapear ResulSet a ArrayList
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return videos;
	}

	@Override
	public Video getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Video pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
