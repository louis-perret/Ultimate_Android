package com.example.ultimateandroid.modele.combat;

import com.example.ultimateandroid.modele.pokemon.Mouvement;
import com.example.ultimateandroid.modele.pokemon.Pokemon;

import java.util.Random;

public class IAPokemonFacile implements IAPokemon{
    @Override
    public Mouvement choisirAttaque(Pokemon p) {
        Random random = new Random(); //sélection via l'aléatoire
        return p.getMouvements()[random.nextInt(p.getMouvements().length)];
    }
}
