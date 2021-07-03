package com.example.gestionAchat.controller;

import com.example.gestionAchat.Dto.CategorieDto;
import com.example.gestionAchat.Service.CategorieService;
import com.example.gestionAchat.controller.API.CatergorieApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategorieController implements CatergorieApi {

    private CategorieService categorieService;

    @Autowired
    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }


    @Override
    public CategorieDto findById(Integer id) { return categorieService.findById(id); }

    @Override
    public CategorieDto create(CategorieDto dto) {
        return categorieService.create(dto);
    }

    @Override
    public CategorieDto update(CategorieDto dto) {
        return categorieService.update(dto);
    }

    @Override
    public List<CategorieDto> findAll() {
        return categorieService.findAll();
    }

    @Override
    public void delete(Integer id) {
        categorieService.delete(id);
    }
}
