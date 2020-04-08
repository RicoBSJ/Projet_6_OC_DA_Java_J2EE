<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Liste des utilisateurs existants</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css"></c:url>" />
    </head>
    <body>
        <c:import url="/css/menu.jsp" ></c:import>
        <br>
        <div id="corps">
            <table>
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Adresse</th>
                    <th>Téléphone</th>
                    <th>Email</th>          
                </tr>
                <c:forEach var="utilisateur" items="${ utilisateurs }" >
                <tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
                    <%-- Affichage des propriétés du bean Utilisateur, qui est stocké en tant que valeur de l'entrée courante de la map --%>
                    <td><c:out value="${ utilisateur.nom }"></c:out></td>
                    <td><c:out value="${ utilisateur.prenom }"></c:out></td>
                    <td><c:out value="${ utilisateur.adresse }"></c:out></td>
                    <td><c:out value="${ utilisateur.telephone }"></c:out></td>
                    <td><c:out value="${ utilisateur.email }"></c:out></td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>