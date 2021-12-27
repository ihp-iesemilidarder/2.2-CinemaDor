<%-- Aquesta pàgina mostrarà la llista de pel·lícules i filtrarà per gènere --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.cinema.service.FilmService" %>
<%@ page import="com.cinema.dto.Genere" %>
<%@ page import="com.cinema.dto.Film"%>

<%
	// Lectura dels paràmetres
    String pGenere = request.getParameter("genere");

	// Validació del paràmetre i creació del valor enum de tipu Genere
	Genere genere = null;
	if (pGenere != null){
		genere  = Genere.valueOf(pGenere);
	}
	FilmService serveiFilm = new FilmService();
	List<Film> llistaFilms = serveiFilm.getListFilms(genere);
	if(genere==Genere.ESTRENO){
		
		llistaFilms = serveiFilm.getListFilmsPremiere();
	}
	request.setAttribute("llistaFilms", llistaFilms);
	
	// També introduím el genere al request 
	request.setAttribute("genere", pGenere);
	
%>

<%@include file="./common/header.jsp" %>
	<!-- Contingut central -->
	<div class="container">

		<!-- 1r - Llista pel·lícules -->
		<div class="row">
			<div class="col-12">
				<ul class="list-unstyled">
				
			        <%-- Mostrar màxim les pel·lícules de NUM_FILM --%>
			        <c:set var="NUM_FILM" value="10" scope="page" />
			        <c:forEach var="film" varStatus="loop" items="${llistaFilms}">
			            <c:if test = "${loop.index < NUM_FILM}">
		            		<li class="media  my-4">
								<img src="img/${film.caratula}" class="mr-3" style="width:100px">
								<div class="media-body">
									<a href="detail-film.jsp?codi=<c:out value="${film.id}"/>">
										<h5 class="mt-0 mb-1"> <c:out value="${film.nom}"/> </h5>
									</a>
									<c:if test = "${film.estreno eq true}">
										<span class="badge btn-warning">Estrena</span>
									</c:if>
									<p class="py-0 my-0"><c:out value="${film.sinopsi}"/></p>
									<p class="py-0 my-0">
										<img src="img/age-tp.png" style="width:20px"/>
										Edat recomanada: <c:out value="${film.edatRec}"/>
									</p>
								</div>
							</li>
			            </c:if>
			        </c:forEach>
				</ul>
			</div>
		</div>

	</div>
	
<%@include file="./common/footer.jsp" %>