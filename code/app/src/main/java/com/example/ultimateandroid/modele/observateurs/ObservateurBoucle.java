package com.example.ultimateandroid.modele.observateurs;

import com.example.ultimateandroid.modele.Manager;

/**
 * Observateur de notre boucle de jeu (BoucleJeu16)
 */
public class ObservateurBoucle implements Observateur {

    private Manager manager; //notre manager

    /**
     * Constructeur
     * @param m : manager
     */
    public ObservateurBoucle(Manager m){
        this.manager=m;
    }

    /**
     * Incrémente le compteur du manager lorsqu'il sera notifié par la boucle de jeu qu'il observe
     */
    @Override
    public void update() {
        manager.deplacerEntite();
        System.out.println("Observateur modèle appelé");
    }
}
