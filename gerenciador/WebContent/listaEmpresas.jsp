<%@page import="java.util.List,br.com.alura.gerenciador.servlet.Empresa"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h1>Lista de empresas</h1>
	<ul>
	<c:forEach items="${empresas}" var="empresa">
		<li> ${empresa.nome} </li>	
	</c:forEach>
	</ul>
	
</body>
</html>
