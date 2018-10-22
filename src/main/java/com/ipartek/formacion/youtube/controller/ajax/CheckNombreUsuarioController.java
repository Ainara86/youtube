package com.ipartek.formacion.youtube.controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class CheckNombreUsuarioController
 */
@WebServlet("/checknombre")
public class CheckNombreUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static UsuarioDAO dao;
	private ArrayList<Usuario> usuarios;
	private Usuario usuario;
	boolean existe;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao = UsuarioDAO.getInstance();
		 
		try {
			//Response con formato json
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			//recoge parametros
			String nombre = request.getParameter("nombre");

			existe= dao.buscar(nombre);			
			
			//Respuesta de salida
			PrintWriter out = response.getWriter();
	        out.print("{\"resultado\":"+existe+"}");
	        out.flush();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
