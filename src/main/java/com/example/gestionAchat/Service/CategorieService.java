package com.example.gestionAchat.Service;

import com.example.gestionAchat.Dto.CategorieDto;

import java.util.List;

public interface CategorieService {
    CategorieDto create(CategorieDto dto);
    CategorieDto update(CategorieDto dto);
    CategorieDto findById(Integer id);
    List<CategorieDto> findAll();
    void delete (Integer id );
}
