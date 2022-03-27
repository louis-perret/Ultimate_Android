package com.example.ultimateandroid.modele.entite;

import com.example.ultimateandroid.modele.entite.etat.Etat;

import java.io.Serializable;
import java.util.Random;

/**
 * Classe qui définit les attaques de l'entité
 */
public class Mouvement implements Serializable{

    private int degats; //ses points de dégâts
    private int nom; //son nom
    private Type type; //son type
    private Etat etat; //l'état qu'il peut infliger à l'entité ennemi

    /**
     * Constructeur
     * @param degats : points de dégâts
     * @param nom : nom
     * @param type : type
     * @param etat : quel état peut affliger cette attaque
     */
    public Mouvement(int degats, int nom, Type type, Etat etat){
        this.degats=degats;
        this.nom=nom;
        this.type=type;
        this.etat=etat;
    }

    /**
     * Comportement de l'attaque sur une entité. Peut modifier l'état d'une entité
     * @param e : entité sur lequel sera appliaué ce comportement
     */
    public void comportement(Entite e){
        if(e.getEtat() == null) { //un entité ne peut pas avoir qu'un état à la fois jusqu'à sa guérison, donc si null -> l'entité ennemi peut subir un changement d'état
            if (etat != null) { //si null -> l'attaque n'affectera pas l'état de l'adversaire
                Random random = new Random();
                if (random.nextInt(4) == 0) {
                    e.setEtat(etat); //une chance sur 4 de modifier l'état de l'adversaire
                }
            }
        }
    }

    /* Getter et setter */
    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getNom() {
        return nom;
    }

    public void setNom(int nom) {
        this.nom = nom;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    @Override
    public String toString(){
        String res = "";
        res += nom + " de type " + type.getNom() + " fais comme dégâts : " + degats;
        return res;
    }
}
