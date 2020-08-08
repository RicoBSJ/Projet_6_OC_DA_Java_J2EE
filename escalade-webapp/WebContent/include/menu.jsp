<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="menu">
	<header>
		<div id="titre_principal">
			<div id="logo">
				<img src="<c:url value="/images/Les_amis_de_l_escalade.png"/>"
					alt="Logo des amis de l'escalade" />
				<h1>Les Amis de l'Escalade</h1>
			</div>
			<h2>Site développé par RicoBSJ</h2>
		</div>

		<nav>
			<ul>
				<c:if test="${empty sessionScope.sessionUtilisateur}">
					<li><a href="<c:url value="/rechercheSite" />">Recherche site</a></li>
				<li><a href="<c:url value="/inscription" />">Inscription</a></li>
				<li><a href="<c:url value="/connexion" />">Connexion</a></li>
				</c:if>
				<c:if test="${!empty sessionScope.sessionUtilisateur}">
					<li>${sessionScope.sessionUtilisateur.prenom} ${sessionScope.sessionUtilisateur.nom}</li>
					<c:choose>
					<c:when test="${sessionScope.sessionUtilisateur.membre == true}">
						<li><font color="yellow">Membre officiel</font></li>
					</c:when>
					<c:otherwise>
						<li><font color="blue">Utilisateur connecté</font></li>
					</c:otherwise>
					</c:choose>
					
					<li><a href="<c:url value="/creationSite" />">Création site</a></li>
					<li><a href="<c:url value="/listeUtilisateurs" />">Liste Utilisateurs</a></li>
					<li><a href="<c:url value="/afficherToposUtilisateur" />">Topo(s) utilisateur</a></li>
					<li><a href="<c:url value="/afficherToposDisponibles" />">Topo(s) disponible(s)</a></li>
					<li><a href="<c:url value="/afficherMessagesUtilisateur" />">Message(s)</a></li>
					<li><a href="<c:url value="/deconnexion" />">Deconnexion</a></li>
					
				</c:if>
			</ul>
		</nav>
	</header>
</div>