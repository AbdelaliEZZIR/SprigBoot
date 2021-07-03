package com.example.gestionAchat.Service.impl;


import com.example.gestionAchat.Dto.ArticleDto;
import com.example.gestionAchat.Dto.UtilisateurDto;
import com.example.gestionAchat.Model.Article;
import com.example.gestionAchat.Model.Utilisateur;
import com.example.gestionAchat.Service.UtilisateurService;
import com.example.gestionAchat.repository.UtilisateurRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {


  private UtilisateurRepository utilisateurRepository;

@Autowired
  public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
    this.utilisateurRepository = utilisateurRepository;
  }

  @Override
  public UtilisateurDto save(UtilisateurDto dto) {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    dto.setMotdePasse(bCryptPasswordEncoder.encode(dto.getMotdePasse()));
    return UtilisateurDto.fromEntity(
            utilisateurRepository.save(
                    UtilisateurDto.toEntity(dto)
            )
    );
  }

  @Override
  public UtilisateurDto findById(Integer id) {
    Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
    if (utilisateur.isPresent()) {
      return UtilisateurDto.fromEntity(utilisateur.get());
    }
    return null;
  }

  @Override
  public void delete(Integer id) {

  }

  @Override
  public UtilisateurDto getUtilisateur(String email, String motDePasse) {
    UtilisateurDto utilisateurDto  = UtilisateurDto.fromEntity(utilisateurRepository.getUtilisateur(email,motDePasse));
    return  utilisateurDto;
  }

  @Override
  public UtilisateurDto findUtilisateur(String email) {
    UtilisateurDto utilisateurDto  = UtilisateurDto.fromEntity(utilisateurRepository.findByEmail(email));
    return  utilisateurDto;
  }


}
