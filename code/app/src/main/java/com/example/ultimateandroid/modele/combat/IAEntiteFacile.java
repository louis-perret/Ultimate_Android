package com.example.ultimateandroid.modele.combat;

import com.example.ultimateandroid.modele.entite.Mouvement;
import com.example.ultimateandroid.modele.entite.Entite;

import java.util.Random;

/**
 * Classe qui gère la sélection de l'attaque de l'allié
 */
public class IAEntiteFacile implements IAEntite {

    /**
     * Choisie l'attaque de l'entité ennemi
     * @param allie : entité à qui choisir l'attaque
     * @return un objet Mouvement -> l'attaque choisie
     */
    @Override
    public Mouvement choisirAttaque(Entite allie) {
        Random random = new Random(); //sélection via l'aléatoire
        return allie.getMouvements()[random.nextInt(allie.getMouvements().length)];
    }
}
