package com.example.ultimateandroid.persistance;

import com.example.ultimateandroid.modele.Manager;

/**
 * Classe qui gère la sauvegarde d'un objet
 */
public abstract class Sauveur {

    protected String cheminFichier; //fichier source

    /**
     * Sauvegarde un objet Manager dans le fichier cheminFichier
     * @param manager : objet à sérialiser
     */
    public abstract boolean sauver(Manager manager);
}
