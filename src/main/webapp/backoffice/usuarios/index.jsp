<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/navbar.jsp" %>

  <div id="page-wrapper">
      <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header"><i class="fas fa-clipboard-list"></i>Usuarios</h1>
          </div>
          <!-- /.col-lg-12 -->
      </div>
      <!-- /.row -->
      <div class="row">
      		<div class="col-md-8">
      			TODO BUSCADOR con su lupita toda txula
      		</div>
      		<div class="col-md-4">
      			<a href="usuarios?id=-1" class="btn btn-success">Crear Nuevo</a>
      		</div>	
      </div>
      
      <div class="row">
       <main class="container" role="main">
                
            <table id="listado-usuarios" class="display">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Password</th>
                        <th>Rol</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${usuarios}" var="u">
                    	<tr>
	                        <td>${u.id}</td>
	                        <td>${u.nombre}</td>
	                        <td>${u.password}</td>
	                        <td>${u.rol}</td>
                    	</tr>
                    </c:forEach>
                </tbody>

            </table>
            
        </main>


<%@ include file="../includes/footer.jsp" %>
