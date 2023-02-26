<%@ taglib prefix="c" uri="jakarta.tags.core" %><!DOCTYPE html>
<html>
<head>
<link href="nav.css" rel="stylesheet" type="text/css">
<link href="index.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="nav.jsp" %>
	<div class="parentImage">
	<img src="images/deco.jpg" class="decoLibrary"/>
	<a href="<%=request.getContextPath()%>/BookStoreServlet" >
	<img src="images/nousRevions.jpg" class="afficheLibrary"/>
	</a>
	<a href="<%=request.getContextPath()%>/BookStoreServlet" class="title">
	<p><c:out value="Entrez dans votre librairie"/></p>
	</a>
	<div class="coupDeCoeur">
	<p><c:out value="Coup de coeur "/></p>
	<p><c:out value="de la semaine"/></p>
	</div>
	</div>
</body>
</html>

