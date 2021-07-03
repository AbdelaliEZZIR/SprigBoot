package com.example.gestionAchat.Service;

import com.example.gestionAchat.Dto.ArticleDto;

import java.util.List;

public interface ArticleService {
    ArticleDto create(ArticleDto dto);
    ArticleDto update(ArticleDto dto);
    ArticleDto findById(Integer id);
    ArticleDto findByCode(String Code);
    List<ArticleDto> findByDesignation(String designation);
    List<ArticleDto> findAll();
    List<ArticleDto> findEtat(String etat);
    void delete (Integer id );

}
