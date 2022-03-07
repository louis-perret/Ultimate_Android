package com.example.ultimateandroid.modele.entite.etat;

import com.example.ultimateandroid.modele.entite.Entite;

/**
 * Classe abstraite représentant l'état paralysé d'un entité
 */
public class Paralyse extends Etat{

    private boolean vitesseReduit=false; //permet de savoir si l'effet a déjà été appliqué

    /**
     * Constructeur
     * @param nom : son nom
     * @param image : chemin vers son image
     */
    public Paralyse(String nom,String image){
        this.nom=nom;
        this.image=image;
    }

    /**
     * Comportement associé à l'état, ici réduit une seule fois la vitesse de moitié
     * @param e : Pokemon sur lequel sera appliqué ce comportement
     */
    @Override
    public void comportement(Entite e) {
        if(!vitesseReduit){ //On réduit la vitesse de moitié qu'une seule fois
            vitesseReduit=true; //Pour dire qu'on a appliqué le comportement
            e.setVitesse(e.getVitesse()/2);
        }
    }
}
