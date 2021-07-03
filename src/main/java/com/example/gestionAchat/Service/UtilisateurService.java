package com.example.gestionAchat.Service;

import com.example.gestionAchat.Dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {

  UtilisateurDto save(UtilisateurDto dto);

  UtilisateurDto findById(Integer id);

  void delete(Integer id);

  UtilisateurDto getUtilisateur(String email,String motDePasse);

  UtilisateurDto findUtilisateur(String email);


}
