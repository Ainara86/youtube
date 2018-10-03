package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/usuarios")
public class BackofficeUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioDAO daoUsuario;
	private ArrayList<Usuario> usuarios;
	private Usuario usuarioInicio;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		daoUsuario = UsuarioDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		// se ejecuta al parar el servidor
		daoUsuario = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Alert alert = null;
		try {
			
			String id = request.getParameter("id");
			
			
			//listado videos			
			usuarios = (ArrayList<Usuario>) daoUsuario.getAll();
			
			
			if (id == null) {
				request.setAttribute("usuarios", usuarios);
				request.getRequestDispatcher("usuarios/index.jsp").forward(request, response);
			} else {

				Usuario usuario = new Usuario();
				if (Integer.parseInt(id) > 0) {
					usuario = daoUsuario.getById(id);
				}
				request.setAttribute("usuario", usuario);
				request.getRequestDispatcher("usuarios/form.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		} finally {
			request.setAttribute("alert", alert);
		}


		
		
		
		//ArrayList<Usuario> usuarios = getMockUsers();

		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recoger parametros del formulario
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		String rol = request.getParameter("rol");

		// TODO comprobar si es CREAR o MODIFICAR y llamar DAO
		Usuario usuario = new Usuario();
		usuario.setId(Long.parseLong(id));
		usuario.setNombre(nombre);
		usuario.setPassword(password);
		usuario.setRol(Integer.parseInt(rol));

		request.setAttribute("usuario", usuario);
		request.getRequestDispatcher("usuarios/form.jsp").forward(request, response);

	}

	private ArrayList<Usuario> getMockUsers() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario u = null;
		for (int i = 1; i <= 100; i++) {
			u = new Usuario("nombre" + i, "123456");
			if (i == 1) {
				u.setRol(Usuario.ROL_ADMIN);
			}
			u.setId(i);
			usuarios.add(u);
		}
		return usuarios;
	}

}