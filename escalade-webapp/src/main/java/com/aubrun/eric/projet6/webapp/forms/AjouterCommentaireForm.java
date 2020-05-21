package com.aubrun.eric.projet6.webapp.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.aubrun.eric.projet6.model.bean.Commentaire;

public class AjouterCommentaireForm {

    private static final String CHAMP_COMMENTAIRE = "commentaire";
    private static final String CHAMP_TITRE       = "titre";

    private String              resultat;
    private Map<String, String> erreurs           = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public void setResultat( String result ) {
        this.resultat = result;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Commentaire ajouterCommentaire( HttpServletRequest request ) {
        String contenu = getValeurChamp( request, CHAMP_COMMENTAIRE );
        String titre = getValeurChamp( request, CHAMP_TITRE );

        Commentaire commentaire = new Commentaire();
        try {
            traiterCommentaire( contenu, commentaire );
            traiterTitre( titre, commentaire );
        } catch ( Exception e ) {
            resultat = "Echec de l'ajout de commentaire : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }
        return commentaire;
    }

    private void traiterCommentaire( String contenu, Commentaire commentaire ) {
        try {
            validationCommentaire( contenu );
        } catch ( Exception e ) {
            setErreur( CHAMP_COMMENTAIRE, e.getMessage() );
        }
        commentaire.setContenu( contenu );
    }

    private void traiterTitre( String titre, Commentaire commentaire ) {
        try {
            validationTitre( titre );
        } catch ( Exception e ) {
            setErreur( CHAMP_TITRE, e.getMessage() );
        }
        commentaire.setTitre( titre );
    }

    private void validationCommentaire( String contenu ) throws Exception {
        if ( contenu != null && contenu.length() < 30 ) {
            throw new Exception( "Le commentaire doit contenir au moins 30 caractères." );
        }
    }

    private void validationTitre( String titre ) throws Exception {
        if ( titre != null && titre.length() < 5 ) {
            throw new Exception( "Le titre doit contenir au moins 5 caractères." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    public void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}