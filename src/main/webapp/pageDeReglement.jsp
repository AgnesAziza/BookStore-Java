<%@ taglib prefix="c" uri="jakarta.tags.core" %><!DOCTYPE html>
<html>
<head>
<link href="pageDeReglement.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>Page de reglement Bookstore</title>
</head>
<body>
	<%@ include file="nav.jsp" %>
	<div class="containerPrincipalLibrairy">
	
	<div class=containerContact>
	<fieldset>
		<legend>Livraison</legend>
	<div class="contactButton">
	<p>Contact</p><button class="modif">Modifier</button>
	</div>
	<div class="epedierCommande">
		 <p>Expédier à </p><button class="modif">Modifier</button>
	</div>
	</fieldset>

	</div>
	<div class="containerPaiement">
	
	<fieldset>
		<legend>Paiement</legend>
		<p class="montant"><c:out value="Montant : ${totalCalcul } euros"></c:out><p>
	<p class="transaction">Toutes les transactions sont sécurisées et chifrées</p>
	<div>
	<input type="radio" id="card" name="card" value="creditCard" checked> 
	<label for="card">Carte de Crédit</label>
	</div>
	<div>
	<input type="radio" id="card" name="card" value="creditCard" checked> 
	<label for="card">Paypal</label>
	</div>
	</fieldset>
	</div>
	<div class="moyenDePaiement">
	<button class="buttonValiderPaiement">Valider mon paiement</button>
	</div>
	
	</div>
</body>
</html>