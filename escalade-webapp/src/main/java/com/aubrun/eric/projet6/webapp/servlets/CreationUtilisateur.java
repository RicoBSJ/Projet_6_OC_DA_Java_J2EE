package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aubrun.eric.projet6.model.bean.Utilisateur;
import com.aubrun.eric.projet6.webapp.form.CreationUtilisateurForm;

/**
 * Servlet implementation class CreationUtilisateur
 */
@WebServlet( "/creationUtilisateur" )
public class CreationUtilisateur extends HttpServlet {
    private static final long  serialVersionUID     = 1L;

    public static final String ATT_UTILISATEUR      = "utilisateur";
    public static final String ATT_FORM             = "form";
    public static final String SESSION_UTILISATEURS = "utilisateurs";

    public static final String VUE_SUCCES           = "/WEB-INF/jsp/afficherUtilisateur.jsp";
    public static final String VUE_FORM             = "/WEB-INF/jsp/creerUtilisateur.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* À la réception d'une requête GET, simple affichage du formulaire */
        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        CreationUtilisateurForm form = new CreationUtilisateurForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Utilisateur utilisateur = form.creerUtilisateur( request );

        /* Ajout du bean et de l'objet métier à l'objet requête */
        request.setAttribute( ATT_UTILISATEUR, utilisateur );
        request.setAttribute( ATT_FORM, form );

        /* Si aucune erreur */
        if ( form.getErreurs().isEmpty() ) {
            /* Alors récupération de la map des clients dans la session */
            HttpSession session = request.getSession();
            Map<String, Utilisateur> utilisateurs = (HashMap<String, Utilisateur>) session
                    .getAttribute( SESSION_UTILISATEURS );
            /*
             * Si aucune map n'existe, alors initialisation d'une nouvelle map
             */
            if ( utilisateurs == null ) {
                utilisateurs = new HashMap<String, Utilisateur>();
            }
            /* Puis ajout du client courant dans la map */
            utilisateurs.put( utilisateur.getNom(), utilisateur );
            /* Et enfin (ré)enregistrement de la map en session */
            session.setAttribute( SESSION_UTILISATEURS, utilisateurs );

            /* Affichage de la fiche récapitulative */
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            /* Sinon, ré-affichage du formulaire de création avec les erreurs */
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
    }

}
