package com.aubrun.eric.projet6.model.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
public class Site {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Integer           id;
    @Column( name = "nom" )
    private String            nom;
    @Column( name = "pays" )
    private String            pays;
    @Column( name = "region" )
    private String            region;
    @Column( name = "description", columnDefinition = "text" )
    private String            description;
    @Column( name = "cotation" )
    private String            cotation;
    @Column( name = "hauteur" )
    private String            hauteur;
    @Column( name = "orientation" )
    private String            orientation;
    @Column( name = "officiel" )
    private Boolean           officiel;
    @OneToMany( cascade = CascadeType.ALL )
    @LazyCollection( LazyCollectionOption.FALSE )
    @JoinColumn( name = "id_site" )
    private List<Photo>       photos;
    @Column( name = "id_secteurs" )
    private String            secteurs;
    @Column( name = "id_longueurs" )
    private String            longueurs;
    @Column( name = "id_voies" )
    private String            voies;
    @OneToMany( cascade = CascadeType.ALL )
    @LazyCollection( LazyCollectionOption.FALSE )
    @JoinColumn( name = "id_site" )
    private List<Commentaire> commentaires;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays( String pays ) {
        this.pays = pays;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion( String region ) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getCotation() {
        return cotation;
    }

    public void setCotation( String cotation ) {
        this.cotation = cotation;
    }

    public String getHauteur() {
        return hauteur;
    }

    public void setHauteur( String hauteur ) {
        this.hauteur = hauteur;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation( String orientation ) {
        this.orientation = orientation;
    }

    public Boolean getOfficiel() {
        return officiel;
    }

    public void setOfficiel( Boolean officiel ) {
        this.officiel = officiel;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos( List<Photo> photos ) {
        this.photos = photos;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires( List<Commentaire> commentaires ) {
        this.commentaires = commentaires;
    }

    public String getSecteurs() {
        return secteurs;
    }

    public void setSecteurs( String secteurs ) {
        this.secteurs = secteurs;
    }

    public String getLongueurs() {
        return longueurs;
    }

    public void setLongueurs( String longueurs ) {
        this.longueurs = longueurs;
    }

    public String getVoies() {
        return voies;
    }

    public void setVoies( String voies ) {
        this.voies = voies;
    }
}