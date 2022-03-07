package com.example.ultimateandroid.modele.combat;

import com.example.ultimateandroid.modele.entite.Mouvement;
import com.example.ultimateandroid.modele.entite.Entite;

import java.util.Random;

/**
 * Classe qui gère la sélection de l'attaque de l'allié
 */
public class IAEntiteFacile implements IAEntite {
    @Override
    public Mouvement choisirAttaque(Entite allie) {
        Random random = new Random(); //sélection via l'aléatoire
        return allie.getMouvements()[random.nextInt(allie.getMouvements().length)];
    }
}
