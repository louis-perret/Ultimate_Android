package com.example.ultimateandroid.modele.combat;

import com.example.ultimateandroid.modele.entite.Mouvement;
import com.example.ultimateandroid.modele.entite.Entite;

import java.util.Random;

public class IAEntiteFacile implements IAEntite {
    @Override
    public Mouvement choisirAttaque(Entite p) {
        Random random = new Random(); //sélection via l'aléatoire
        return p.getMouvements()[random.nextInt(p.getMouvements().length)];
    }
}
