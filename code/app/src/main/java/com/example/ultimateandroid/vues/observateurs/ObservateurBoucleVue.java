package com.example.ultimateandroid.vues.observateurs;

import com.example.ultimateandroid.modele.observateurs.Observateur;
import com.example.ultimateandroid.vues.FenetreJeu;

public class ObservateurBoucleVue implements Observateur {

    private FenetreJeu fenetre;

    public ObservateurBoucleVue(FenetreJeu fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    public void update() {
        fenetre.updatePosition();
        System.out.println("Observateur vu appelé");
    }
}
