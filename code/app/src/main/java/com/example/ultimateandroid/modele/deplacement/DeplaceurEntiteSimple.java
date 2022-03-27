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
    public DeplaceurEntiteSimple(int pas) {
        this.pas = pas;
    }

    /**
     * Effectue le déplacement de l'entité, renvoie true si l'entité est au niveau du portail
     * @param e : entité à déplace
     * @param carte : Carte pour vérifier la collision
     * @return boolean
     */
    @Override
    public boolean deplacer(Entite e, Carte carte){
        int xPortail = carte.getxPortail();
        int yPortail = carte.getyPortail();

        //on vérifie la différence de l'entité par rapport aux portails
        double diffX = e.getPosition().getPositionX() - xPortail;
        double diffY = e.getPosition().getPositionY() - yPortail;
        if(diffX > -10 & diffX <10 && diffY > -10 && diffY < 10){  //on considère qu'à 10px près, l'entité rentre en collision avec le portail
            return true;
        }
        else {
            if (diffX > diffY && diffX != 0) { //si diffX est plus grand que diffY
                if (diffX > 0) { //si diffX est positif
                    deplacerAGauche(e, carte); //alors on le diminue
                } else {
                    deplacerADroite(e, carte); //sinon on l'augmente
                }
            } else { //si diffY est plus grand que diffX
                if (diffY > 0 && diffY != 0) { //si diffY est positif
                    deplacerEnHaut(e, carte); //on le diminue
                } else {
                    deplacerEnBas(e, carte); //sinon on l'augmente
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
