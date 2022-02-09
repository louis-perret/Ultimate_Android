package com.example.ultimateandroid.modele.combat;

import com.example.ultimateandroid.modele.pokemon.Mouvement;
import com.example.ultimateandroid.modele.pokemon.Pokemon;

public interface Attaqueur {
    public boolean attaquer(Pokemon attaquant, Pokemon attaque, Mouvement m);
}
