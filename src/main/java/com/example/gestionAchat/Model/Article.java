package com.example.gestionAchat.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name ="article")

public class Article extends AbstractEntity  {

        @Column(name = "code")
        private String code;

        @Column(name = "nom")
        private String nom;

        @Column(name = "description")
        private String description;

        @Column(name ="prix")
        private BigDecimal prix;

        @Column(name = "photo")
        private Blob photo;

        @Column(name = "etat")
        private String etat;


        @ManyToOne
        @JoinColumn(name = "id_Vendeur")
        private Utilisateur utilisateur;

        @ManyToOne
        @JoinColumn(name = "id_categorie")
        private Categorie categorie;

        @OneToMany(mappedBy = "article")
        private List<LigneCommande> ligneCommandes;

}
