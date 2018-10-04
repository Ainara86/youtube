package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/usuarios")
public class BackofficeUsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static UsuarioDAO daoUsuario = null;

	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2"; // insert id == -1 o update id > 0
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";

	private static final String VIEW_LISTADO = "usuarios/index.jsp";
	private static final String VIEW_FORMULARIO = "usuarios/form.jsp";
	private String view;
	private Alert alert;

	private String op; // operacion a realizar
	private String id;
	private String nombre;
	private String password;
	private String rol;

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
		doProcess(request, response);
		/*Alert alert = null;
		try {

			ArrayList<Usuario> usuarios = new ArrayList<>();

			String id = request.getParameter("id");
			String op = request.getParameter("op");

			if (id != null && op != null && op.equals(OP_ELIMINAR)) { // ELIMINAR

				daoUsuario.delete(id);

				usuarios = (ArrayList<Usuario>) daoUsuario.getAll();
				request.setAttribute("usuarios", usuarios);
				request.getRequestDispatcher("usuarios/index.jsp").forward(request, response);

			} else {

				if (id == null) { // LISTADO
					usuarios = (ArrayList<Usuario>) daoUsuario.getAll();
					request.setAttribute("usuarios", usuarios);
					request.setAttribute("alert", new Alert(Alert.SUCCESS, "Yeaaaaa"));
					request.getRequestDispatcher("usuarios/index.jsp").forward(request, response);

				} else { // DETALLE

					Usuario usuario = new Usuario();
					if (Integer.parseInt(id) > 0) {
						usuario = daoUsuario.getById(id);
					}
					request.setAttribute("usuario", usuario);
					request.getRequestDispatcher("usuarios/form.jsp").forward(request, response);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		} finally {
			request.setAttribute("alert", alert);
		}*/

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
		/*Alert alert = null;

		

		Usuario usuario = new Usuario();
		usuario.setId(Long.parseLong(id));
		usuario.setNombre(nombre);
		usuario.setPassword(password);
		usuario.setRol(Integer.parseInt(rol));

		if (usuario.getId() > 0) { // MODIFICAR
			daoUsuario.update(usuario);
		} else { // INSERT
			daoUsuario.insert(usuario);
		}

		request.setAttribute("usuario", usuario);
		request.getRequestDispatcher("usuarios/form.jsp").forward(request, response);*/

	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			alert = new Alert();

			getParameters(request);

			switch (op) {
			case OP_ELIMINAR:
				eliminar(request);
				break;
			case OP_IR_FORMULARIO:
				irFormulario(request);
				break;
			case OP_GUARDAR:
				guardar(request);
				break;

			default: // LISTAR
				listar(request);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
			view = VIEW_LISTADO;
			alert = new Alert();
		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);

		}
	}

	private void getParameters(HttpServletRequest request) {
		op = ( request.getParameter("op") != null ) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		password = request.getParameter("password");
		rol = request.getParameter("rol");

	}

	private void listar(HttpServletRequest request) {
		alert = null;
		view = VIEW_LISTADO;
		request.setAttribute("usuarios", daoUsuario.getAll());
	}

	private void guardar(HttpServletRequest request) {
		alert=null;
		
		Usuario usuario = new Usuario();
		usuario.setId(Long.parseLong(id));
		usuario.setNombre(nombre);
		usuario.setPassword(password);
		usuario.setRol(Integer.parseInt(rol));

		if (usuario.getId() > 0) { // MODIFICAR
			usuario.setId(Long.parseLong(id));
			usuario.setNombre(nombre);
			usuario.setPassword(password);
			usuario.setRol(Integer.parseInt(rol));
			daoUsuario.update(usuario);
			
		} else { // INSERT
			daoUsuario.insert(usuario);
		}		
		
		request.setAttribute("usuario", daoUsuario.getById(id));
		view=VIEW_FORMULARIO;
		
		
	}

	private void irFormulario(HttpServletRequest request) {
		alert = null;
		ArrayList<Usuario> usuarios = new ArrayList<>();
		view=VIEW_FORMULARIO;
		
		if (id == null) { // LISTADO
			usuarios = (ArrayList<Usuario>) daoUsuario.getAll();
			request.setAttribute("usuarios", usuarios);
			request.setAttribute("alert", new Alert(Alert.SUCCESS, "Yeaaaaa"));
			view=VIEW_LISTADO;

		} else { // DETALLE

			Usuario usuario = new Usuario();
			if (Integer.parseInt(id) > 0) {
				usuario = daoUsuario.getById(id);
			}
			request.setAttribute("usuario", usuario);
			view=VIEW_FORMULARIO;
		}

	}

	private void eliminar(HttpServletRequest request) {
		alert=null;
		
		view=VIEW_FORMULARIO;

		daoUsuario.delete(id);
		request.setAttribute("usuarios", daoUsuario.getAll());
		view=VIEW_LISTADO;
		//TODO alerts
		//request.setAttribute("alert", new Alert(Alert.SECONDARY, "Usuario eliminado con exito."));

	}

}