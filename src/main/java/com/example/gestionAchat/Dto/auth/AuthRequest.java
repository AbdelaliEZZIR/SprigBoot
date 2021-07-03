package com.example.gestionAchat.Dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthRequest {
    String Email ;
    String MotDePasse;

}
