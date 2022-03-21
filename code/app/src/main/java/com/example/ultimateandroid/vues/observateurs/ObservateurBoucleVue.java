package com.example.ultimateandroid.vues.observateurs;

import com.example.ultimateandroid.modele.Manager;
import com.example.ultimateandroid.modele.observateurs.Observateur;
import com.example.ultimateandroid.vues.App;
import com.example.ultimateandroid.vues.FenetreJeu;

//TODO faire la doc de cette classe, à quoi elle sert précisément?


public class ObservateurBoucleVue implements Observateur {

    private FenetreJeu fenetre;
    private Manager manager;

    public ObservateurBoucleVue(FenetreJeu fenetre) {
        this.fenetre = fenetre;
        manager = ((App)fenetre.getApplication()).getManager();
    }

    @Override
    public void update() {
        fenetre.runOnUiThread(() -> { //Equivalent du platform runlater en javafx
            if (manager.isDebutCombat()) {
                manager.terminerBoucleJeu();
                fenetre.lancerCombat();
            }
            else {
                fenetre.updatePosition();
            }
        });
    }
}
