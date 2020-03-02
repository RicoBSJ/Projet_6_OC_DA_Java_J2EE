package com.aubrun.eric.projet6.business.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ReservationDto {

    @Id
    @Column( name = "id" )
    Integer id;
    @Column( name = "numero" )
    Integer numReservation;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public Integer getNumReservation() {
        return numReservation;
    }

    public void setNumReservation( Integer numReservation ) {
        this.numReservation = numReservation;
    }
}