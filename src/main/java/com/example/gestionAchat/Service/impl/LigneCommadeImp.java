package com.example.gestionAchat.Service.impl;


import com.example.gestionAchat.Dto.ArticleDto;
import com.example.gestionAchat.Dto.LigneCommandeDto;
import com.example.gestionAchat.Service.LigneCommandeService;
import com.example.gestionAchat.repository.LigneCommandeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class LigneCommadeImp implements LigneCommandeService {

    LigneCommandeRepository ligneCommandeRepository ;
    ArticleServiceImpl articleService ;

    @Autowired
    public LigneCommadeImp(LigneCommandeRepository ligneCommandeRepository, ArticleServiceImpl articleService) {
        this.ligneCommandeRepository = ligneCommandeRepository;
        this.articleService = articleService;
    }




    @Override
    public LigneCommandeDto create(LigneCommandeDto dto) {
        articleService.update(dto.getArticleDtos());
        return LigneCommandeDto.fromEntity(ligneCommandeRepository.save(LigneCommandeDto.toEntity(dto)));

    }

    @Override
    public LigneCommandeDto findById(Integer id) {
        return null;
    }

    @Override
    public List <LigneCommandeDto> findByUtilisateur(Integer id ) {
        List<LigneCommandeDto> ligneCommandeDtos = ligneCommandeRepository.findByutilisateur(id).stream().map(LigneCommandeDto::fromEntity).collect(Collectors.toList());
        return ligneCommandeDtos;
    }

    @Override
    public List<LigneCommandeDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
