package com.oc.projets.siteemploibatch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

public class Annonce {

    private Long id;

    private String titre;

    private Utilisateur recruteur;

    @JsonIgnoreProperties("posteList")
    private Secteur secteur;

    @JsonIgnoreProperties("secteur")
    private Poste poste;

    private List<Utilisateur> utilisateurListWhoRead = new ArrayList<Utilisateur>();

    private TypeContrat typeContrat;

    private String description;

    private int salaireMinimum;

    private int salaireMaximum;

    private Boolean publie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Utilisateur getRecruteur() {
        return recruteur;
    }

    public void setRecruteur(Utilisateur recruteur) {
        this.recruteur = recruteur;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public List<Utilisateur> getUtilisateurListWhoRead() {
        return utilisateurListWhoRead;
    }

    public void setUtilisateurListWhoRead(List<Utilisateur> utilisateurListHowRead) {
        this.utilisateurListWhoRead = utilisateurListHowRead;
    }

    public void addUtilisateurListHowRead(Utilisateur utilisateur) {
        this.utilisateurListWhoRead.add(utilisateur);
    }

    public TypeContrat getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(TypeContrat typeContrat) {
        this.typeContrat = typeContrat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSalaireMinimum() {
        return salaireMinimum;
    }

    public void setSalaireMinimum(int salaireMinimum) {
        this.salaireMinimum = salaireMinimum;
    }

    public int getSalaireMaximum() {
        return salaireMaximum;
    }

    public void setSalaireMaximum(int salaireMaximum) {
        this.salaireMaximum = salaireMaximum;
    }

    public Boolean getPublie() {
        return publie;
    }

    public void setPublie(Boolean publie) {
        this.publie = publie;
    }
}
