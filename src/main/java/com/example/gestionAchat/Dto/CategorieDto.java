package com.example.gestionAchat.Dto;

import com.example.gestionAchat.Model.Categorie;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CategorieDto {

    private Integer id;

    private String code;

    private String designation;

    private List<ArticleDto> articlesDtos;

    public static CategorieDto fromEntity(Categorie category) {
        if (category == null) {
            return null;
        }
        return CategorieDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .build();
    }

    public static Categorie toEntity(CategorieDto categoryDto) {
        Categorie category = new Categorie();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());
        return category;
    }
}
