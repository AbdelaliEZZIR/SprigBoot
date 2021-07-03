package com.example.gestionAchat.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name ="utilisateur")
public class Utilisateur extends AbstractEntity {

    @Column(name = "nom")
    private String Nom;

    @Column(name = "prenom")
    private String Prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "adresse")
    private String Adresse ;

    @Column(name = "photo")
    private String photo;

    @Column(name = "tel")
    private String Tel;

    @Column(name = "motedepasse")
    private String motedepasse;

    @OneToMany(mappedBy = "utilisateur")
    private List<LigneCommande> ligneCommandes;

    @OneToMany(mappedBy = "utilisateur")
    private List<Article> articles;

}
