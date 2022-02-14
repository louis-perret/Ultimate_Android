package com.example.ultimateandroid.modele.deplacement;

import com.example.ultimateandroid.modele.Manager;
import com.example.ultimateandroid.modele.monde.Carte;
import com.example.ultimateandroid.modele.pokemon.Pokemon;
import com.example.ultimateandroid.modele.pokemon.Position;

/**
 * Classe gérant un déplacement simple du pokemon
 */
public class DeplaceurPokemonSimple extends DeplaceurPokemon {


    /**
     * Constructeur
     */
    public DeplaceurPokemonSimple(int hauteurSurface, int largeurSurface,int hauteurTuile) {
        super.setCollisionneur(new CollisionneurV1(hauteurSurface,largeurSurface,hauteurTuile));
        super.setChangeurCarte(new ChangeurCarteV1(hauteurSurface,largeurSurface,hauteurTuile));
    }

    /**
     * Effectue le déplacement d'un pokemon
     * @param p : pokemon à déplacer
     * @param keyChar : touche appuyée
     * @param carte : Carte pour vérifier la collision
     */
    @Override
    public void deplacer(Pokemon p, String keyChar, Carte carte){
        switch (keyChar){
            case "Z" :
                deplacerEnHaut(p,carte);
                break;
            case "D" :
                deplacerADroite(p,carte);
                break;
            case "S" :
                deplacerEnBas(p,carte);
                break;
            case "Q" :
                deplacerAGauche(p,carte);
                break;
        }
        //On regarde l'évènement lié à la tuile où l'on s'est déplacé
        /*
        if(getChangeurCarte().isChangement(p.getPosition(), carte) == 1) { //on va sur la carte lobby
            manager.setCarteCourante("lobby");
            manager.setChangeur(1);
            manager.getPokemonCourant().setPosition(new Position(160,64)); //Le x et le y doivent être des multiples de 32

        }
        if(getChangeurCarte().isChangement(p.getPosition(), carte) == 2) { //on va sur la carte arène
            manager.setCarteCourante("arene");
            manager.setChangeur(2);
            manager.getPokemonCourant().setPosition(new Position(128,192)); //Le x et le y doivent être des multiples de 32

        }
        if(getChangeurCarte().isChangement(p.getPosition(), carte) == 3) { //on lance le combat
            manager.setChangeur(3);
        }*/
    }

    /* Déplacer dans les 4 directions */

    /**
     * Déplacer le pokemon vers la gauche
     * @param p : Pokemon à déplacer
     * @param carte : Carte pour la collision
     */
    @Override
    public void deplacerAGauche(Pokemon p,Carte carte) {
        Position positionPokemon = p.getPosition();
        Position position = new Position(positionPokemon.getPositionX()-32,positionPokemon.getPositionY()); //On set la nouvelle position
        if(!super.getCollisionneur().isCollision(position,carte) && false) { //Si y'a pas de collisions
            //On update les coordonnées du pokemon
            p.getPosition().setPositionX(position.getPositionX());
            p.getPosition().setPositionY(position.getPositionY());

        }
    }

    /**
     * Déplacer le pokemon vers la droite
     * @param p : Pokemon à déplacer
     * @param carte : Carte pour la collision
     */
    @Override
    public void deplacerADroite(Pokemon p,Carte carte) {
        Position positionPokemon = p.getPosition();
        Position position = new Position(positionPokemon.getPositionX()+32,positionPokemon.getPositionY());
        if(!super.getCollisionneur().isCollision(position,carte) && false) {
            p.getPosition().setPositionX(position.getPositionX());
            p.getPosition().setPositionY(position.getPositionY());
        }
    }

    /**
     * Déplacer le pokemon vers le haut
     * @param p : Pokemon à déplacer
     * @param carte : Carte pour la collision
     */
    @Override
    public void deplacerEnHaut(Pokemon p,Carte carte) {
        Position positionPokemon = p.getPosition();
        Position position = new Position(positionPokemon.getPositionX(),positionPokemon.getPositionY()-32);
        if(!super.getCollisionneur().isCollision(position,carte) && false) {
            p.getPosition().setPositionX(position.getPositionX());
            p.getPosition().setPositionY(position.getPositionY());
        }
    }

    /**
     * Déplacer le pokemon vers le bas
     * @param p : Pokemon à déplacer
     * @param carte : Carte pour la collision
     */
    @Override
    public void deplacerEnBas(Pokemon p,Carte carte) {
        Position positionPokemon = p.getPosition();
        Position position = new Position(positionPokemon.getPositionX(),positionPokemon.getPositionY()+32);
        if(!super.getCollisionneur().isCollision(position,carte) && false) {
            p.getPosition().setPositionX(position.getPositionX());
            p.getPosition().setPositionY(position.getPositionY());
        }
    }
}
