package com.example.gestionAchat.Service;

import com.example.gestionAchat.Dto.LigneCommandeDto;

import java.util.List;

public interface LigneCommandeService  {
    LigneCommandeDto create(LigneCommandeDto dto);
    LigneCommandeDto findById(Integer id);
    List<LigneCommandeDto> findByUtilisateur(Integer id);
    List<LigneCommandeDto> findAll();
    void delete (Integer id );

}
