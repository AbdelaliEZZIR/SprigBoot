package com.example.gestionAchat.Service.impl;
import com.example.gestionAchat.Dto.ArticleDto;
import com.example.gestionAchat.Model.Article;
import com.example.gestionAchat.Model.Categorie;
import com.example.gestionAchat.Service.ArticleService;
import com.example.gestionAchat.repository.ArticleRepository;
import com.example.gestionAchat.repository.CategorieRepository;
import com.example.gestionAchat.repository.LigneCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;
    private LigneCommandeRepository commandeClientRepository;
    private CategorieRepository categorieRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository, LigneCommandeRepository commandeClientRepository ,CategorieRepository categorieRepository) {
        this.articleRepository = articleRepository;
        this.commandeClientRepository = commandeClientRepository;
        this.categorieRepository = categorieRepository;
    }

    @Override
    public ArticleDto create(ArticleDto dto) {
        dto.setEtat("EnAttend");
        return ArticleDto.fromEntity(
                articleRepository.save(
                        ArticleDto.toEntity(dto)
                )
        );
    }

    @Override
    public ArticleDto update(ArticleDto dto) {
        dto.setEtat("Vendu");
        Optional<Article> article = articleRepository.findById(dto.getId());
        if (article.isPresent()) {
            Article art  = article.get();
            art.setEtat(dto.getEtat());
            articleRepository.save(art);
           return ArticleDto.fromEntity(art);
        }
        return null;
    }

    @Override
    public ArticleDto findById(Integer id) {
        Optional<Article> article = articleRepository.findById(id);
        if (article.isPresent()) {
            return ArticleDto.fromEntity(article.get());
        }
        return null;
    }

    @Override
    public List<ArticleDto> findByDesignation(String designation) {
        List<ArticleDto> articleDto =  articleRepository.findByDesignation(designation).stream().map(ArticleDto::fromEntity).collect(Collectors.toList());
        return articleDto;
    }

    @Override
    public ArticleDto findByCode(String Code) {
        ArticleDto articleDto = ArticleDto.fromEntity(articleRepository.findByCode(Code));
        return articleDto;

    }

    @Override
    public List<ArticleDto> findAll() {
        List<ArticleDto> articleDtos = articleRepository.findAll().stream().map(ArticleDto::fromEntity).collect(Collectors.toList());
        return articleDtos;
    }

    @Override
    public List<ArticleDto> findEtat(String etat) {
        List<ArticleDto> articleDtos = articleRepository.findByEtat(etat).stream().map(ArticleDto::fromEntity).collect(Collectors.toList());
        return articleDtos;
    }

    @Override
    public void delete(Integer id) {
        articleRepository.deleteById(id);
    }
}
