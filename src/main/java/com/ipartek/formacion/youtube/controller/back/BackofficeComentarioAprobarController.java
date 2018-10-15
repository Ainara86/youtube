package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.ComentarioDAO;
import com.ipartek.formacion.youtube.model.RolDAO;
import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class BackofficeComentarioAprobarController
 */
@WebServlet("/backoffice/comentarios/aprobar")
public class BackofficeComentarioAprobarController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	ComentarioDAO dao = null;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		dao = ComentarioDAO.getInstance();
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		Alert alert = null;
		
		try {
			
			comentarios = (ArrayList<Comentario>) dao.getAllNoAprobado();
			request.setAttribute("comentarios", comentarios);
			request.getRequestDispatcher("../comentarios/aprobar.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		dao = ComentarioDAO.getInstance();
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		Alert alert = null;
		
		try {
			
			String[] ids = request.getParameterValues("ids");
			
			if (ids != null) {
				if(dao.updateAprobarComentarios(ids)){
					alert = new Alert("Se han aprobados los comentarios.", Alert.SUCCESS);
				}
			}else {
				alert = new Alert("Selecciona algún comentario.", Alert.WARNING);
			}
			request.setAttribute("alert", alert);
			comentarios = (ArrayList<Comentario>) dao.getAllNoAprobado();
			request.setAttribute("comentarios", comentarios);
			request.getRequestDispatcher("../comentarios/aprobar.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}