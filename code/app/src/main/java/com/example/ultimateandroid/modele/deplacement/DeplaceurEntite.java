package com.example.ultimateandroid.modele.deplacement;

import com.example.ultimateandroid.modele.monde.Carte;
import com.example.ultimateandroid.modele.entite.Entite;

/**
 * Interface pour les déplacements de l'entité
 */
public abstract class DeplaceurEntite {

    protected int pas; //pas du déplacement

    /**
     * Effectue le déplacement de l'entité, renvoie true si l'entité est au niveau du portail
     * @param e : entité à déplacer
     * @param carte : Carte pour vérifier la collision
     * @return boolean
     */
    public abstract boolean deplacer(Entite e, Carte carte);

    /* Déplacer dans les 4 directions */

    /**
     * Déplacer l'entité vers la gauche
     * @param e : Entité à déplacer
     * @param carte : Carte pour la collision
     */
    public abstract void deplacerAGauche(Entite e, Carte carte);

    /**
     * Déplacer l'entité vers la droite
     * @param e : Entité à déplacer
     * @param carte : Carte pour la collision
     */
    public abstract void deplacerADroite(Entite e, Carte carte);

    /**
     * Déplacer l'entité vers le haut
     * @param e : Entité à déplacer
     * @param carte : Carte pour la collision
     */
    public abstract void deplacerEnHaut(Entite e, Carte carte);

    /**
     * Déplacer l'entité vers le bas
     * @param e : Entité à déplacer
     * @param carte : Carte pour la collision
     */
    public abstract void deplacerEnBas(Entite e, Carte carte);

}

