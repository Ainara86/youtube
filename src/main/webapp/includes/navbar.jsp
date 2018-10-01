<!-- Navigation -->
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="#"><img src="images/log.png" class="logo"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active"><a href="inicio?idioma=es_ES"><img src="images/esbandera.png"></a></li>
	     	<li class="nav-item active"><a href="inicio?idioma=eu_ES"><img src="images/eubandera.png"></a></li>
	     	<li class="nav-item active"><a href="inicio?idioma=en_EN"><img src="images/enbandera.png"></a></li>
           </ul>
           <ul class="navbar-nav mr-auto"> 
            <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Sesión</a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
              <a class="dropdown-item" href="login.jsp">Iniciar sesión</a>
              <a class="dropdown-item" href="alta.jsp"><i class="fas fa-user-plus"></i> Alta nuevo usuario</a>
            </div>
         	 </li>
          </ul>
          <div class="collapse navbar-collapse" id="navbarResponsive">
				<!-- usuario logeado -->
			    <c:if test="${not empty sessionScope.usuario}">
		    		<ul class="navbar-nav mr-auto">
		      			<li class="nav-item active">
		        			<a class="nav-link"><i class="fas fa-user">${usuario.nombre}</i></a>
		      			</li>
		      			<li class="nav-item">
		        			<a class="nav-link" href="backoffice/index.jsp">Acceder Backoffice</a>
		      			</li>
		      			<li class="nav-item">
		        			<a class="nav-link disabled" href="logout">Cerrar Session</a>
		      			</li>
		    		</ul>
	    			<!-- formulario Crear Video -->
				    <form action="inicio" method="post" class="form-inline mt-2 mt-md-0 video">
						<input name="codigo" class="form-control mr-sm-2" type="text" placeholder="ID 11 caracerteres" title="11 caracteres" required pattern=".{11,11}">
						<input name="nombre" class="form-control mr-sm-2" type="text" placeholder="Nombre minimo 2 letras" required pattern=".{2,125}">
						<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Añadir</button>
				    </form>
				</c:if>
	  		</div>
        </div>
      </nav>