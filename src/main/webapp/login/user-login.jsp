<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
 <%

    String error = request.getParameter("error");
 	String msg = "";
	if ("no-user".equals(error)){
		msg  = "Dades incorrectes";
		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:out value="${msg}"/>
	<form name="frmLogin" method="post" action="/cinema2/action-login">
		<p>
			<label>Nom usuari (nick):</label>
			<input name="usuName" type="text" value="" required="required" />
		</p>
		<p>
			<label>Password:</label>
			<input name="usuPass" type="password" value="" required="required" />
		</p>
		<button type="submit">Entrar</button>		
	</form>

</body>
</html>