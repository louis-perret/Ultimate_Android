package com.example.ultimateandroid.modele;

import com.example.ultimateandroid.modele.entite.CollectionEntite;
import com.example.ultimateandroid.modele.joueur.Joueur;
import com.example.ultimateandroid.modele.monde.Tuile;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Classe contenant les collections de l'application
 */
public class Banque implements Serializable {

    private CollectionEntite encyclopedie; //collection des entités
    private List<Joueur> lesJoueurs; //liste des joueurs
    public Map<Integer, Tuile> dicoTuiles; //dictionnaire contenant tous les types de tuiles de nos cartes

    /**
     * Constructeur de la classe Banque
     * @param encyclopedie: collection des entités
     * @param lesJoueurs: liste des joueurs ayant déjà joués
     * @param dicoTuiles: dictionnaire contenant tous les tuiles de nos cartes de jeu
     */
    public Banque(CollectionEntite encyclopedie, List<Joueur> lesJoueurs, Map<Integer, Tuile> dicoTuiles) {
        this.encyclopedie = encyclopedie;
        this.lesJoueurs = lesJoueurs;
        this.dicoTuiles = dicoTuiles;
    }

    /**
     * Permet d'ajouter le joueur avec le nouveau pseudo dans la liste lesJoueurs
     * @param pseudo: pseudo du joueur rentré par l'utilisateur
     * @return le joueur
     */
    public Joueur addJoueur(String pseudo){
        Joueur j =  new Joueur(pseudo, 0);
        int index = lesJoueurs.indexOf(j);
        if ( index==-1) {
            lesJoueurs.add(j);
            return j;
        }
        return lesJoueurs.get(index);
    }

    public CollectionEntite getEncyclopedie() {
        return encyclopedie;
    }

    public List<Joueur> getLesJoueurs() {
        return lesJoueurs;
    }

    public Map<Integer, Tuile> getDicoTuiles() {
        return dicoTuiles;
    }

}
