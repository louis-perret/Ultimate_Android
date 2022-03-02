package com.example.ultimateandroid.modele.combat;

import com.example.ultimateandroid.modele.entite.Mouvement;
import com.example.ultimateandroid.modele.entite.Entite;

/**
 * Interface fonctionnelle pour gérer l'attaque d'une entité
 */
public abstract class Attaqueur {

    protected CalculCoefficient calculCoefficient;

    /**
     * Gère l'attaque d'une entité vers un autre
     * @param attaquant : entité attaquant
     * @param attaque : entité attaqué
     * @param m : l'attaque utilisée
     * @return True si l'entité attaquant a gagné le combat
     */
    public abstract boolean attaquer(Entite attaquant, Entite attaque, Mouvement m);
}
