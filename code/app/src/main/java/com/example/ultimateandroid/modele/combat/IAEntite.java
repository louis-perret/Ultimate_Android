package com.example.ultimateandroid.modele.combat;

import com.example.ultimateandroid.modele.entite.Mouvement;
import com.example.ultimateandroid.modele.entite.Entite;

/**
 * Interface fonctionnelle pour gérer la sélection de l'attaque de l'allié
 */
public interface IAEntite {

    /**
     * Choisie l'attaque de l'entité ennemi
     * @param allie : entité à qui choisir l'attaque
     * @return un objet Mouvement -> l'attaque choisie
     */
     Mouvement choisirAttaque(Entite allie);
}
