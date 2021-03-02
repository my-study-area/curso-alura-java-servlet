<%@page import="java.util.List,br.com.alura.gerenciador.servlet.Empresa"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h1>Lista de empresas</h1>
	<c:if test="${not empty empresa}">
		Empresa ${ empresa } cadastrada com sucesso!
	</c:if>
	<ul>
	<c:forEach items="${empresas}" var="empresa">
		<li> ${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/></li>	
	</c:forEach>
	</ul>
	
</body>
</html>
