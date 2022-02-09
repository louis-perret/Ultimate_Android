package com.example.ultimateandroid.modele.combat;

import com.example.ultimateandroid.modele.pokemon.Type;

public interface CalculCoefficient {
    public int getCoefficient(Type typeAttaquant, Type typeAttaque);
}
