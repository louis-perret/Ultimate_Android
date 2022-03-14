package com.example.ultimateandroid.modele.deplacement;

import com.example.ultimateandroid.modele.monde.Carte;
import com.example.ultimateandroid.modele.entite.Entite;
import com.example.ultimateandroid.modele.entite.Position;

/**
 * Classe gérant un déplacement simple de l'entité
 */
public class DeplaceurEntiteSimple extends DeplaceurEntite {


    /**
     * Constructeur
     */
    public DeplaceurEntiteSimple(int hauteurSurface, int largeurSurface, int pas) {
        collisionneur = new CollisionneurV1(hauteurSurface,largeurSurface);
        this.pas = pas;
       // super.setChangeurCarte(new ChangeurCarteV1(hauteurSurface,largeurSurface,hauteurTuile));
    }

    /**
     * Effectue le déplacement de l'entité
     * @param e : entité à déplace
     * @param carte : Carte pour vérifier la collision
     */
    @Override
    public void deplacer(Entite e, Carte carte){
        int xPortail = carte.getxPortail();
        int yPortail = carte.getyPortail();
        double diffX = e.getPosition().getPositionX() - xPortail;
        double diffY = e.getPosition().getPositionY() - yPortail;
        System.out.println("diffX = " + diffX + " et diffY = " + diffY);
        if(diffX > -10 & diffX <10 && diffY > -10 && diffY < 10){
            System.out.println("Vous êtes arrivés");
        }
        else {
            if (diffX > diffY && diffX != 0) {
                if (diffX > 0) {
                    //e.setPosition(new Position(e.getPosition().getPositionX() - pas, e.getPosition().getPositionY()));
                    deplacerAGauche(e, carte);
                } else {
                    //e.setPosition(new Position(e.getPosition().getPositionX() + pas, e.getPosition().getPositionY()));
                    deplacerADroite(e, carte);
                }
            } else {
                if (diffY > 0 && diffY != 0) {
                    //e.setPosition(new Position(e.getPosition().getPositionX(), e.getPosition().getPositionY() - pas));
                    deplacerEnHaut(e, carte);
                } else {
                    //e.setPosition(new Position(e.getPosition().getPositionX(), e.getPosition().getPositionY() + pas));
                    deplacerEnBas(e, carte);
                }
            }
        }
    }

    /* Déplacer dans les 4 directions */

    /**
     * Déplacer l'entité vers la gauche
     * @param e : Entite à déplacer
     * @param carte : Carte pour la collision
     */
    @Override
    public void deplacerAGauche(Entite e, Carte carte) {
        Position positionEntite = e.getPosition();
        Position position = new Position(positionEntite.getPositionX()-pas,positionEntite.getPositionY()); //On set la nouvelle position
        if(!collisionneur.isCollision(position,carte)) { //Si y'a pas de collisions
            //On update les coordonnées de l'entité
            e.getPosition().setPositionX(position.getPositionX());
            e.getPosition().setPositionY(position.getPositionY());

        }
    }

    /**
     * Déplacer l'entité vers la droite
     * @param e : Entité à déplacer
     * @param carte : Carte pour la collision
     */
    @Override
    public void deplacerADroite(Entite e, Carte carte) {
        Position positionEntite = e.getPosition();
        Position position = new Position(positionEntite.getPositionX()+pas,positionEntite.getPositionY());
        if(!collisionneur.isCollision(position,carte)) {
            e.getPosition().setPositionX(position.getPositionX());
            e.getPosition().setPositionY(position.getPositionY());
        }
    }

    /**
     * Déplacer l'entité vers le haut
     * @param e : Entité à déplacer
     * @param carte : Carte pour la collision
     */
    @Override
    public void deplacerEnHaut(Entite e, Carte carte) {
        Position positionEntite = e.getPosition();
        Position position = new Position(positionEntite.getPositionX(),positionEntite.getPositionY()-pas);
        if(!collisionneur.isCollision(position,carte)) {
            e.getPosition().setPositionX(position.getPositionX());
            e.getPosition().setPositionY(position.getPositionY());
        }
    }

    /**
     * Déplacer l'entité vers le bas
     * @param e : Entité à déplacer
     * @param carte : Carte pour la collision
     */
    @Override
    public void deplacerEnBas(Entite e, Carte carte) {
        Position positionEntite = e.getPosition();
        Position position = new Position(positionEntite.getPositionX(),positionEntite.getPositionY()+pas);
        if(!collisionneur.isCollision(position,carte)) {
            e.getPosition().setPositionX(position.getPositionX());
            e.getPosition().setPositionY(position.getPositionY());
        }
    }
}
