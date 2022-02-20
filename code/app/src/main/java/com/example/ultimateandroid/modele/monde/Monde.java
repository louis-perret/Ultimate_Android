package com.example.ultimateandroid.modele.monde;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe qui contient toutes nos cartes
 */
public class Monde {

    private Map<String,Carte> lesCartes=new HashMap<>(); //Les cartes ont un nom, ce sera plus simple pour en sélectionner une

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

    /**
     * Charge la carte d'après son fichier assigné
     * @param nomCarte : chemin du fichier à charger
     * @param fichier
     * @param dicoTuiles
     */
    public void ajouterCarte(String nomCarte, InputStream fichier, Map<Integer, Tuile> dicoTuiles) {
        String contenuFichier = LectureMonde.chargerFichier(fichier);
        String[] partie = contenuFichier.split("\\s+");
        int largeur = LectureMonde.parseInt(partie[0]);
        int hauteur = LectureMonde.parseInt(partie[1]);
        int spawnX = LectureMonde.parseInt(partie[2]);
        int spawnY = LectureMonde.parseInt(partie[3]);

        int[][] lesTuiles = new int[hauteur][largeur];
        for(int j=0;hauteur>j;j++){
            for(int i=0;i<largeur;i++) {
                lesTuiles[j][i] = LectureMonde.parseInt(partie[(i + j  * largeur) + 4]);
            }
        }

        lesCartes.put(nomCarte,new Carte(lesTuiles,hauteur, largeur, spawnX, spawnY, dicoTuiles));
    }

}