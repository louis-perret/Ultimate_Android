package com.example.ultimateandroid.modele.combat;


import com.example.ultimateandroid.modele.pokemon.Mouvement;
import com.example.ultimateandroid.modele.pokemon.Pokemon;

/**
 * classe abtraite gérant le contrôle d'un combat
 */
public abstract class ControleurCombat {

    protected IAPokemon iaPokemon; //ia du pokemon ennemi
    protected ControleurNiveau controleurNiveau; //pour contrôler le gain d'expérience et la montée d'un niveau
    protected Attaqueur attaqueur; //pour contrôler l'attaque

    /**
     * Effectue un tour de combat
     * @param allie : pokemon du joueur
     * @param ennemi : pokemon ennemi
     * @param mAllie : attaque utilisée par le joueur
     * @return un int signifiant s'il y a eu un pokemon ko
     */
    public abstract int effectuerCombat(Pokemon allie, Pokemon ennemi, Mouvement mAllie);
}
