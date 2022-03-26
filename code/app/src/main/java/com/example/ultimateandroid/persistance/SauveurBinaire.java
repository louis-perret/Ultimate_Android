package com.example.ultimateandroid.persistance;

import com.example.ultimateandroid.modele.Banque;
import com.example.ultimateandroid.modele.Manager;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Classe qui gère la sauvegarde d'un objet dans un fichier binaire
 */
public class SauveurBinaire extends Sauveur{

    /**
     * Constructeur
     * @param cheminFichier : chemin du fichier source
     */
    public SauveurBinaire(String cheminFichier){
        this.cheminFichier=cheminFichier;
    }

    /**
     * Sauvegarde un objet Manager dans le fichier cheminFichier
     * @param banque : objet à sérialiser
     */
    @Override
    public boolean sauver(Banque banque) {
        if(banque==null){
            throw new IllegalArgumentException("Objet vide, impossible de l'enregistrer");
        }
        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(cheminFichier))) {
            writer.writeObject(banque); //on écrit l'objet
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
