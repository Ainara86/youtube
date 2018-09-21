<%@include file="includes/header.jsp" %>
	
<%@include file="includes/navbar.jsp" %>		
	<!-- Page Content -->
	<div class="container">
		<%@ include file="includes/alert.jsp"  %>
		<div class="row">
			<div class="col-lg-3">
				<h4 class="my-4">
					<fmt:message key="lista.reproduccion">
					</fmt:message>
				</h4>
				<ul class="list-group">
					<!-- ForEach videos -->
					<c:forEach items="${videos}" var="v">          
						<li class="list-group-item d-flex justify-content-between align-items-center">     
							<a href="inicio?id=${v.id}">${v.nombre}</a>
							<a href="inicio?id=${v.id}&op=${HomeController.OP_ELIMINAR}"><i style="color:red;" class="float-right fas fa-trash-alt"></i></a>
						</li>
					</c:forEach>
				</ul>
				<hr>
				<h4 class="my-4">Videos Visualizados</h4>
				<ul class="list-group">
					<c:if test="${not empty usuario}">
						<c:forEach items="${reproducidos}" var="r"> 						
							<li class="list-group-item d-flex justify-content-between align-items-center">
								<a href="?id=${r.id }">${r.nombre}</a>
							</li>
						</c:forEach>
					</c:if>
					<c:if test="${empty usuario}">
						<li class="list-group-item d-flex justify-content-between align-items-center">
							<p>
									*Por favor <a href="#top">Inicia sesión</a> para guardar tus
									video reproducidos
							</p>
						</li>
					</c:if>
				</ul>
			</div> <!-- /.col-lg-3 -->
			<div class="col-lg-9">
				<div class="card mt-4">
					<iframe id="iframe" width="823" height="415"
							src="https://www.youtube.com/embed/${videoInicio.id}?"
							frameborder="0" ></iframe>
	
					<div class="card-body">
						<h3 class="card-title">${videoInicio.nombre}</h3>
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
<%@include file="includes/footer.jsp" %>	
		