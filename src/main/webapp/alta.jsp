<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp" %>

    <div class="contenedor">

		<%@ include file="includes/navbar.jsp" %>

        <main role="main" class="container">
        <%@ include file="includes/alert.jsp"  %>

            <div class="row justify-content-center">
                <h1 class="col col-md-6"><i class="fas fa-user-plus"></i> Nuevo usuario</h1>
            </div>

            <form action="alta" method="post">
			
                <div class="form-row justify-content-center">
                            
                    <div class="col col-md-6">
                        
                        <div class="form-group">
                            <label for="text" class="required">Nombre usuario</label>
                            <input name="nombre" type="text" class="form-control" id="nombre" autofocus required placeholder="Longitud máxima de 20" />
                        </div>
                                    
                        <div class="form-group">
                            <label for="pass" class="required">Contraseña</label>
                            <input name="password" type="password" class="form-control" id="password" minlength="8" maxlength="50" required placeholder="Contraseña del usuario (8 a 20 caracteres)" />
                        </div>
                        <div class="form-group">
                            <label for="pass" class="required">Confirma contraseña</label>
                            <input name="password2" type="password" class="form-control" id="password2" minlength="8" maxlength="50" required placeholder="Contraseña del usuario (8 a 20 caracteres)" />
                        </div>
                                    
                        <button type="submit" class="btn btn-outline-primary btn-block">Registrarse</button>
                                    
                    </div>
                                    
                </div>
                            
            </form>

        </main>
    </div> <!-- /.contenedor -->
<%@ include file="includes/footer.jsp" %>