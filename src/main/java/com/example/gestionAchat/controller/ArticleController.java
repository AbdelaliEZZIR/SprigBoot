package com.example.gestionAchat.controller;

import com.example.gestionAchat.Dto.ArticleDto;
import com.example.gestionAchat.Service.ArticleService;
import com.example.gestionAchat.Service.strategy.ArticleSavePhoto;
import com.example.gestionAchat.controller.API.articleApi;
import com.flickr4java.flickr.FlickrException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;

@RestController
public class ArticleController implements articleApi {

    private final ArticleService articleService;
    ArticleSavePhoto articleSavePhoto;

    @Autowired
    public ArticleController(ArticleService articleService ,ArticleSavePhoto articleSavePhoto ) {
        this.articleService = articleService;
        this.articleSavePhoto = articleSavePhoto;
    }

    @Override
    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findByCode(String code) {
        return articleService.findByCode(code);
    }

    @Override
    public ArticleDto savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
       return articleSavePhoto.savePhoto(id,photo,titre);
    }

    @Override
    public ArticleDto create(ArticleDto dto) {
        return articleService.create(dto);

    }

    @Override
    public ArticleDto update(ArticleDto dto) {
        return articleService.update(dto);
    }

    @Override
    public List<ArticleDto> findByDesignation(String designation) {
        return articleService.findByDesignation(designation);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public List<ArticleDto> findEtat(String etat) {
        return articleService.findEtat(etat);
    }

    @Override
    public void delete(Integer id) {
        articleService.delete(id);
    }
}
