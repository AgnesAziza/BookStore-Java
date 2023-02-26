	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<link href="panier.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="nav.jsp" %>
	<div class="libraryContent">
	<p class="titlePanier"><c:out value="Récapitulatif de votre panier"/></p>
	<c:if test="${ !empty sessionScope.booksPanierKey }">
		<c:set var="total" value="${0}" />
		<div class="containerPanier"> 
         <div class="recapPannier">
        <c:forEach items="${sessionScope.booksPanierKey}" var="books">
        <form class="form" action="DeleteServlet" method="post">
             <c:set var="total" value="${total + books.price}" />
             <div class="containerBag">
             <div class="imageBook">
             <img src="data:image/jpg;base64, ${books.imageBook}" class="imageBook"/>
             </div>
   			<div class="containerRecp">
   			<p><c:out value="${books.title}"/> </p>
        	<p><c:out value="${books.price } euros" /> </p>
        	<button class="deleteBag" type="submit" name="buttonDeleteBooks" value="${books.title},${books.author},${books.numberOfPages},${books.category},${books.price},${books.imageBook}">
        	supprimer</button>
        	</div>
        	</div>
        </form>	
        </c:forEach>
         </div>
        <div class="totalPanier">
             <div class="total">
             <p class="total"> Total <c:out value="${total } : euros" />
             </div>
             <a href="<%=request.getContextPath()%>/ReglementServlet">
     		<div class="buttonValidate">
        	<button class="validatePanier">Valider mon panier</button>
        	</div> 
        	</a>
       	</div>
       	</div>
    </c:if>
    <c:if test="${ empty sessionScope.booksPanierKey }">
    		<p class="emptyBag"><c:out value="Votre panier est vide"/></p>
    
     </c:if>
    </div>
</body>
</html>