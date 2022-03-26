package com.example.ultimateandroid.persistance;

import androidx.annotation.NonNull;

import com.example.ultimateandroid.modele.Banque;
import com.example.ultimateandroid.modele.Manager;

import java.io.FileInputStream;
import java.io.Serializable;

/**
 * Classe qui gère le chargement d'un objet
 */
public abstract class Chargeur {

    protected String cheminFichier; //fichier source

    /**
     * Charge un objet Manager à partir du fichier cheminFichier
     *
     * @return un Manager
     */
    public abstract Banque charger();
}
