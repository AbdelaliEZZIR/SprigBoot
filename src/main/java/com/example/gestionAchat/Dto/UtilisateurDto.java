package com.example.gestionAchat.Dto;

import com.example.gestionAchat.Model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class UtilisateurDto {

    private Integer id;

    private String Nom;

    private String Prenom;

    private String Email;

    private String Adresse ;

    private String Tel;

    private String Photo;

    private String MotdePasse;

    private List<LigneCommandeDto> ligneCommandeDtos;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return null;
        }

        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .Nom(utilisateur.getNom())
                .Prenom(utilisateur.getPrenom())
                .Email(utilisateur.getEmail())
                .MotdePasse(utilisateur.getMotedepasse())
                .Photo(utilisateur.getPhoto())
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDto dto) {
        if (dto == null) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(dto.getId());
        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setEmail(dto.getEmail());
        utilisateur.setMotedepasse(dto.getMotdePasse());
        utilisateur.setPhoto(dto.getPhoto());
        return utilisateur;
    }

}
