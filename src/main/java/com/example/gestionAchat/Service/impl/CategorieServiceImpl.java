package com.example.gestionAchat.Service.impl;

import com.example.gestionAchat.Dto.ArticleDto;
import com.example.gestionAchat.Dto.CategorieDto;
import com.example.gestionAchat.Model.Article;
import com.example.gestionAchat.Model.Categorie;
import com.example.gestionAchat.Service.CategorieService;
import com.example.gestionAchat.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategorieServiceImpl implements CategorieService {
    
    @Autowired
    CategorieRepository categorieRepository;
    @Override

    public CategorieDto create(CategorieDto dto) {
        return CategorieDto.fromEntity(
                categorieRepository.save(
                        CategorieDto.toEntity(dto)
                )
        );
    }

    @Override
    public CategorieDto update(CategorieDto dto) {
        return null;
    }

    @Override
    public CategorieDto findById(Integer id) {
        Optional<Categorie> categorie = categorieRepository.findById(id);
        if (categorie.isPresent()) {
            return CategorieDto.fromEntity(categorie.get());
        }
        return null;
    }

    @Override
    public List<CategorieDto> findAll() {
        return categorieRepository.findAll().stream()
                .map(CategorieDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        categorieRepository.deleteById(id);
    }
}
