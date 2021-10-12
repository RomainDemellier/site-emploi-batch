package com.oc.projets.siteemploibatch.model;

public class Notification {

    private Long id;

    private Utilisateur utilisateur;

    private Annonce annonce;

    private int matchLevel;

    private Boolean sendMailOrNot;

    private Boolean readOrNot;

    public Notification() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public int getMatchLevel() {
        return matchLevel;
    }

    public void setMatchLevel(int matchLevel) {
        this.matchLevel = matchLevel;
    }

    public Boolean getSendMailOrNot() {
        return sendMailOrNot;
    }

    public void setSendMailOrNot(Boolean sendMailOrNot) {
        this.sendMailOrNot = sendMailOrNot;
    }

    public Boolean getReadOrNot() {
        return readOrNot;
    }

    public void setReadOrNot(Boolean readOrNot) {
        this.readOrNot = readOrNot;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", utilisateur=" + utilisateur +
                ", annonce=" + annonce +
                ", matchLevel=" + matchLevel +
                ", sendMailOrNot=" + sendMailOrNot +
                ", readOrNot=" + readOrNot +
                '}';
    }
}
