<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MasterPage</title>
</head>


<body>

	<!-- NAVBAR -->
	<%@ include file="Header.jsp" %>
			<br>
			<br>
		<br>
	<div style="background-color:rgba( 255, 255, 255, 0.7); margin-bottom:-20px; min-height:100vh" >
	    <br>
	    <div class=" container body-content bg-light px-5" >

			    		<br>
			    
	<!-- CUERPO DE LA MASTER PAGE -->
	
	
	<% 
	String chequeo = null;
	
	if(request.getAttribute("sitio")!=null)
	{
		chequeo = (String) request.getAttribute("sitio");
		switch(chequeo){
		case "login":
			%>	
			
			<%@ include file="../Login.jsp" %>
			
			<%
			break;
			
		case "abmlMedicos":
			
			%>
			
			<%@ include file="../ABMLs/ABMLMedicos.jsp" %>
			
			<%
			break;
			
		case "abmlPacientes":
			
			%>
			
			<%@ include file="../ABMLs/ABMLPacientes.jsp" %>
			
			<%
			break;
			
		case "turnos":
			
			%>
			
		  <%@ include file="../AsignacionTurnos.jsp" %>
			
			<%
			break;
			
		default: 
			break;
			
		}
		
	}
	
			%>

	



	
	<br>
		<br>
		
		</div>
	</div>
</body>
</html>