package com.epiq.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Gestionnaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_GESTIONNAIRE")
    private long id;
    @Column(name = "NOM_GESTIONNAIRE")
    private String nom;
    @Column(name = "MOT_DE_PASSE")
    private String motDePasse;
    @ManyToMany(mappedBy = "gestionnaires",  fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> products;

    public Gestionnaire(){
    }

    public Gestionnaire(String nom, String motDePasse) {
        this.nom = nom;
        this.motDePasse = motDePasse;
    }


    public void updateWith (Gestionnaire gestionnaire) {
        this.nom = gestionnaire.nom;
        this.motDePasse = gestionnaire.motDePasse;
    }


    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) { this.products = products;
    }

}

