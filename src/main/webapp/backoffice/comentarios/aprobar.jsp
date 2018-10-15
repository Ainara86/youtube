<%@page import="com.ipartek.formacion.youtube.controller.back.CrudControllable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>

<div id="page-wrapper">
<%@ include file="../includes/alert.jsp"%>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">
				<i class="fas fa-comments"></i>Comentarios <span class="badge badge-secondary">${fn:length(comentarios)}</span>
			</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->

	<div class="row">
		<main class="container" role="main">

		<table id="listado" class="display">
			<thead>
				<tr>
					<th>Aprobado</th>
					<th>Usuario</th>
					<th>Comentario</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${comentarios}" var="c">
					<tr>
						<td><input type="checkbox" class="form-check-input" id="aprobado" value="1"></td>
						<td>${c.usuario.nombre}</td>
						<td>${c.texto}</td>
						<td>${c.id}</td>
					</tr>
				</c:forEach>
			</tbody>
			

		</table>
		<form action="comentarios/aprobar" method="post">
			<input type="hidden" name="op" value="1">
			<input type="hidden" name="id" value="${c.id}">
			<input type="hidden" name="aprobado" value="1">
			<input type="submit" 
				value="Aprobar"
				class="btn btn-primary btn-block">

		</form>
		</main>

<%@ include file="../includes/footer.jsp"%>