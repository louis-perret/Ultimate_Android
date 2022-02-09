package com.example.ultimateandroid.modele.combat;

import com.example.ultimateandroid.modele.pokemon.Mouvement;
import com.example.ultimateandroid.modele.pokemon.Pokemon;

/**
 * Cette classe permet de gérer l'attaque d'un pokemon vers un autre
 */
public class AttaqueurPokemon implements Attaqueur{

    //private CalculCoefficient = new CalculCoef();

    @Override
    public boolean attaquer(Pokemon attaquant, Pokemon attaque, Mouvement m) {
        return false;
    }
}
