package com.example.gestionAchat.Service;

import com.flickr4java.flickr.FlickrException;

import java.io.InputStream;

public interface FlickrServise {
    String savePhoto(InputStream photo ,String title) throws FlickrException;
}
