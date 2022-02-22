package com.example.ultimateandroid.modele.combat;

import com.example.ultimateandroid.modele.pokemon.CollectionPokemon;
import com.example.ultimateandroid.modele.pokemon.Pokemon;

public class ControleurNiveau {

    private CollectionPokemon collectionPokemon; //la collection de tous les pokemon

    /**
     * Constructeur
     * @param collectionPokemon : collection de tous les pokmon
     */
    public ControleurNiveau(CollectionPokemon collectionPokemon) {
        this.collectionPokemon = collectionPokemon;
    }

    /**
     * Augmente l'expérience du pokemon p en fonction du niveau du pokemon ennemi
     * @param p : pokemon qui gagne de l'expérience
     * @param ennemi : le pokemon ennemi
     */
    public void gagnerExperience(Pokemon p, Pokemon ennemi){
        int xpGagne=0;
        int niveauEnnemi=ennemi.getNiveau();

        if(niveauEnnemi==1){
            xpGagne=35;
        }
        else{
            if(niveauEnnemi==2){
                xpGagne=40;
            }
            else{
                xpGagne=50;
            }
        }

        p.setExperience(p.getExperience()+xpGagne);
        if(p.getExperience()>=100){ //S'il a atteint son expérience maximum
            if(p.getNiveau()<3) { //S'il est pas au niveau maximum
                xpGagne = p.getExperience() % 100;
                evoluer(p, xpGagne); //On le fait évoluer
            }
            else{
                p.setExperience(100); //Sinon on plafonne son expérience au maximum
            }
        }
    }

    /**
     * Fait évoluer un pokemon
     * @param p : Pokemon à faire évoluer
     * @param experienceRestante : son expérience restante à rajouter après
     */
    public void evoluer(Pokemon p,int experienceRestante){
        Pokemon pEvolue=collectionPokemon.getPokemon(p.getEvolution(),p.getNiveau()+1); //Récupère l'évolution du pokemon
        if(pEvolue == null){
            return; //le pokemon ne peut pas évoluer
        }
        //Modifie chacun de ses attributs par ceux de son évolution
        p.setNom(pEvolue.getNom());
        p.setNiveau(pEvolue.getNiveau());
        p.setPv(pEvolue.getPv());
        p.setEvolution(pEvolue.getEvolution());
        p.setAttaque(pEvolue.getAttaque());
        p.setDefense(pEvolue.getDefense());
        p.setVitesse(pEvolue.getVitesse());
        p.setImage(pEvolue.getImage());
        p.setMouvements(pEvolue.getMouvements());
        p.setImageCombat(pEvolue.getImageCombat());
        p.setExperience(experienceRestante);
    }
}
