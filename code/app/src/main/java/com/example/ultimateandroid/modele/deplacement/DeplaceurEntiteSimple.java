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
        super.setCollisionneur(new CollisionneurV1(hauteurSurface,largeurSurface));
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
        int pas = 2;
        System.out.println("diffX = " + diffX + " et diffY = " + diffY);
        if(diffX > -10 & diffX <10 && diffY > -10 && diffY < 10){
            System.out.println("Vous êtes arrivés");
        }
        else{
            if(diffX > diffY && diffX !=0){
                if(diffX > 0){
                    e.setPosition(new Position(e.getPosition().getPositionX() - pas, e.getPosition().getPositionY()));
                }
                else{
                    e.setPosition(new Position(e.getPosition().getPositionX() + pas, e.getPosition().getPositionY()));
                }
            }
            else{
                if(diffY > 0 && diffY !=0){
                    e.setPosition(new Position(e.getPosition().getPositionX(), e.getPosition().getPositionY() - pas));
                }
                else{
                    e.setPosition(new Position(e.getPosition().getPositionX(), e.getPosition().getPositionY() + pas));
                }
            }
        }
        /*if(e.getPosition().getPositionX() == xPortail){
            diff = e.getPosition().getPositionY() - xPortail;
            if(diff < 0){
                e.setPosition(new Position(e.getPosition().getPositionX(),e.getPosition().getPositionY()+pas));
            }
        }*/
        //e.getPosition().setPositionX(e.getPosition().getPositionX()+5);
        //e.getPosition().setPositionY(e.getPosition().getPositionY()+0);
        //On regarde l'évènement lié à la tuile où l'on s'est déplacé
        /*
        if(getChangeurCarte().isChangement(p.getPosition(), carte) == 1) { //on va sur la carte lobby
            manager.setCarteCourante("lobby");
            manager.setChangeur(1);
            manager.getEntiteCourant().setPosition(new Position(160,64)); //Le x et le y doivent être des multiples de 32

        }
        if(getChangeurCarte().isChangement(p.getPosition(), carte) == 2) { //on va sur la carte arène
            manager.setCarteCourante("arene");
            manager.setChangeur(2);
            manager.getEntiteCourant().setPosition(new Position(128,192)); //Le x et le y doivent être des multiples de 32

        }
        if(getChangeurCarte().isChangement(p.getPosition(), carte) == 3) { //on lance le combat
            manager.setChangeur(3);
        }*/
    }

    /* Déplacer dans les 4 directions */

    /**
     * Déplacer l'entité vers la gauche
     * @param p : Entite à déplacer
     * @param carte : Carte pour la collision
     */
    @Override
    public void deplacerAGauche(Entite p, Carte carte) {
        Position positionEntite = p.getPosition();
        Position position = new Position(positionEntite.getPositionX()-32,positionEntite.getPositionY()); //On set la nouvelle position
        if(!super.getCollisionneur().isCollision(position,carte) && false) { //Si y'a pas de collisions
            //On update les coordonnées de l'entité
            p.getPosition().setPositionX(position.getPositionX());
            p.getPosition().setPositionY(position.getPositionY());

        }
    }

    /**
     * Déplacer l'entité vers la droite
     * @param p : Entité à déplacer
     * @param carte : Carte pour la collision
     */
    @Override
    public void deplacerADroite(Entite p, Carte carte) {
        Position positionEntite = p.getPosition();
        Position position = new Position(positionEntite.getPositionX()+32,positionEntite.getPositionY());
        if(!super.getCollisionneur().isCollision(position,carte) && false) {
            p.getPosition().setPositionX(position.getPositionX());
            p.getPosition().setPositionY(position.getPositionY());
        }
    }

    /**
     * Déplacer l'entité vers le haut
     * @param p : Entité à déplacer
     * @param carte : Carte pour la collision
     */
    @Override
    public void deplacerEnHaut(Entite p, Carte carte) {
        Position positionEntite = p.getPosition();
        Position position = new Position(positionEntite.getPositionX(),positionEntite.getPositionY()-32);
        if(!super.getCollisionneur().isCollision(position,carte) && false) {
            p.getPosition().setPositionX(position.getPositionX());
            p.getPosition().setPositionY(position.getPositionY());
        }
    }

    /**
     * Déplacer l'entité vers le bas
     * @param p : Entité à déplacer
     * @param carte : Carte pour la collision
     */
    @Override
    public void deplacerEnBas(Entite p, Carte carte) {
        Position positionEntite = p.getPosition();
        Position position = new Position(positionEntite.getPositionX(),positionEntite.getPositionY()+32);
        if(!super.getCollisionneur().isCollision(position,carte) && false) {
            p.getPosition().setPositionX(position.getPositionX());
            p.getPosition().setPositionY(position.getPositionY());
        }
    }
}
