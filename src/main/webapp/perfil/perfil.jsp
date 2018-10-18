<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

<div id="page-wrapper">
	<%@ include file="includes/alert.jsp" %>
        <div class="row">
            <div class="col-lg-3 col-md-6">
                <div class="panel panel-color">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <img src="../images/user.png" class="perfil">
                            </div>
                            
                        </div>
                    </div>
                    <a href="usuarios">
                        <div class="panel-footer">
                            <span class="pull-left">Cambiar foto</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
                    <form action="perfil" method="post" class="form-inline mt-2 mt-md-0">
		           <input name="nombre" class="form-control mr-sm-2" type="text" placeholder="" title="" required pattern=".{11,11}">
		           <input name="pass" class="form-control mr-sm-2" type="text" placeholder="" required pattern=".{2,125}">
		           <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Cambiar</button>
		         </form>
            </div>
 </div><!-- /.row -->

</div><!-- /#page-wrapper -->

<%@ include file="includes/footer.jsp" %> 