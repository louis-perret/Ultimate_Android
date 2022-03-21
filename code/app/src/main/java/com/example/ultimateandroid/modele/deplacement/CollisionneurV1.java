package com.example.ultimateandroid.modele.deplacement;

import static java.lang.Math.abs;

import com.example.ultimateandroid.modele.monde.Carte;
import com.example.ultimateandroid.modele.entite.Position;
import com.example.ultimateandroid.modele.monde.Tuile;

/**
 * Classe gérant les collisions
 */
public class CollisionneurV1 extends Collisionneur{

    /**
     * Constructeur
     */
    public CollisionneurV1(int hauteurSurface, int largeurSurface){
        setHauteurSurface(hauteurSurface);
        setLargeurSurface(largeurSurface);
    }

    /**
     * Effectue les collisions pour le déplacement
     * @param nextPosition : Position enviée
     * @param carte : Carte sur laquelle on se déplace
     * @return True si y'a collision
     */
    public boolean isCollision(Position nextPosition, Carte carte){
        int nextX = (int)nextPosition.getPositionX();
        int nextY = (int)nextPosition.getPositionY();

        if(nextX <0 || nextY<0 || nextX > carte.getLargeur() || nextY > carte.getHauteur()){
            return true;
        }

        Tuile t = carte.getTuile(nextX/Tuile.tuileLargeur, nextY/Tuile.tuileHauteur);
        if(carte.getTuile(nextX/Tuile.tuileLargeur, nextY/Tuile.tuileHauteur).getTraversable()){
            return false;
        }
        return false;
    }
}