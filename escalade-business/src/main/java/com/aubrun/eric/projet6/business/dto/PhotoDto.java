package com.aubrun.eric.projet6.business.dto;

public class PhotoDto {

    private Long   id;
    private String nom;
    private String chemin;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin( String chemin ) {
        this.chemin = chemin;
    }
}