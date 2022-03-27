package com.example.ultimateandroid.vues;

import android.app.Application;

import com.example.ultimateandroid.modele.Manager;
import com.example.ultimateandroid.persistance.Chargeur;
import com.example.ultimateandroid.persistance.ChargeurBinaire;
import com.example.ultimateandroid.persistance.Sauveur;
import com.example.ultimateandroid.persistance.SauveurBinaire;
import com.example.ultimateandroid.persistance.Stub;

import java.io.File;
import java.io.IOException;

/**
 * Classe générale à notre jeu
 */
public class App extends Application {

    private Manager manager; //manager globale à notre jeu
    private String nomFichier = "donneesApp";
    private Sauveur sauveur;
    private Chargeur chargeur;

    /**
     * Appelé au lancement du jeu, initialise le manager, le chargeur et le sauveur
     */
    @Override
    public void onCreate() {
        super.onCreate();
        File fileName = new File(getFilesDir(), nomFichier);

        if(fileName.canRead()){ // si le fichier existe alors on le charge
            chargeur = new ChargeurBinaire(fileName.getPath());
            sauveur = new SauveurBinaire(fileName.getPath());

        }
        else{ //sinon on charge les données du Stub
            chargeur = new Stub();
            try {
                fileName.createNewFile(); //puis on crée le fichier pour la sauvegarde
                sauveur = new SauveurBinaire(fileName.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        manager = new Manager(chargeur.charger());
    }


    /**
     * Renvoie le manager
     * @return
     */
    public Manager getManager() {
        return manager;
    }

    /**
     * Renvoie le sauveur
     * @return
     */
    public Sauveur getSauveur() {
        return sauveur;
    }

    /**
     * Modifie le sauveur
     * @param sauveur : nouveau sauveur
     */
    public void setSauveur(Sauveur sauveur) {
        this.sauveur = sauveur;
    }

    /**
     * Renvoie le chargeur
     * @return
     */
    public Chargeur getChargeur() {
        return chargeur;
    }

    /**
     * Modifie le chargeur
     * @param chargeur
     */
    public void setChargeur(Chargeur chargeur) {
        this.chargeur = chargeur;
    }
}


