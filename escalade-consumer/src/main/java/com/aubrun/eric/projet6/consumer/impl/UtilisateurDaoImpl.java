package com.aubrun.eric.projet6.consumer.impl;

import static com.aubrun.eric.projet6.consumer.DAOUtilitaire.fermeturesSilencieuses;
import static com.aubrun.eric.projet6.consumer.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.aubrun.eric.projet6.consumer.DAO.UtilisateurDao;
import com.aubrun.eric.projet6.consumer.exception.DAOException;
import com.aubrun.eric.projet6.consumer.factory.DAOFactory;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {

    private static final String SQL_SELECT_PAR_EMAIL = "SELECT id, email, nom, mot_de_passe, telephone FROM Utilisateur WHERE email = ?";
    private static final String SQL_INSERT           = "INSERT INTO Utilisateur (email, mot_de_passe, nom, telephone) VALUES (?, ?, ?, ?)";
    private static final String SQL_SELECT_PAR_ID    = "SELECT id, email, nom, mot_de_passe, telephone FROM Utilisateur WHERE id = ?";

    private DAOFactory          daoFactory;

    public UtilisateurDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<Utilisateur> lister() throws DAOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Utilisateur trouver( String email ) throws DAOException {
        return trouver( SQL_SELECT_PAR_EMAIL, email );
    }

    @Override
    public Utilisateur trouver( long id ) throws DAOException {
        return trouver( SQL_SELECT_PAR_ID, id );
    }

    @Override
    public void supprimer( Utilisateur utilisateur ) throws DAOException {
        // TODO Auto-generated method stub

    }

    /*
     * ImplÃ©mentation de la mÃ©thode dÃ©finie dans l'interface UtilisateurDao
     */
    @Override
    public void creer( Utilisateur utilisateur ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, utilisateur.getEmail(),
                    utilisateur.getMotDePasse(), utilisateur.getTelephone(), utilisateur.getNom() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException(
                        "Echec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                utilisateur.setId( valeursAutoGenerees.getInt( 1 ) );
            } else {
                throw new DAOException(
                        "Echec de la création de l'utilisateur en base, aucun ID auto-généré retourné." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

    /*
     * MÃ©thode gÃ©nÃ©rique utilisÃ©e pour retourner un utilisateur depuis la
     * base de donnÃ©es, correspondant Ã la requÃªte SQL donnÃ©e prenant en
     * paramÃ¨tres les objets passÃ©s en argument.
     */
    private Utilisateur trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur utilisateur = null;

        try {
            /* RÃ©cupÃ©ration d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            /*
             * PrÃ©paration de la requÃªte avec les objets passÃ©s en arguments
             * (ici, uniquement une adresse email) et exÃ©cution.
             */
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de donnÃ©es retournÃ©e dans le ResultSet */
            if ( resultSet.next() ) {
                utilisateur = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return utilisateur;
    }

    /*
     * Simple mÃ©thode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des utilisateurs (un
     * ResultSet) et un bean Utilisateur.
     */
    private static Utilisateur map( ResultSet resultSet ) throws SQLException {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId( resultSet.getInt( "id" ) );
        utilisateur.setEmail( resultSet.getString( "email" ) );
        utilisateur.setMotDePasse( resultSet.getString( "mot_de_passe" ) );
        utilisateur.setNom( resultSet.getString( "nom" ) );
        utilisateur.setTelephone( resultSet.getString( "telephone" ) );
        return utilisateur;
    }
}