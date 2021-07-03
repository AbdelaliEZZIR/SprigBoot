package com.example.gestionAchat.Dto;

import com.example.gestionAchat.Model.LigneCommande;
import com.example.gestionAchat.Model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class LigneCommandeDto {

    private Integer id;

    private Instant DateCommande;

    private  UtilisateurDto utilisateurDto;

    private ArticleDto  articleDtos;

    public static LigneCommandeDto fromEntity(LigneCommande ligneCommande) {

        return LigneCommandeDto.builder()
                .id(ligneCommande.getId())
                .DateCommande(ligneCommande.getDateCommande())
                .utilisateurDto(UtilisateurDto.fromEntity(ligneCommande.getUtilisateur()))
                .articleDtos(ArticleDto.fromEntity(ligneCommande.getArticle()))
                .build();

    }

    public static LigneCommande toEntity(LigneCommandeDto dto) {
        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setId(dto.getId());
        ligneCommande.setUtilisateur(UtilisateurDto.toEntity(dto.getUtilisateurDto()));
        ligneCommande.setDateCommande(dto.getDateCommande());
        ligneCommande.setArticle(ArticleDto.toEntity(dto.getArticleDtos()));
        return ligneCommande;
    }

}
