package com.example.gestionAchat.Service.strategy;

import com.example.gestionAchat.Dto.ArticleDto;
import com.example.gestionAchat.Service.ArticleService;
import com.example.gestionAchat.Service.FlickrServise;
import com.flickr4java.flickr.FlickrException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service("articleStrategy")
public class ArticleSavePhoto implements Strategy<ArticleDto> {

    FlickrServise flickrServise;
    ArticleService articleService;

    @Autowired
    public ArticleSavePhoto(FlickrServise flickrServise, ArticleService articleService) {
        this.flickrServise = flickrServise;
        this.articleService = articleService;
    }

    @Override
    public ArticleDto savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
        ArticleDto articleDto = articleService.findById(id);
        String urlPhoto = flickrServise.savePhoto(photo,titre);
        return articleService.create(articleDto);
    }
}
