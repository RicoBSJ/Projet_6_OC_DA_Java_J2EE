package com.aubrun.eric.projet6.consumer.DAO;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.aubrun.eric.projet6.consumer.HibernateUtils;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class UtilisateurDAO {

    SessionFactory factory = HibernateUtils.getSessionFactory();

    public List<Utilisateur> recupererUtilisateurs() {

        Session session = factory.getCurrentSession();
        List<Utilisateur> utilisateurs = null;

        try {
            session.getTransaction().begin();
            String q = "SELECT s FROM Utilisateur s";
            Query<Utilisateur> query = session.createQuery( q );
            utilisateurs = query.getResultList();
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
        return utilisateurs;
    }

    public Utilisateur afficherDetails( Integer id ) {

        Session session = factory.getCurrentSession();
        Utilisateur utilisateur = null;

        try {
            session.getTransaction().begin();
            String q = "SELECT s FROM Utilisateur s WHERE s.id=?1";
            TypedQuery<Utilisateur> query = session.createQuery( q, Utilisateur.class );
            query.setParameter( 1, id );
            utilisateur = query.getSingleResult();
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
        return utilisateur;
    }

    public void supprimerUtilisateur( int id ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();

            Utilisateur utilisateur = session.get( Utilisateur.class, id );
            if ( utilisateur != null ) {
                String q = "DELETE FROM Utilisateur s " + "WHERE s.id = :utilisateurId";
                Query<Utilisateur> query = session.createQuery( q );
                query.setParameter( "utilisateurId", id );
                int result = query.executeUpdate();
                System.out.println( result );
            }

            session.getTransaction().commit();
        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
    }

    public void ajouterUtilisateur() {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            String q = "INSERT INTO Utilisateur s (nom, prenom, adresse, telephone, email)" +
                    "SELECT nom, prenom, adresse, telephone, email FROM Utilisateur s";
            Query<Utilisateur> query = session.createQuery( q );
            int result = query.executeUpdate();
            System.out.println( result );
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
    }
}