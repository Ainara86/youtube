package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Alert alert = new Alert();
		HttpSession session = request.getSession();
		
		try {
			
			//recoger parametros
			String usuario = request.getParameter("usuario");
			String pass = request.getParameter("pass");
			String cookieNombre = (String) request.getParameter("recordar");

			//comprobar usuario TODO contra BBDD
			if ( "admin".equals(pass) && "admin".equals(usuario) || 
				  "pepe".equals(pass) && "pepe".equals(usuario)  ||
				  "manoli".equals(pass) && "manoli".equals(usuario)||
				  "josepo".equals(pass) && "josepo".equals(usuario))  {
				
				alert.setTexto("Bienvenido " + usuario );
				alert.setTipo(Alert.PRIMARY);
				
				session.setAttribute("usuario", new Usuario(usuario, pass));
				session.setMaxInactiveInterval(60*5);

				Cookie cookies[] = request.getCookies();
				boolean existe = false;
				int pos = 0;

				if ("on".equals(cookieNombre)) {
					for (int i = 0; i < cookies.length; i++) {
						if ("nombreRecordado".equals(cookies[i].getName())) {
							existe = true;
							pos = i;
						}
					}
					if (existe) {
						cookies[pos].setValue(usuario);
					} else {
						Cookie nombreRecordado = new Cookie("nombreRecordado", usuario);
						nombreRecordado.setMaxAge(-1);
						response.addCookie(nombreRecordado);
					}
				} else {
					for (int i = 0; i < cookies.length; i++) {
						if ("nombreRecordado".equals(cookies[i].getName())) {
							existe = true;
							pos = i;
						}
					}
					if (existe) {
						Cookie nombreRecordado = new Cookie("nombreRecordado", usuario);
						nombreRecordado.setMaxAge(0);
						response.addCookie(nombreRecordado);
					}
				};
				
			
				
				
				
			}else{
				
				alert.setTexto("Credenciales incorrectas" );
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.setAttribute("alert", alert);
			//request.getRequestDispatcher("home.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/inicio" ); 
		}
		
		
	}
	
	

}