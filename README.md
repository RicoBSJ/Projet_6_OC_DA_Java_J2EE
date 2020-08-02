# Réalisation de l'application web "LES AMIS DE L'ESCALADE", Projet 6, dans le cadre de la formation DA JAVA JEE OPENCLASSROOMS

	Création d'un site communautaire autour de l'escalade pour l'association "Les amis de l'escalade".

# Contexte :

	Avec l’objectif de fédérer les licenciés, l’association “Les amis de l’escalade” souhaite développer
	sa présence en ligne. À ce titre, plusieurs axes d’amélioration ont été identifiés dont la création 
	d’un site communautaire.
	Ce site aura pour but la mise en relation et le partage d’informations. Il permettra de donner 
	de la visibilité l’association afin d’encourager des grimpeurs indépendants à y adhérer.


## Les fonctionnalités :

	- F1 : Un utilisateur doit pouvoir consulter les informations des sites	d’escalades
	(secteurs, voies, longueurs, etc.).

	- F2 : Un utilisateur doit pouvoir faire une recherche à l’aide de plusieurs critères 
	pour trouver un site de grimpe et consulter le résultat de cette recherche. 
	Les critères peuvent être le lieu, la cotation, le nombre de secteurs, etc.

	- F3 : Un utilisateur doit pouvoir s’inscrire gratuitement sur le site.

	- F4 : Un utilisateur connecté doit pouvoir partager des informations sur un site d’escalade
	(secteurs, voies, longueurs, etc.).

	- F5 : Un utilisateur connecté doit pouvoir laisser des commentaires sur les pages des sites d’escalade.

	- F6 : Un membre de l'association doit pouvoir taguer un site d’escalade enregistré 
	sur la plateforme comme « Officiel Les amis de l’escalade ».

	- F7 : Un membre de l'association doit pouvoir modifier et supprimer un commentaire.

	- F8 : Un utilisateur connecté doit pouvoir enregistrer dans son espace	personnel 
	les topos qu’ils possèdent et préciser si ces derniers sont disponibles pour être prêtés ou non.
	Un topo est défini par un nom, une description, un lieu et une date de parution.

	- F9 : Un utilisateur connecté doit pouvoir consulter la liste des topos disponibles par d’autres 
	utilisateurs et faire une demande de réservation. La réservation n’inclut pas les notions de date 
	de début et date de fin.

	- F10 : Un utilisateur connecté doit pouvoir accepter une demande de réservation.
	Si une réservation est acceptée, automatiquement le topo devient indisponible. 
	L’utilisateur connecté pourra ensuite de nouveau changer le statut du topo en « disponible ».
	La plateforme se contente de mettre en contact les deux parties pour le	prêt d’un topo 
	(par échange de coordonnées).

	
## Les contraintes fonctionnelles

	- Le vocabulaire de l’escalade doit être utilisé : site, spot, voie, longueur, grimpeur, point ou spit, cotation, topo.
	- Le site doit être ​responsive : mon site est responsive grace à Bootstrap
	- Le site doit être sécurisé : les mots de passe enregistrés dans la base de données sont cryptés
	
## Spécificités
	
	## Développement

	Cette application a été développé avec :
	
	- Eclipse IDE for Enterprise Java Developers (version: 2020-03 (4.15.0))
	- Apache Maven 3.6.3
	- Java 8 (version 1.8 Update 251)
	- Tomcat 9.0.30
	- PostgreSql 12 (version 10.12 - 10.14)
	- Hibernate ORM (version hibernate-release-5.4.10.Final)
	
	## Déploiement
	
	Vous devez au-préalable télécharger et installer :
	
	- Java sur https://www.java.com/fr/download/
	- Le JDK sur https://www.oracle.com/fr/java/technologies/javase/javase-jdk8-downloads.html
	- Apache Maven sur https://maven.apache.org/download.cgi (n'oubliez pas d'ajouter la variable d'environnement d'Apache au "Path")
	- Apache Tomcat sur https://tomcat.apache.org/download-90.cgi
	- PostgreSQL sur https://www.postgresql.org/download/
	

    ## Lancement de l'application

    Dans le navigateur, entrer l'adresse suivante :
    http://localhost:8080/escalade-webapp/accueil

## Auteur

Rico BSJ
