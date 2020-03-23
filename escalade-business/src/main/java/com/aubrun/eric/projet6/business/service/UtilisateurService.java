package com.aubrun.eric.projet6.business.service;

import com.aubrun.eric.projet6.business.dto.UtilisateurDto;
import com.aubrun.eric.projet6.consumer.DAO.UtilisateurDAO;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class UtilisateurService {

    private UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

    public UtilisateurDto recordUser() {

        Utilisateur utilisateur = utilisateurDAO.inscrireUtilisateur();
        UtilisateurDto dto = new UtilisateurDto();
        // UtilisateurDto utilisateurDto = UtilisateurDtoMapper.toDto( u );
        // dto.add( utilisateurDto );
        return dto;
    }
}