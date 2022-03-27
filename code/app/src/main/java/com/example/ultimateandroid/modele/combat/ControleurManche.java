package com.example.ultimateandroid.modele.combat;


import com.example.ultimateandroid.modele.entite.Mouvement;
import com.example.ultimateandroid.modele.entite.Entite;

/**
 * Classe abstraite gérant le contrôle d'une manche
 */
public abstract class ControleurManche {

    protected IAEntite iaEntite; //ia de l'entité ennemi
    protected ControleurNiveau controleurNiveau; //pour contrôler le gain d'expérience et la montée d'un niveau
    protected Attaqueur attaqueur; //pour contrôler l'attaque

    /**
     * Effectue un tour de combat
     * @param allie : entité du joueur
     * @param ennemi : entité ennemie
     * @param mAllie : attaque utilisée par le joueur
     * @return un int signifiant s'il y a eu une entité ko
     */
    public abstract int effectuerCombat(Entite allie, Entite ennemi, Mouvement mAllie);
}
