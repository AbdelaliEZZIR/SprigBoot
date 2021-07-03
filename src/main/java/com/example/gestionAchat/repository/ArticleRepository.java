package com.example.gestionAchat.repository;

import com.example.gestionAchat.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {


    //@Query(value = "select * from article where code = ?",nativeQuery = true)
   //@Query(value = "select a from Artice a where a.code = :code and a.nom = :nom")  // language hql

    List<Article> findByEtat(String etat);

    Article findByCode(String code);

    @Query(value = "select a from Article a where a.description like %:designation%")
    List<Article> findByDesignation(String designation);
}
