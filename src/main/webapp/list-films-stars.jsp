<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.cinema.service.FilmStarService" %>
<%@ page import="com.cinema.service.StarService" %>
<%@ page import="com.cinema.dto.FilmStar"%>
<%@ page import="com.cinema.dto.Star"%>
<%
	StarService stars = new StarService();
	List<Star> listStars = stars.getListStars();
	request.setAttribute("stars", listStars);
%>
<%@ include file="./common/header.jsp" %>
<div class="container-list-stars">
	<c:forEach var="star" varStatus="loop" items="${stars}">
		<div class="card" style="width: 100%;">
		  <img src="/cinema2/img/person.jpg" style="width:50%; margin:auto;" class="card-img-top" alt="...">
		  <div class="card-body">
		    <h5 class="card-title"><c:out value="${star.sta_name }"></c:out></h5>
		    <ul class="list-group">
		    	<%
			    	FilmStarService filmStar = new FilmStarService();
		    		Star star = (Star) pageContext.getAttribute("star");
		    		int idStar = (int) star.getSta_id();
			    	List<FilmStar> listFilms = filmStar.getFilmStarService(idStar);
			    	request.setAttribute("films", listFilms);
		    	%>
		    	<c:forEach var="film" varStatus="loop" items="${films}">
					<li class="list-group-item"><c:out value="${ film.fil_name }"></c:out></li>
				</c:forEach>
			</ul>
		  </div>
		</div>
	</c:forEach>
</div>
<%@ include file="./common/footer.jsp" %>