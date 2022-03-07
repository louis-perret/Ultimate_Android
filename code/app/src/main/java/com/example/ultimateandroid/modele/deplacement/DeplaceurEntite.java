package com.example.ultimateandroid.modele.deplacement;

import com.example.ultimateandroid.modele.monde.Carte;
import com.example.ultimateandroid.modele.entite.Entite;

/**
 * Interface pour les déplacements de l'entité
 */
public abstract class DeplaceurEntite {

    private Collisionneur collisionneur; //pour savoir les collisions
    private ChangeurCarte changeurCarte; //pour savoir les évènements
    protected int pas;

    /**
     * Effectue le déplacement de l'entité
     * @param e : entité à déplacer
     * @param carte : Carte pour vérifier la collision
     */
    public void deplacer(Entite e, Carte carte){

    }

    /* Déplacer dans les 4 directions */

    /**
     * Déplacer l'entité vers la gauche
     * @param p : Entité à déplacer
     * @param carte : Carte pour la collision
     */
    public abstract void deplacerAGauche(Entite p, Carte carte);

    /**
     * Déplacer l'entité vers la droite
     * @param p : Entité à déplacer
     * @param carte : Carte pour la collision
     */
    public abstract void deplacerADroite(Entite p, Carte carte);

    /**
     * Déplacer l'entité vers le haut
     * @param p : Entité à déplacer
     * @param carte : Carte pour la collision
     */
    public abstract void deplacerEnHaut(Entite p, Carte carte);

    /**
     * Déplacer l'entité vers le bas
     * @param p : Entité à déplacer
     * @param carte : Carte pour la collision
     */
    public abstract void deplacerEnBas(Entite p, Carte carte);


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

