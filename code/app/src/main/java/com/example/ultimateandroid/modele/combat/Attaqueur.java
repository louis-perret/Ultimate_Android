package com.example.ultimateandroid.modele.combat;

import com.example.ultimateandroid.modele.entite.Mouvement;
import com.example.ultimateandroid.modele.entite.Entite;

/**
 * Interface fonctionnelle pour gérer l'attaque d'une entité
 */
public abstract class Attaqueur {

    protected CalculCoefficient calculCoefficient;

    /**
     * Gère l'attaque d'une entité vers une autre
     * @param attaquant : entité attaquante
     * @param attaque : entité attaquée
     * @param m : l'attaque utilisée
     * @return True si l'entité attaquante a gagné le combat
     */
    public abstract boolean attaquer(Entite attaquant, Entite attaque, Mouvement m);
}
