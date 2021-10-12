package com.oc.projets.siteemploibatch.model;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur {

    private Long id;

    private String nom;

    private String prenom;

    private String email;

    private String password;

    private Adresse adresse;

    private List<Adresse> adressesSecondaires = new ArrayList<Adresse>();

    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<Adresse> getAdressesSecondaires() {
        return adressesSecondaires;
    }

    public void setAdressesSecondaires(List<Adresse> adressesSecondaires) {
        this.adressesSecondaires = adressesSecondaires;
    }

    public void addAdresseSecondaire(Adresse adresse) {
        this.adressesSecondaires.add(adresse);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
