package com.aubrun.eric.projet6.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Topo {

    @Id
    @Column( name = "id" )
    Integer id;
    @Column( name = "nom" )
    String  nomTopo;
    @Column( name = "description" )
    String  descriptTopo;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getNomTopo() {
        return nomTopo;
    }

    public void setNomTopo( String topo ) {
        this.nomTopo = topo;
    }

    public String getDescriptTopo() {
        return descriptTopo;
    }

    public void setDescriptTopo( String descriptTopo ) {
        this.descriptTopo = descriptTopo;
    }
}