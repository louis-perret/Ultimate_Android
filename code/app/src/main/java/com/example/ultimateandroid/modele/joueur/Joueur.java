package com.example.ultimateandroid.modele.joueur;

import java.io.Serializable;


public class Joueur implements Serializable {
    private String pseudo;
    private int nbVictoire;

    /**
     * constructeur de la classe Joueur
     * @param pseudo : son pseudo
     * @param nbVictoire : son nombre de victoire
     */
    public Joueur (String pseudo, int nbVictoire){
        this.pseudo = pseudo;
        this.nbVictoire = nbVictoire;
    }

    public void incrementerScore(){
        nbVictoire++;
    }


    public int getNbVictoire() {
        return nbVictoire;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setNbVictoire(int nbVictoire) {
        this.nbVictoire = nbVictoire;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
