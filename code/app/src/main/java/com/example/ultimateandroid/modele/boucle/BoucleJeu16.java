package com.example.ultimateandroid.modele.boucle;

import android.app.Activity;

import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ultimateandroid.modele.observateurs.Observateur;

import java.util.LinkedList;

/**
 * Boucle de jeu utile pour le déplacement de l'entité choisi par l'utilisateur
 */
public class BoucleJeu16 extends BoucleJeu{

    /**
     * Constructeur
     */
    public BoucleJeu16(){
        super.observateurs=new LinkedList<>();
    }

    /**
     * Méthode exécutée par le thread. S'endort 16 milli-secondes avant de notifier ses observateurs
     */
    @Override
    public void run() {
        boolean isRunning = true;
        try{
            while(isRunning) {
                Thread.sleep(100);
                notifier();
            }
        }
        catch (Exception e){
            isRunning=false;
        }

    }

    /**
     * Notifie tous ses observateurs
     */
    @Override
    public void notifier() {
        for(Observateur o : super.observateurs){
            o.update();
        }
    }
}