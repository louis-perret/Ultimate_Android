package com.example.ultimateandroid.modele.joueur;

import java.io.Serializable;
import java.util.Objects;


/**
 * Classe qui représente un joueur
 */
public class Joueur implements Serializable {

    private String pseudo; //son pseudo
    private int nbVictoire; //son nombre de victoires

    /**
     * constructeur de la classe Joueur
     * @param pseudo : son pseudo
     * @param nbVictoire : son nombre de victoire
     */
    public Joueur (String pseudo, int nbVictoire){
        this.pseudo = pseudo;
        this.nbVictoire = nbVictoire;
    }


    /**
     * Méthode permettant d'incrémenter le nombre de victoire d'un joueur si celui-ci gagne une partie
     */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joueur joueur = (Joueur) o;
        return pseudo.equals(joueur.pseudo);
    }

}
