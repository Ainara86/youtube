package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

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
	private static ComentarioDAO daoComentario = null;
	
	private static final String VIEW_INICIO = "../comentarios/aprobar.jsp";
	private Alert alert;

	
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		daoComentario = ComentarioDAO.getInstance();
	}
	
	@Override
	public void destroy() {	
		super.destroy();
		daoComentario = null;
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		daoComentario = ComentarioDAO.getInstance();
		alert = null;		
			
		try {
			request.setAttribute("comentarios", daoComentario.getAllByAprobado());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(VIEW_INICIO).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String op; 
		String id;
		String aprobar;
		
		
		Comentario c = new Comentario();

		try {
			op = request.getParameter("op");		
			id = request.getParameter("id");
			aprobar = request.getParameter("aprobar");
			
			
		
		if(op.equals("1")) {
			
			if(aprobar)
			daoComentario.update(c);
		}
		alert = new Alert(Alert.SUCCESS, "Comentario guardado con exito");
		
		}catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}
		request.setAttribute("comentario", c);

		try {
			request.setAttribute("comentarios", daoComentario.getAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(VIEW_INICIO).forward(request, response);
		}

	}
	
	
}





		


	
	


