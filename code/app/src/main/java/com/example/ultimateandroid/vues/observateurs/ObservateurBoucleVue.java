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
        fenetre.runOnUiThread(() -> { //Equivalent du platform runlater en javafx
            fenetre.updatePosition();
        });
    }
}
