package com.example.gestionAchat.Dto;

import com.example.gestionAchat.Model.Article;
import lombok.Builder;
import lombok.Data;

import javax.swing.text.BadLocationException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.List;

@Builder
@Data
public class ArticleDto {

    private Integer id;

    private String code;

    private String description;

    private String nom;

    private BigDecimal prix;

    private Blob photo;

    private String etat;

    private UtilisateurDto utilisateurDto;

    private CategorieDto categorieDto;

    public static ArticleDto fromEntity(Article article) {
        return ArticleDto.builder()
                .id(article.getId())
                .code(article.getCode())
                .description(article.getDescription())
                .nom(article.getNom())
                .photo(article.getPhoto())
                .prix(article.getPrix())
                .etat(article.getEtat())
                .utilisateurDto(UtilisateurDto.fromEntity(article.getUtilisateur()))
                .categorieDto(CategorieDto.fromEntity(article.getCategorie()))
                .build();
    }

    public static Article toEntity(ArticleDto articleDto) {
        if (articleDto == null) {
            return null;
        }
        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCode(articleDto.getCode());
        article.setNom(articleDto.getNom());
        article.setDescription(articleDto.getDescription());
        article.setPhoto(articleDto.getPhoto());
        article.setPrix(articleDto.getPrix());
        article.setEtat(articleDto.getEtat());
        article.setUtilisateur(UtilisateurDto.toEntity(articleDto.getUtilisateurDto()));
        article.setCategorie(CategorieDto.toEntity(articleDto.getCategorieDto()));
        return article;
    }

}
