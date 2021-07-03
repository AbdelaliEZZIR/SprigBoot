package com.example.gestionAchat.repository;

import com.example.gestionAchat.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    @Query(value = "select u from Utilisateur u where u.email = :email and u.motedepasse = :motedepasse ")
    Utilisateur getUtilisateur(@Param("email") String email, @Param("motedepasse")String motedepasse);

    Utilisateur findByEmail(String email);



}
