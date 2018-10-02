<!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Backoffice Youtube</a>
            </div>
            <!-- /.navbar-header -->

			<div class="collapse navbar-collapse" id="navbarResponsive">
     	
     	
     	<ul class="navbar-nav ml-auto idioma">
     		<li class="nav-item ${(sessionScope.idioma eq 'es_ES')?'active':''}"><a href="inicio?idioma=es_ES">es</a></li>
     		<li class="nav-item ${(sessionScope.idioma eq 'eu_ES')?'active':''}"><a href="inicio?idioma=eu_ES">eu</a></li>
     		<li class="nav-item ${(sessionScope.idioma eq 'en_EN')?'active':''}"><a href="inicio?idioma=en_EN">en</a></li>
     		<li><a href="alta.jsp" class="btn btn-outline-info my-2 my-sm-0">Registrate</a></li>
     		<li><i class="fas fa-user">${usuario.nombre}</i></li>
     		<li><a href="backoffice/index.jsp">Acceder Backoffice</a></li>
     		<li><a href="logout">Cerrar Session</a></li>
     	</ul>
     </div>

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> Inicio</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Videos<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">Usuarios</a>
                                </li>
                                <li>
                                    <a href="morris.html">Roles</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="tables.html"><i class="fa fa-table fa-fw"></i> Tables</a>
                        </li>
                        <li>
                            <a href="forms.html"><i class="fa fa-edit fa-fw"></i> Forms</a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>