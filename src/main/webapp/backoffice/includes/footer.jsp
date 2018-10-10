        <footer id="listado-footer">

            <div>
                <p>&copy; 2018</p>
            </div>
                
        </footer>

    </div> <!-- /.contenedor -->

    <!-- Scripts para plugin datatable -->

    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	
    <script>
        $(document).ready(function() {
            $('#listado').DataTable( {
                "language": {
                    "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
                }
            } );
        } );
        
        function showpass(event, elementId){
        	console.log('click showpass' + elementId);
        	var el=document.getElementById(elementId);
        	
        	if(el.type=="password"){
        		el.type="text";
        		
        	}else{
        		el.type="password";
        	}
        	
        	if(event.target.classList.contains("fa-eye")){
        		event.target.classList.remove("fa-eye");
        		event.target.classList.add("fa-eye-slash");
        	}else{
        		event.target.classList.remove("fa-eye-slash");
        		event.target.classList.add("fa-eye");
        	}
        }
    
    </script>
    
</body>
</html>