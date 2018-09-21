<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>

<c:set var="idioma" value="en_EN" />
<fmt:setLocale value="${idioma}" />
<fmt:setBundle basename="idiomas" /> 

<!DOCTYPE html>
<html lang="${idioma}">
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
		
		<link href="css/styles.css" rel="stylesheet"></link>
	
	</head>
	
	<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#"><img src="images/log.png" class="logo"></a>
     	
		<div class="collapse navbar-collapse" id="navbarResponsive">
	      
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<!-- usuario logeado -->
			    
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

	  		</div>
       </div>
   </div>
 </nav>
	
		<!-- Page Content -->
		<div class="container">
	

	
	
			<div class="row">
	
				<div class="col-lg-3">
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
	

	
				</div> <!-- /.col-lg-3 -->
	
				<div class="col-lg-9">
	
					<div class="card mt-4">
	onrnjsgejnorsenoregnogreno
					</div><!-- fin div card mt-4-->
	
					
	
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











