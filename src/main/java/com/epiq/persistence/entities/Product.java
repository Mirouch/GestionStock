package com.epiq.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PRODUIT")
    private long id;
    @Column(name = "TAG")
    private int tag;
    @Column(name = "NOM_PRODUIT")
    //@JsonProperty("name")
    private String nom;
    @Column(name = "REFERENCE")
    private int reference;
    @Column(name = "DESIGNATION")
    private String designation;
    @Column(name = "PRIX_ACHAT")
    private double prixAchat;
    @Column(name = "PRIX_VENTE")
    private double prixVente;
    @Column(name = "QTE_PHYSIQUE")
    private int quantitePhysique;
    @Column(name = "QTE_THEORIQUE")
    private int quantiteTheorique;
    @Column(name = "QTE_ALERTE")
    private int quantiteAlerte;
    @Column(name = "QTE_REAPPROVISIONNEMENT")
    private int quantiteReapprovisionnement;
    @Column(name = "LOCALISATION")
    private String localisation;
    @Column(name = "EMPLACEMENT")
    private String emplacement;
    @Column(name = "DATE_ENTREE")
    private Date dateEntree;
    @Column(name = "DATE_SORTIE")
    private Date dateSortie;

    @ManyToMany(cascade = CascadeType.ALL,targetEntity = Gestionnaire.class, fetch = FetchType.EAGER)
    @JoinTable(name = "gerer",
            joinColumns = @JoinColumn(name = "ID_PRODUIT", referencedColumnName = "ID_PRODUIT"),
            inverseJoinColumns = @JoinColumn(name = "ID_GESTIONNAIRE", referencedColumnName = "ID_GESTIONNAIRE"))
    private List<Gestionnaire> gestionnaires;


    @ManyToMany(cascade = CascadeType.ALL,targetEntity = Devis.class, fetch = FetchType.EAGER)
    @JoinTable(name = "composer",
            joinColumns = @JoinColumn(name = "ID_PRODUIT", referencedColumnName = "ID_PRODUIT"),
            inverseJoinColumns = @JoinColumn(name = "ID_DEVIS", referencedColumnName = "ID_DEVIS"))
    private List<Devis> devisList;


    @ManyToMany(cascade = CascadeType.ALL,targetEntity = Fournisseur.class, fetch = FetchType.EAGER)
    @JoinTable(name = "detailReapprovisionnement",
            joinColumns = @JoinColumn(name = "ID_PRODUIT", referencedColumnName = "ID_PRODUIT"),
            inverseJoinColumns = @JoinColumn(name = "ID_FOURNISSEUR", referencedColumnName = "ID_FOURNISSEUR"))
    private List<Fournisseur> fournisseurs;


    public Product() {
    }

    public Product(int tag, String nom, int reference, String designation, double prixAchat, double prixVente, int quantitePhysique, int quantiteTheorique,
                   int quantiteAlerte, int quantiteReapprovisionnement, String localisation, String emplacement, Date dateEntree, Date dateSortie) {
        this.tag = tag;
        this.nom = nom;
        this.reference = reference;
        this.designation = designation;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.quantitePhysique = quantitePhysique;
        this.quantiteTheorique = quantiteTheorique;
        this.quantiteAlerte = quantiteAlerte;
        this.quantiteReapprovisionnement = quantiteReapprovisionnement;
        this.localisation = localisation;
        this.emplacement = emplacement;
        this.dateEntree = dateEntree;
        this.dateSortie = dateSortie;
    }

    public void updateWith (Product product) {
        this.tag = product.tag;
        this.nom = product.nom;
        this.reference = product.reference;
        this.designation = product.designation;
        this.prixAchat = product.prixAchat;
        this.prixVente = product.prixVente;
        this.quantitePhysique = product.quantitePhysique;
        this.quantiteTheorique = product.quantiteTheorique;
        this.quantiteAlerte = product.quantiteAlerte;
        this.quantiteReapprovisionnement = product.quantiteReapprovisionnement;
        this.localisation = product.localisation;
        this.emplacement = product.emplacement;
        this.dateEntree = product.dateEntree;
        this.dateSortie = product.dateSortie;
    }

    public long getId() {
        return id;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public int getQuantitePhysique() {
        return quantitePhysique;
    }

    public void setQuantitePhysique(int quantitePhysique) {
        this.quantitePhysique = quantitePhysique;
    }

    public int getQuantiteTheorique() {
        return quantiteTheorique;
    }

    public void setQuantiteTheorique(int quantiteTheorique) {
        this.quantiteTheorique = quantiteTheorique;
    }

    public int getQuantiteAlerte() {
        return quantiteAlerte;
    }

    public void setQuantiteAlerte(int quantiteAlerte) {
        this.quantiteAlerte = quantiteAlerte;
    }

    public int getQuantiteReapprovisionnement() {
        return quantiteReapprovisionnement;
    }

    public void setQuantiteReapprovisionnement(int quantiteReapprovisionnement) {
        this.quantiteReapprovisionnement = quantiteReapprovisionnement;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }


    public List<Gestionnaire> getGestionnaires() {
        return gestionnaires;
    }

    public void setGestionnaires(List<Gestionnaire> gestionnaires) {
        this.gestionnaires = gestionnaires;
    }

    public List<Devis> getDevisList() {
        return devisList;
    }

    public void setDevisList(List<Devis> devisList) {
        this.devisList = devisList;
    }

    public List<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    public void setFournisseurs(List<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }
}
