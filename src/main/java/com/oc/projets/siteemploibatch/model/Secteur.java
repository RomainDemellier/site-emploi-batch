package com.oc.projets.siteemploibatch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

public class Secteur {

    private Long id;

    private String nom;

    @JsonIgnoreProperties("secteur")
    private List<Poste> posteList = new ArrayList<Poste>();

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

    public List<Poste> getPosteList() {
        return posteList;
    }

    public void setPosteList(List<Poste> posteList) {
        this.posteList = posteList;
    }

    public void addPoste(Poste poste) {
        this.posteList.add(poste);
    }
}
