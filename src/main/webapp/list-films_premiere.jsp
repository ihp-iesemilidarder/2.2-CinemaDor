<%-- Aquesta pàgina mostrarà la llista de pel·lícules i filtrarà per gènere --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.cinema.service.FilmService" %>
<%@ page import="com.cinema.dto.Genere" %>
<%@ page import="com.cinema.dto.Film"%>

<%
	FilmService serveiFilm = new FilmService();
	List<Film> llistaFilms = serveiFilm.getListFilmsPremiere();
	
	request.setAttribute("llistaFilms", llistaFilms);
%>

<%@include file="./common/header.jsp" %>
<h2>Estrenos</h2>
<table>
	<thead>
		<th>Nombre</th>
		<th>Duracion</th>
	</thead>
	<tbody>
		<c:forEach var="film" varStatus="loop" items="${llistaFilms}">
			<tr>
				<td><c:out value="${film.nom}"></c:out></td>
				<td><c:out value="${film.sinopsi}"></c:out></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@include file="./common/footer.jsp" %>