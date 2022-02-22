package com.example.ultimateandroid.modele.combat;

import com.example.ultimateandroid.modele.pokemon.CollectionPokemon;
import com.example.ultimateandroid.modele.pokemon.Mouvement;
import com.example.ultimateandroid.modele.pokemon.Pokemon;



public class ControleurCombatV1 extends ControleurCombat{

    /**
     * Constructeur
     * @param pokedex : La collection de pokemon utile au contrôleur niveau
     */
    public ControleurCombatV1(CollectionPokemon pokedex){
        iaPokemon = new IAPokemonFacile();
        controleurNiveau = new ControleurNiveau(pokedex);
        attaqueur = new AttaqueurPokemon();
    }

    @Override
    public int effectuerCombat(Pokemon allie, Pokemon ennemi, Mouvement mAllie) {
        Mouvement mEnnemi = iaPokemon.choisirAttaque(ennemi);
            if(allie.getVitesse() >= ennemi.getVitesse()){ //si le pokemon du joueur est plus rapide
                if(attaqueur.attaquer(allie,ennemi,mAllie)) {
                    controleurNiveau.gagnerExperience(allie, ennemi); //On lui fait gagner de l'expérience
                    return 1; //le pokemon ennemi est ko
                }
                else{
                    if(attaqueur.attaquer(ennemi,allie,mEnnemi)) {
                        return 2; //le pokemon du joueur est ko
                    }
                }
            }
            else{ //si le pokemon ennemi est plus rapide
                if(attaqueur.attaquer(ennemi,allie,mEnnemi)) {
                    return 2; //le pokemon du joueur est ko
                }
                else{
                    if(attaqueur.attaquer(allie,ennemi,mAllie)) {
                        controleurNiveau.gagnerExperience(allie, ennemi); //On lui fait gagner de l'expérience
                        return 1; //le pokemon ennemi est ko
                    }
                }
            }
            //On applique le comportement des états du pokemon si aucun n'est ko
            allie.appliquerEtat();
            ennemi.appliquerEtat();
            return 0; //aucun pokemon n'est ko
        }
}
