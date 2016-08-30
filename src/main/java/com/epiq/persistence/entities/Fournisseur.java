package com.epiq.persistence.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Fournisseur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_FOURNISSEUR")
    private long idFournisseur;
    @Column(name = "NOM__FOURNISSEUR")
    private String nomFournisseur;
    @Column(name = "MOBILE__FOURNISSEUR")
    private int mobileFournisseur;
    @Column(name = "EMAIL__FOURNISSEUR")
    private String emailFournisseur;
    @Column(name = "ADRESSE__FOURNISSEUR")
    private String adresseFournisseur;

    @ManyToMany(mappedBy = "fournisseurs",  fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> products;


    private Fournisseur(){
    }

    public Fournisseur(String nomFournisseur, int mobileFournisseur, String emailFournisseur, String adresseFournisseur) {
        this.nomFournisseur = nomFournisseur;
        this.mobileFournisseur = mobileFournisseur;
        this.emailFournisseur = emailFournisseur;
        this.adresseFournisseur = adresseFournisseur;
    }


    public void updateWith (Fournisseur fournisseur) {
        this.nomFournisseur = fournisseur.nomFournisseur;
        this.mobileFournisseur = fournisseur.mobileFournisseur;
        this.emailFournisseur = fournisseur.emailFournisseur;
        this.adresseFournisseur = fournisseur.adresseFournisseur;
    }


    public long getIdFournisseur() {
        return idFournisseur;
    }


    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public int getMobileFournisseur() {
        return mobileFournisseur;
    }

    public void setMobileFournisseur(int mobileFournisseur) {
        this.mobileFournisseur = mobileFournisseur;
    }

    public String getEmailFournisseur() {
        return emailFournisseur;
    }

    public void setEmailFournisseur(String emailFournisseur) {
        this.emailFournisseur = emailFournisseur;
    }

    public String getAdresseFournisseur() {
        return adresseFournisseur;
    }

    public void setAdresseFournisseur(String adresseFournisseur) {
        this.adresseFournisseur = adresseFournisseur;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
