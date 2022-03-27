package com.example.ultimateandroid.vues.observateurs;

import com.example.ultimateandroid.modele.Manager;
import com.example.ultimateandroid.modele.observateurs.Observateur;
import com.example.ultimateandroid.vues.App;
import com.example.ultimateandroid.vues.fenetres.FenetreJeu;

/**
 * Observateur de notre boucle de jeu côté vue. Permet la mise à jour de cette dernière
 */
public class ObservateurBoucleVue implements Observateur {

    private FenetreJeu fenetre; //activité à mettre à jour
    private Manager manager;

    public ObservateurBoucleVue(FenetreJeu fenetre) {
        this.fenetre = fenetre;
        manager = ((App)fenetre.getApplication()).getManager();
    }

    /**
     * Effectuera un traitement lorsqu'il sera notifié par le sujet qu'il observe
     */
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
