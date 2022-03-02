package com.example.ultimateandroid.modele.combat;

import com.example.ultimateandroid.modele.entite.Type;

/**
 * Interface fonctionnelle gérant le calcul du coefficient entre les types
 */
public interface CalculCoefficient {

    /**
     * Retourne un coefficiant de dégâts en fonction du type de l'attaque lancée par rapport au type de l'entité attaqué
     * @param typeAttaquant : type de l'attaque utilisée
     * @param typeAttaque : type de l'entité attaqué
     * @return
     */
    public float getCoefficient(Type typeAttaquant, Type typeAttaque);
}
