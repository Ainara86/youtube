<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeRolController"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Rol"%>
<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<div id="page-wrapper">
<%@ include file="../includes/alert.jsp"%>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">${(roles.id==-1)?'Crear rol': roles.nombre }</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<div class="row">
	${roles }
		<form action="roles" method="post">
			<div class="form-group">
				<label for="id" class="required">Id</label>
				<input type="text" class="form-control" name="id" id="id" readonly value="${roles.id }"/>
			</div>
			<div class="form-group">
				<label for="nombre" class="required">Nombre</label>
				<input type="text" class="form-control" name="nombre"  id="nombre" value="${roles.nombre}" autofocus />
			</div>
			
			<input type="hidden" name="op" value="<%=BackofficeRolController.OP_GUARDAR%>">
			<input type="submit"
				value="${(roles.id==-1)?'Crear rol': 'Modificar rol' }"
				class="btn btn-primary btn-block">
			<c:if test="${roles.id > 0}">
      				<a href="roles?id=${roles.id}&op=<%=BackofficeRolController.OP_ELIMINAR %>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar(Modal)</a>
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
