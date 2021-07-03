package com.example.gestionAchat.controller;

import com.example.gestionAchat.Dto.UtilisateurDto;
import com.example.gestionAchat.Service.UtilisateurService;
import com.example.gestionAchat.controller.API.UtilisateurApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilisateurController implements UtilisateurApi {

  private UtilisateurService utilisateurService;

  @Autowired
  public UtilisateurController(UtilisateurService utilisateurService) {
    this.utilisateurService = utilisateurService;
  }

  @Override
  public UtilisateurDto save(UtilisateurDto dto) {

    return utilisateurService.save(dto);
  }


  @Override
  public UtilisateurDto findById(Integer id) {
    return utilisateurService.findById(id);
  }

  @Override
  public UtilisateurDto getUtilisateur(String email, String motDePasse) {
    return utilisateurService.getUtilisateur(email,motDePasse);
  }

  @Override
  public UtilisateurDto findUtilisateur(String email) {

    return utilisateurService.findUtilisateur(email);
  }

  @Override
  public void delete(Integer id) {
    utilisateurService.delete(id);
  }
}
