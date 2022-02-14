package com.example.ultimateandroid.modele.deplacement;

import static java.lang.Math.abs;

import com.example.ultimateandroid.modele.monde.Carte;
import com.example.ultimateandroid.modele.pokemon.Position;

/**
 * Classe qui gère les évènements
 */
public class ChangeurCarteV1 extends ChangeurCarte {


    /**
     * Constructeur
     */
    public ChangeurCarteV1(int hauteurSurface, int largeurSurface,int hauteurTuile) {
        setHauteurSurface(hauteurSurface/2);
        setLargeurSurface(largeurSurface);
        setHauteurTuile(hauteurTuile);
    }

    /**
     * Détecte des évènements dû au déplacement.
     * @param positionActuel : Position actuelle du joueur
     * @param carte : Carte sur laquelle on se déplace
     * @return un entier, il y a un entier par évènement
     */
    @Override
    public int isChangement(Position positionActuel, Carte carte) {
        int X = (int) positionActuel.getPositionX();
        int Y = (int) positionActuel.getPositionY();

        //Le y sur la fenêtre commence à 0 au milieu de la fenêtre, il fallait gérer cette partie
        int posTuilX = X / getHauteurTuile(), posTuilY = Y;
        if (posTuilY < 0) { //Si c'est négatif
            posTuilY = (abs(getHauteurSurface() - getHauteurTuile()) + posTuilY) / getHauteurTuile(); //On fait partir le y du début du tableau
        } else { //Si c'est positif
            posTuilY = (carte.getHauteur() / 2) + (posTuilY / getHauteurTuile()); //on fait partir le y du milieu du tableau
        }
        return carte.getTuile(posTuilX, posTuilY).getEvenement(); //Renvoie l'évènement associé à la tuile où l'on s'est déplacé
    }

}
