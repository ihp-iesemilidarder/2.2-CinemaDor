<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.cinema.service.StarService" %>
<%@ page import="com.cinema.dto.Star"%>
<%
	StarService service = new StarService();
	List<Star> listStars = service.getListStars();
	request.setAttribute("list", listStars);
%>
<%@ include file="./common/header.jsp" %>
<div class="container-list-stars">
	<c:forEach var="star" varStatus="loop" items="${list}">
		<div class="card" style="width: 100%;">
		  <img src="/cinema2/img/person.jpg" style="width:50%; margin:auto;" class="card-img-top" alt="...">
		  <div class="card-body">
		    <h5 class="card-title"><c:out value="${star.sta_name }"></c:out></h5>
		    <p class="card-text"><c:out value="${star.sta_date }"></c:out></p>
		  </div>
		</div>
	</c:forEach>
</div>
<%@ include file="./common/footer.jsp" %>