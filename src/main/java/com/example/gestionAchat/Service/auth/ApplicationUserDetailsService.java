package com.example.gestionAchat.Service.auth;

import com.example.gestionAchat.Dto.UtilisateurDto;
import com.example.gestionAchat.Model.auth.ExtendedUser;
import com.example.gestionAchat.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

  @Autowired
  private UtilisateurService service;


  @Override
  public UserDetails loadUserByUsername(String email ) throws UsernameNotFoundException {
    UtilisateurDto utilisateur = service.findUtilisateur(email);

    List<SimpleGrantedAuthority> authorities = new ArrayList<>();

    return new ExtendedUser(utilisateur.getEmail(), utilisateur.getMotdePasse(), authorities);
  }
}
