package com.example.ultimateandroid.modele.entite.etat;

import com.example.ultimateandroid.modele.entite.Entite;

import java.io.Serializable;

/**
 * Classe abstraite représentant l'état d'un allié
 */
public abstract class Etat implements Serializable {

    protected int nom; //nom de l'état
    protected int image; //image de l'état

    /**
     * Comportement associé à l'état
     * @param e : Pokemon sur lequel sera appliqué ce comportement
     */
    public abstract void comportement(Entite e);

    //Getter et setter
    public int getNom() {
        return nom;
    }

    public void setNom(int nom) {
        this.nom = nom;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
