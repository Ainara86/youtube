<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<!-- Comenza todas las URLs desde el href indicado -->
		<base href="<%=request.getContextPath()%>/">
		
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		
		<title>Youtube Video Play List</title>
		
		<link rel="stylesheet"
			href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
			integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
			crossorigin="anonymous">
		
		<!-- Bootstrap core CSS -->
		<link
			href="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/css/bootstrap.min.css"
			rel="stylesheet">
		
		<!-- Custom styles for this template -->
		<link
			href="https://blackrockdigital.github.io/startbootstrap-shop-item/css/shop-item.css"
			rel="stylesheet">
		
		<link href="css/styles.css?v2" rel="stylesheet"></link>
	
	</head>
	
	<body>
	
	
		<!-- Navigation -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container">
				<a class="navbar-brand" href="#"><img src="images/playlist.png"
					class="logo"></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					
							
							<ul class="navbar-nav mr-auto">
								
							</ul>
							<form action="login" method="post"
								class="form-inline mt-2 mt-md-0" id="top">
								<input name="usuario" class="form-control mr-sm-2" type="text"
									placeholder="Nombre Usuario" required pattern=".{3,30}"
									autofocus="autofocus"> <input name="pass"
									class="form-control mr-sm-2" type="password"
									placeholder="Contraseña" required pattern=".{2,50}">
								<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Entrar</button>
							</form>
							
							<ul class="navbar-nav mr-auto">
								
								<li class="nav-item">
								<a class="nav-link" href="backoffice/index.jsp">Acceder BackOffice</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="logout">Cerrar Session</a>
								</li>
							</ul>

				</div><!--div navbar-collapse -->
				<!-- formulario Crear Video -->
				<form action="inicio" method="post" class="form-inline mt-2 mt-md-0">
					<input name="id" class="form-control mr-sm-2" type="text"
						placeholder="ID 11 caracerteres" title="11 caracteres" required
						pattern=".{11,11}"> <input name="nombre"
						class="form-control mr-sm-2" type="text"
						placeholder="Nombre minimo 2 letras" required pattern=".{2,125}">
					<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Añadir</button>
				</form>
	
			</div><!--div navbar -->
		</nav><!-- navbar -->
	
		<!-- Page Content -->
		<div class="container">
	

	
	
			<div class="row">
	
				<div class="col-lg-3">
					<h4 class="my-4">Lista Reproduccion</h4>

	
					<hr>
	

	
				</div> <!-- /.col-lg-3 -->
	
				<div class="col-lg-9">
	
					<div class="card mt-4">
	
						
	
						<div class="card-body">
							<p class="card-text">Lorem ipsum dolor sit amet, consectetur
								adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque
								facere, soluta. Totam id dolores, sint aperiam sequi pariatur
								praesentium animi perspiciatis molestias iure, ducimus!</p>
							<span class="text-warning">
								&#9733; &#9733; &#9733; &#9733;&#9734;
							</span> 4.0 stars
						</div><!--fin div card-body -->
					</div><!-- fin div card mt-4-->
	
					<div class="card card-outline-secondary m-2">
						<div class="card-header">
							<div class="row align-items-center">
								<div class="col-6">
									<h2>Comentarios</h2>
								</div>
								<div class="col-6 text-right">
									<a href="#form-comentario" class="btn ">Añade un comentario</a>
								</div>
							</div><!--Fin col-6 text-right  -->
	
						</div><!-- Fin card-header -->
						
					</div><!-- div card card-outline-secondary m-2 -->

	
				</div> <!-- /.col-lg-9 -->
	
			</div> <!-- div row -->
	
		</div> <!-- /.container -->
	
		<!-- Footer -->
		<footer class="py-5 bg-dark">
			<div class="container">
				<p class="m-0 text-center text-white">Copyright &copy; Your
					Website 2017</p>
			</div>
			<!-- /.container -->
		</footer>
	
		<!-- Bootstrap core JavaScript -->
		<script
			src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/jquery/jquery.min.js"></script>
		<script
			src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
	</body>

</html>











<h1>ESTAMOS EN EL BACKOFFICE</h1>
*solo pueden entrar usuarios logeados<br>

	<%
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		if( usuario == null){
	%>
			<p style="color:red">Usuario nulo, se ha saltado el login</p>
		<%
		}else{
		%>
			<p>Usuario: <%=usuario.getNombre()%></p>
		<%
		}
		%>
<img src="http://denkaidigital.denkaidigital.netdna-cdn.com/wp-content/uploads/2018/02/back-office-outsourcing-services.png">

<h2>Listado usuarios conectados</h2>
<%
	HashMap<String, Usuario> usuariosConectados = (HashMap<String, Usuario>)application.getAttribute("uConectados");
	for( HashMap.Entry<String,Usuario> uConectado : usuariosConectados.entrySet() ){
		
	    %>
	    	<li><%=uConectado.getValue().getNombre()%></li>
	    <%
	
	}
%>