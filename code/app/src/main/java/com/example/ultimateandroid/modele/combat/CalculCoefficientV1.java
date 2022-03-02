package com.example.ultimateandroid.modele.combat;

import com.example.ultimateandroid.modele.entite.Type;

public class CalculCoefficientV1 implements CalculCoefficient{
    /**
     * Retourne un coefficiant de dégâts en fonction du type de l'attaque lancée par rapport au type de l'entité attaqué
     * @param typeAttaquant : type de l'attaque utilisée
     * @param typeAttaque : type de l'entité attaqué
     * @return un int
     */
    @Override
    public float getCoefficient(Type typeAttaquant, Type typeAttaque) {
        if(typeAttaquant.getForces().contains(typeAttaque.getNom())){ //Si l'entité à un avantage de type
            return 1.50F; //on augmente les dégats de 50%
        }
        if(typeAttaquant.getFaiblesses().contains(typeAttaque.getNom())){  //Si le entité à un désavantage de type
            return 0.50F; //on diminue les dégâts de 50%
        }
        return 1F; //S'il est neutre, on ne fait rien
    }
}
