package com.epiq.persistence.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CLIENT")
    private long idClient;
    @Column(name = "NOM_CLIENT")
    private String nomClient;
    @Column(name = "PRENOM_CLIENT")
    private String prenomClient;
    @Column(name = "EMAIL_CLIENT")
    private String emailClient;
    @Column(name = "ADRESSE_CLIENT")
    private String adresseClient;
    @Column(name = "MOBILE_CLIENT")
    private String mobileClient;

    @OneToMany(mappedBy = "client",  fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Devis> devisList;


    public Client(){
    }

    public Client(String nomClient, String prenomClient, String emailClient, String adresseClient, String mobileClient) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.emailClient = emailClient;
        this.adresseClient = adresseClient;
        this.mobileClient = mobileClient;
    }


    public void updateWith(Client client){
        this.nomClient = client.nomClient;
        this.prenomClient = client.prenomClient;
        this.emailClient = client.emailClient;
        this.adresseClient = client.adresseClient;
        this.mobileClient = client.mobileClient;

    }


    public long getIdClient() {
        return idClient;
    }


    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public String getMobileClient() {
        return mobileClient;
    }

    public void setMobileClient(String mobileClient) {
        this.mobileClient = mobileClient;
    }

    public List<Devis> getDevisList() {
        return devisList;
    }

    public void setDevisList(List<Devis> devisList) {
        this.devisList = devisList;
    }

}
