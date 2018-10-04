<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeUsuarioController"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>
<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<div id="page-wrapper">
<%@ include file="../includes/alert.jsp"%>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">${(usuario.id==-1)?'Crear usuario': usuario.nombre }</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<div class="row">
	${usuario }
		<form action="usuarios" method="post">
			<div class="form-group">
				<label for="id" class="required">Id</label>
				<input type="text" class="form-control" name="id" id="id" readonly value="${usuario.id }"/>
			</div>
			<div class="form-group">
				<label for="nombre" class="required">Nombre</label>
				<input type="text" class="form-control" name="nombre"  id="nombre" value="${usuario.nombre}" autofocus />
			</div>
			<div class="form-group">
				<label for="password" class="required">Contraseña</label>
				<input type="password" class="form-control" name="password" id="password" value="${usuario.password}" />
			</div>
			<div class="form-group">
				<label for="rol">Rol</label>
				<select name="rol" class="form-control">
					<option value="${Usuario.ROL_USER}"  ${(usuario.rol == Usuario.ROL_USER)?'selected':'' }>Normal</option>
			   		<option value="${Usuario.ROL_ADMIN}"  ${(usuario.rol == Usuario.ROL_ADMIN)?'selected':'' }  >Administrador</option>
				</select>
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="op" id="op" value="2" />
			</div>
			<input type="submit"
				value="${(usuario.id==-1)?'Crear usuario': 'Modificar usuario' }"
				class="btn btn-primary btn-block">
			<c:if test="${usuario.id > 0}">
      				<a href="usuarios?id=${usuario.id}&op=3" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar(Modal)</a>
			</c:if>
		</form>
		
		<script>
			function confirmar(e){
				if(confirm('¿Estas seguro de que deseas ELIMINAR?')){
					console.log('confirmado eliminar');
				}else{
					//prevenir el evento por defecto del enlace
					e.preventDefault();
				}
			}
		</script>
	</div>



</div>
<%@ include file="../includes/footer.jsp"%>
