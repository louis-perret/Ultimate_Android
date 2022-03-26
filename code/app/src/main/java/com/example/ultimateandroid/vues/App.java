package com.example.ultimateandroid.vues;

import android.app.Application;

import com.example.ultimateandroid.modele.Manager;
import com.example.ultimateandroid.persistance.Stub;

/**
 * Classe générale à notre jeu
 */
public class App extends Application {

    private Manager manager; //manager globale à notre jeu

    /**
     * Appelé au lancement du jeu, initialise le manager
     */
    @Override
    public void onCreate() {
        super.onCreate();
        manager = new Manager(new Stub().charger());
    }

    /**
     * Renvoie le manager
     * @return
     */
    public Manager getManager() {
        return manager;
    }
}
