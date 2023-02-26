<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="books.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="nav.jsp" %>
	
	<div class="containerPrincipalLibrairy">
		<c:set var="bookOrNotSearch" value="Choisissez votre livre" />
		<c:if test="${empty books }"><c:set var="bookOrNotSearch" value="Nous n'avons pas trouvé votre livre"  /> </c:if>
		<p class="title"><c:out value="${bookOrNotSearch}" /></p>
		<div class="libraryContent">
		<c:out value="${emptySearch }"></c:out>
		<c:forEach  items="${books}" var="current">
			<form class="form" action="shopServlet" method="post">
				<span class="part"><c:out value="${current.category}"/></span>		
				<img src="data:image/jpg;base64, ${current.imageBook}" class="imageBook"/>
				<span class="part"><c:out value="${current.price} euros"/></span>	
				<button class="buttonAddBook" type=submit name=bouttonAddBooks value="${current.title},${current.author},${current.numberOfPages},${current.category},${current.price},${current.imageBook}">
					Ajouter à mon panier
				</button>
			</form>
		</c:forEach>
		</div>
	</div>
</body>
</html>
		