package com.example.ultimateandroid.modele.boucle;

import com.example.ultimateandroid.modele.observateurs.Observateur;

import java.util.LinkedList;

/**
 * Boucle de jeu utile pour le déplacement du pokemon choisi par l'utilisateur
 */
public class BoucleJeu16 extends BoucleJeu{

    /**
     * Constructeur
     */
    public BoucleJeu16(){
        super.observateurs=new LinkedList<>();
    }

    /**
     * Méthode exécutée par le thread. S'endort 16 milli-secondes avant de notifier son observateur
     */
    @Override
    public void run() {
        boolean isRunning = true;
        try{
            while(isRunning) {
                Thread.sleep(16);
                notifier();
            }
        }
        catch (Exception e){
            System.out.println("Erreur dans la boucle : " + e.getMessage());
        }

    }

    /**
     * Notifie tous ses observateurs
     */
    @Override
    public void notifier() {
        //Instruction envoyée au thread principal
        //Platform.runLater n'est plus utilisée car bloquait nos déplacement de façon aléatoire
        for(Observateur o : super.observateurs){
            o.update();
        }
    }
}