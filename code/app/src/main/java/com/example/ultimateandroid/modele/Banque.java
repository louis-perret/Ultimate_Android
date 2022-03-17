package com.example.ultimateandroid.modele;

import com.example.ultimateandroid.modele.entite.CollectionEntite;
import com.example.ultimateandroid.modele.joueur.Joueur;
import com.example.ultimateandroid.modele.monde.Tuile;

import java.util.List;
import java.util.Map;

/**
 * classe contenant les collection de l'application
 */
public class Banque {

    private CollectionEntite encyclopedie; //collection des entités
    private List<Joueur> lesJoueurs; //faire une array
    public static Map<Integer, Tuile> DICOTUILES; //dictionnaire contenant toutes les types de tuiles de nos cartes

    /**
     *constructeur de la classe Banque
     * @param encyclopedie: collection des entités
     * @param lesJoueurs: liste des joueurs ayant déjà joué
     * @param dicoTuiles: dictionnaire contenant toutes les tuiles de nos cartes de jeu
     */
    public Banque(CollectionEntite encyclopedie, List<Joueur> lesJoueurs, Map<Integer, Tuile> dicoTuiles) {
        this.encyclopedie = encyclopedie;
        this.lesJoueurs = lesJoueurs;
        DICOTUILES = dicoTuiles;
    }

    public CollectionEntite getEncyclopedie() {
        return encyclopedie;
    }

    public List<Joueur> getLesJoueurs() {
        return lesJoueurs;
    }

}
