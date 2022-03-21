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
     * Effectue le déplacement de l'entité, renvoie true si l'entité est au niveau du portail
     * @param e : entité à déplace
     * @param carte : Carte pour vérifier la collision
     */
    @Override
    public boolean deplacer(Entite e, Carte carte){
        int xPortail = carte.getxPortail();
        int yPortail = carte.getyPortail();
        double diffX = e.getPosition().getPositionX() - xPortail;
        double diffY = e.getPosition().getPositionY() - yPortail;
        if(diffX > -10 & diffX <10 && diffY > -10 && diffY < 10){
            return true;
        }
        else {
            if (diffX > diffY && diffX != 0) {
                if (diffX > 0) {
                    deplacerAGauche(e, carte);
                } else {
                    deplacerADroite(e, carte);
                }
            } else {
                if (diffY > 0 && diffY != 0) {
                    deplacerEnHaut(e, carte);
                } else {
                    deplacerEnBas(e, carte);
                }
            }
        }
        return false;
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
        e.getPosition().setPositionX(position.getPositionX());
        e.getPosition().setPositionY(position.getPositionY());
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
        e.getPosition().setPositionX(position.getPositionX());
        e.getPosition().setPositionY(position.getPositionY());
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
        e.getPosition().setPositionX(position.getPositionX());
        e.getPosition().setPositionY(position.getPositionY());
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
        e.getPosition().setPositionX(position.getPositionX());
        e.getPosition().setPositionY(position.getPositionY());
    }
}
