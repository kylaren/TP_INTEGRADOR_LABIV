<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<style>
       
        .menu {
            background-color: #f2f2f2;
            padding: 10px;
        }
        .menu ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }
        .menu ul li {
            display: inline-block;
            margin-right: 10px;
        }
        .menu ul li a {
            text-decoration: none;
            color: #000;
            padding: 5px 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .menu ul li a:hover {
            background-color: #ccc;
        }
    </style>

</head>
<body>

	<div class="menu">
        <ul>
            <li><a href="registrarPaciente.jsp">Registrar Paciente</a></li>
            <li><a href="registrarMedico.jsp">Registrar Médico</a></li>
            <li><a href="asignarTurno.jsp">Asignar Turno</a></li>
        </ul>
    </div>
    
    
</body>
</html>