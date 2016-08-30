package com.epiq.persistence.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
public class Devis implements Serializable {

    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_DEVIS")
    private long idDevis;
    @Column(name = "ID_CLIENT")
    private long idClient;
    @Column(name = "MONTANT")
    private double montant;
    @Column(name = "DATE_DEVIS")
    private Date dateDevis;

    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Client.class, fetch = FetchType.EAGER)
    @JoinTable(name = "etablir",
            joinColumns = @JoinColumn(name = "ID_DEVIS", referencedColumnName = "ID_DEVIS"),
            inverseJoinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID_CLIENT"))
    private Client client;


    @ManyToMany(mappedBy = "devisList",  fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> products;



    public Devis(){
    }

    public Devis(long idClient, double montant, Date dateDevis) {
        this.idClient = idClient;
        this.montant = montant;
        this.dateDevis = dateDevis;
    }

    public void updateWith(Devis devis){
        this.idClient = devis.idClient;
        this.montant = devis.montant;
        this.dateDevis = devis.dateDevis;
    }


    public long getIdDevis() {
        return idDevis;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDateDevis() {
        return dateDevis;
    }

    public void setDateDevis(Date dateDevis) {
        this.dateDevis = dateDevis;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
