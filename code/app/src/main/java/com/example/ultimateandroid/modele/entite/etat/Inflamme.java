package com.example.ultimateandroid.modele.entite.etat;

import static java.lang.Math.ceil;

import com.example.ultimateandroid.modele.entite.Entite;

/**
 * Classe abstraite représentant l'état inflammé d'une entité
 */
public class Inflamme extends Etat{

    private static float coefficient=1/8F; //Dégâts de l'inflammation

    /**
     * Constructeur
     * @param nom : son nom
     * @param image : chemin vers son image
     */
    public Inflamme(String nom, String image){
        this.nom=nom;
        this.image=image;
    }

    /**
     * Comportement associé à l'état, ici réduit les pv de 1/8 à chaque tour de combat
     * @param e : Pokemon sur lequel sera appliqué ce comportement
     */
    @Override
    public void comportement(Entite e) {
        e.setPv((int) (e.getPv()-ceil(e.getPv()*coefficient)));
    }
}
