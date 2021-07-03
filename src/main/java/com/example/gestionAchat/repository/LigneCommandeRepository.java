package com.example.gestionAchat.repository;

import com.example.gestionAchat.Model.Article;
import com.example.gestionAchat.Model.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Integer> {

    @Query(value = "select a from LigneCommande a where a.utilisateur.id = :id")
    List<LigneCommande> findByutilisateur(@Param("id")Integer id);
}
