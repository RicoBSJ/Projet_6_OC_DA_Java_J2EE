package com.aubrun.eric.projet6.business.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.aubrun.eric.projet6.business.dto.SecteurDto;
import com.aubrun.eric.projet6.business.dto.VoieDto;
import com.aubrun.eric.projet6.model.bean.Secteur;

public class SecteurDtoMapper {

    static public SecteurDto toDto( Secteur secteur ) {

        SecteurDto dto = new SecteurDto();
        dto.setId( secteur.getId() );
        dto.setNom( secteur.getNom() );
        dto.setDescription( secteur.getDescription() );
        List<VoieDto> voies = secteur.getVoies().stream().map( VoieDtoMapper::toDto )
                .collect( Collectors.toList() );
        dto.setVoies( voies );
        return dto;
    }

    static public Secteur toEntity( SecteurDto secteurDto ) {

        Secteur entity = new Secteur();
        entity.setId( secteurDto.getId() );
        entity.setNom( secteurDto.getNom() );
        entity.setDescription( secteurDto.getDescription() );
        return entity;
    }
}