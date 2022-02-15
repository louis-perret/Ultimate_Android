package com.example.ultimateandroid.modele.monde;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe qui contient toutes nos cartes
 */
public class Monde {

    private Map<String,Carte> lesCartes=new HashMap<>(); //Les cartes ont un nom, ce sera plus simple pour en sélectionner une

    /**
     * Construit une instance de Monde
     * @param dicoTuiles : Dictionnaire contenant les types de tuiles
     */
    public Monde(Map<Integer,Tuile> dicoTuiles) {
        lesCartes.put("lobby",new Carte("@raw/cartes/lobby.txt",dicoTuiles));
        lesCartes.put("arene",new Carte("@raw/cartes/arene.txt",dicoTuiles));
    }

    //Getter et setter
    public Map<String,Carte> getLesCartes() {
        return lesCartes;
    }

    public void setLesCartes(Map<String,Carte> lesCartes) {
        this.lesCartes = lesCartes;
    }

    /**
     * Récupère une carte d'après son nom
     * @param nomCarte : nom de la carte
     * @return une Carte
     */
    public Carte getCarte(String nomCarte){
        return lesCartes.get(nomCarte);
    }
}