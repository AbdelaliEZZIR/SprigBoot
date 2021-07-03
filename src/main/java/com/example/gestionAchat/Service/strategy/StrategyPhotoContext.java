package com.example.gestionAchat.Service.strategy;

import com.flickr4java.flickr.FlickrException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;

public class StrategyPhotoContext {

    BeanFactory  beanFactory;
    Strategy strategy;
    String context;

    @Autowired
    public StrategyPhotoContext(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Object savePhoto(String context, Integer id , InputStream photo, String title) throws FlickrException {
        determinContext(context);
        return strategy.savePhoto(id,photo,title) ;
    }

    public void determinContext(String context){
        final String name = context + "Strategy";
        switch (context){
            case "article":
                strategy = beanFactory.getBean(name,ArticleSavePhoto.class);
                break;
            case "utilisateur":
                strategy = beanFactory.getBean(name,UtilisateurSavePhoto.class);
                break;
        }
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
