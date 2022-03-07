package com.example.ultimateandroid.modele;

import com.example.ultimateandroid.modele.entite.CollectionEntite;
import com.example.ultimateandroid.modele.joueur.Joueur;
import com.example.ultimateandroid.modele.monde.Tuile;

import java.util.List;
import java.util.Map;

public class Banque {

    private CollectionEntite encyclopedie; //collection des entités
    private List<Joueur> lesJoueurs; //faire une array
    public static Map<Integer, Tuile> DICOTUILES; //dictionnaire contenant toutes les types de tuiles de nos cartes

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
