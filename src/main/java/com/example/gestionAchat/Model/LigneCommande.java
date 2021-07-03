package com.example.gestionAchat.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Data
@Entity
@Table(name ="ligneCommande")
public class LigneCommande extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "datecommande")
    private Instant dateCommande;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @ManyToOne()
    @JoinColumn(name = "id_utilisateur")
    private  Utilisateur utilisateur;

    @ManyToOne()
    @JoinColumn(name = "id_Article")
    private   Article article;


}
