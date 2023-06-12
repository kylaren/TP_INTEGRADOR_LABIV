<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="background-color:rgba( 255, 255, 255, 0.7); margin-bottom:-20px; min-height:100vh" >
		<%@ include file="Header.jsp" %>
	    <br>
	    <div class=" container body-content bg-light px-5" >
	    	<br>
	    	
	    	 <!-- PANTALLA DE LOGUEO -->
	    	 
	    	<p>
			  <a class="btn btn-primary" data-toggle="collapse" href="#collapse1" role="button" aria-expanded="false" aria-controls="collapse1">
			    Ingresar
			  </a>
			</p>
			<div class="collapse" id="collapse1">
			  <div class="card card-body">
			  	  <%@ include file="../Login.jsp" %>
			  </div>
			</div>
	    	
	    	
	    	<br>
	    	
	    	<!-- DESARROLLAR FUNCION QUE PERMITA CAMBIAR ESTE SITIO EN SERVLETS  -->

			
			<br>
		</div>
		
	</div>
</body>
</html>