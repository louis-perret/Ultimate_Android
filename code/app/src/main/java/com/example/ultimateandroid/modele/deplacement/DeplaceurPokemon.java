package com.example.ultimateandroid.modele.deplacement;

import com.example.ultimateandroid.modele.monde.Carte;
import com.example.ultimateandroid.modele.pokemon.Pokemon;

import java.io.Serializable;

/**
 * Interface pour les déplacements d'un pokemon
 */
public abstract class DeplaceurPokemon {

    private Collisionneur collisionneur; //pour savoir les collisions
    private ChangeurCarte changeurCarte; //pour savoir les évènements


    /**
     * Effectue le déplacement d'un pokemon
     * @param p : pokemon à déplacer
     * @param carte : Carte pour vérifier la collision
     */
    public void deplacer(Pokemon p, Carte carte){

    }

    /* Déplacer dans les 4 directions */

    /**
     * Déplacer le pokemon vers la gauche
     * @param p : Pokemon à déplacer
     * @param carte : Carte pour la collision
     */
    public abstract void deplacerAGauche(Pokemon p,Carte carte);

    /**
     * Déplacer le pokemon vers la droite
     * @param p : Pokemon à déplacer
     * @param carte : Carte pour la collision
     */
    public abstract void deplacerADroite(Pokemon p,Carte carte);

    /**
     * Déplacer le pokemon vers le haut
     * @param p : Pokemon à déplacer
     * @param carte : Carte pour la collision
     */
    public abstract void deplacerEnHaut(Pokemon p,Carte carte);

    /**
     * Déplacer le pokemon vers le bas
     * @param p : Pokemon à déplacer
     * @param carte : Carte pour la collision
     */
    public abstract void deplacerEnBas(Pokemon p,Carte carte);


    //Getter et Setter
    public ChangeurCarte getChangeurCarte() {return changeurCarte;}

    public void setChangeurCarte(ChangeurCarte changeurCarte) {this.changeurCarte = changeurCarte;}

    public Collisionneur getCollisionneur() {
        return collisionneur;
    }

    public void setCollisionneur(Collisionneur collisionneur) {
        this.collisionneur = collisionneur;
    }
}

