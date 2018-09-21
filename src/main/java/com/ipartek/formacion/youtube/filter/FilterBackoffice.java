package com.ipartek.formacion.youtube.filter;

import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * filtramos todas las request que coincidan con urlPatterns={ "/backoffice/*"}
 * Comprobamos que el usuario haya pasado por el login para dejarle continuar.
 * Si el usuario no se ha logeado se redirige a "/inicio"
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/backoffice/*" })
public class FilterBackoffice implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// Se ejecuta al destruir el hilo
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Se ejecuta cada vez que coincide la URL pattern
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		try {

			HttpSession session = req.getSession();
			Usuario usuario = (Usuario) session.getAttribute("usuario");

			if (usuario != null) {
				// siempre que queremos que la request continue.
				chain.doFilter(request, response);
			} else {
				informacionCliente(req);

				// usuario no logeado
				res.sendRedirect(req.getContextPath() + "/inicio");
			}

		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect(req.getContextPath() + "/inicio");
		}

	}

	private void informacionCliente(HttpServletRequest req) {
		//Sacar informacion del cliente
		System.out.println("----------------------");
		
		System.out.println("RemoteHost --> " + req.getRemoteHost());
		System.out.println("RemoteAddr --> " + req.getRemoteAddr());
		System.out.println("RemotePort --> " + req.getRemotePort());
		System.out.println("RemoteUser --> " + req.getRemoteUser());
		
		Enumeration nombresCabeceras=req.getHeaderNames();
		String metadato;
		
		System.out.println("");
		System.out.println("Cabeceras");
		
		
		while ( nombresCabeceras.hasMoreElements() ) {
			metadato=(String)nombresCabeceras.nextElement();
			System.out.println(metadato +": "+ req.getHeader(metadato));
		}
		
		
		System.out.println("");
		System.out.println("Parametros");
		
		//Map parametros = req.getParameterMap();
		//parametros.
		Map<String, String[]> todos=req.getParameterMap();
	    for(String key:todos.keySet()){
	        String[] parametros=(String[])todos.get(key);
	        for(String val:parametros){
	            System.out.println("Parametros= "+val);
	        }   
	    }
		System.out.println("----------------------");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("se ejecuta al iniciar la app");
	}

}
