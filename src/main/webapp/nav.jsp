<!DOCTYPE html>
<html>
<head>
<link href="nav.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>nav bookstore</title>
</head>
<body>
	<header>
		<div class="myHeader">
			<div class="library-group">
				<a href="<%=request.getContextPath()%>/index.jsp"><img src="images/old-library.svg" class="library"/></a>
				<a href="<%=request.getContextPath()%>/index.jsp"><p class= "titleLibrairie">MonBookstore</p></a>
			</div>
			
			<form method="post" action="BookStoreServlet" class="searchForm">
			<div class= input-group>
				<input type="search" name="searchBooks" placeholder="Je recherche mon livre" id="site-search">
				<button type=submit class="contentIcone"><img src="images/search.svg" class="search"/>
				</button>
				</div>
			</form>
				<div class="bagIcone">
				<c:if test="${ !empty sessionScope.booksPanierKey }" > 
				<span class="bagNombre">${sessionScope.booksPanierKey.size()}</span>
				</c:if>
				<c:if test="${ empty sessionScope.booksPanierKey }"><span class="bagNombre">0</span></c:if>
				<a href="<%=request.getContextPath()%>/panier.jsp"><img src="images/bag.svg" class="bag"/></a>
				</div>
		</div>
		<nav class="nav">
			<a href="<%=request.getContextPath()%>/index.jsp">Acceuil</a>
			<a href="<%=request.getContextPath()%>/BookStoreServlet">Catalogues de livres</a>
			<a href="<%=request.getContextPath()%>/panier.jsp">Page panier</a>
			<a href="<%=request.getContextPath()%>/ReglementServlet">Page de reglement</a>
		</nav>
	</header>
</body>
</html>
