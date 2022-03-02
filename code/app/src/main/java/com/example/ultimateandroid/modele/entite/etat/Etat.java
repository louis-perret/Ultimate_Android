package com.example.ultimateandroid.modele.entite.etat;

import com.example.ultimateandroid.modele.entite.Entite;

import java.io.Serializable;

public abstract class Etat implements Serializable {

    protected String nom; //nom de l'état
    protected String image; //image de l'état

    /**
     * Comportement associé à l'état
     * @param p : Pokemon sur lequel sera appliqué ce comportement
     */
    public abstract void comportement(Entite p);

    //Getter et setter
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
