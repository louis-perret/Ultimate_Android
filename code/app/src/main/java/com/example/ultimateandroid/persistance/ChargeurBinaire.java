package com.example.ultimateandroid.persistance;

import com.example.ultimateandroid.modele.Banque;
import com.example.ultimateandroid.modele.Manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Classe qui gère le chargement à partir d'un fichier binaire
 */
public class ChargeurBinaire extends Chargeur{

    /**
     * Constructeur
     * @param cheminFichier : chemin du fichier source
     */
    public ChargeurBinaire(String cheminFichier){
        this.cheminFichier = cheminFichier;
    }


    /**
     * Charge un objet Manager à partir du fichier binaire cheminFichier
     * @return un Manager
     */
    @Override
    public Banque charger() {
        Banque type=null;
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(cheminFichier))) {
            type=(Banque) reader.readObject(); //on lit l'objet
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return type;
    }
}

