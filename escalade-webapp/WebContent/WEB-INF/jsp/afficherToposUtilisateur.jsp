<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Liste des utilisateurs existants</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/include/style.css"></c:url>" />
</head>
<body>
	<c:import url="/include/menu.jsp"></c:import>
	<div id="corps">
		<fieldset>
			<legend>Liste des topos de l'utilisateur connect�</legend>
			<c:if test="${!empty sessionScope.sessionUtilisateur}">
			<table>
                <tr>
                    <th>Nom</th>
                    <th>Description</th>
                    <th>Lieu</th>
                    <th>Date de parution</th>
                    <th>Site du topo</th>
                    <th>Utilisateur</th>
                    <th>Disponibilit�</th>
                </tr>
                <c:forEach items="${ topos }" var="topo">
                <%-- Simple test de parit� sur l'index de parcours, pour alterner la couleur de fond de chaque ligne du tableau. --%>
                <tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
                    <%-- Affichage des propri�t�s du bean Utilisateur, qui est stock� en tant que valeur de l'entr�e courante de la map --%>
                    <td><c:out value="${ topo.nom }"></c:out></td>
                    <td><c:out value="${ topo.description }"></c:out></td>
                    <td><c:out value="${ topo.lieu }"></c:out></td>
                    <td><c:out value="${ topo.dateParution }"></c:out></td>
                    <td><c:out value="${ topo.site.nom }"></c:out></td>
                    <td><c:out value="${ topo.utilisateur.nom }"></c:out></td>
					<td><c:if test="${topo.disponible == true}">
					<form action="etatTopo" method="post">
						<input type="hidden" value="${ topo.id }" name="idTopo">
						<input type="submit" name="tag" value="Disponible" />
					</form>
					</c:if>
					<c:if test="${topo.disponible == false}">
					<form action="etatTopo" method="post">
						<input type="hidden" value="${ topo.id }" name="idTopo">
						<input type="submit" name="tag" value="Non Disponible" />
					</form>
					</c:if>
					</td>
                </tr>
                </c:forEach>
            </table>
			</c:if>
		</fieldset>
	</div>
	<p>
		<c:if test="${sessionScope.sessionUtilisateur.membre == true}">
			<a href="<c:url value="/ajouterTopo?id=${topo.id}" />">Ajouter un topo</a>
		</c:if><br><br>
		<a href="<c:url value="/accueil"/>">Retour � l'accueil</a>
	</p>
</body>
</html>