package com.example.gestionAchat.controller;

import com.example.gestionAchat.Model.auth.ExtendedUser;
import com.example.gestionAchat.Service.auth.ApplicationUserDetailsService;
import com.example.gestionAchat.controller.API.AuthenticationApi;
import com.example.gestionAchat.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;
import  com.example.gestionAchat.Dto.auth.AuthRequest;
import  com.example.gestionAchat.Dto.auth.AuthResponse;

@RestController
public class AuthenticationController implements AuthenticationApi {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private ApplicationUserDetailsService userDetailsService;

  @Autowired
  private JwtUtil jwtUtil;

  @Override
  public ResponseEntity<AuthResponse> authenticate(AuthRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getMotDePasse()
        )
    );
    final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

    final String jwt = jwtUtil.generateToken((ExtendedUser) userDetails);

    return ResponseEntity.ok(AuthResponse.builder().access(jwt).build());
  }

  @Override
  public String msg() {
    return "aaaaa";
  }

}
