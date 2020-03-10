<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/css/style.css" />" />
<title>${ site.nomSite }</title>
</head>
<body>
	<main class="container">
		<section>
			<article>
				<ul>
					<c:forEach var="site" items="${ sites }">
						<article class="resultats-listeStations even">
							<div class="localisationStationListe">
								<h3 class="nomStationListe">
									<a href="<c:url value="" />">${ site.nomSite }</a>
								</h3>
								<div class="massifListe">${ site.pays }</div>
								<div class="massifListe">${ site.region }</div>
							</div>
							<div class="thumbs-stations">
								<a href="<c:url value="/detailsSite" />"><img
									src="${ site.photos[0].url }" alt="Site"
									title="Détails du site" width="315" height="200" /></a>
								<%-- <div class="massifListe">${ site.descripSite }</div> --%>
							</div>
							<div class="results-right">
								<div class="infosStations">
									<span class="value"><span>${ site.hauteur } </span> de
										hauteur</span> <span class="value">Orientation <span>
											${ site.orientation }</span></span> <span class="value"><span>Cotation
									</span> ${ site.cotationSite }</span>
								</div>
							</div>
						</article>
					</c:forEach>
				</ul>
			</article>
		</section>
	</main>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>