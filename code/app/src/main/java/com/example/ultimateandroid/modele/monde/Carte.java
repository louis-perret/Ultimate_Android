package com.example.ultimateandroid.modele.monde;

import java.util.Map;

/**
 * Classe définissant une carte
 */
public class Carte {

    private int[][] lesTuiles; //les élements qui composent la carte
    private int hauteur, largeur, spawnX, spawnY; //hauteur et largeur de la carte, point de spawn en x & y

    private Map<Integer,Tuile> dicoTuiles; //Contient tous les types de tuiles de la carte


    /**
     * Construit une carte
     * @param lesTuiles
     * @param hauteur
     * @param largeur
     * @param spawnX
     * @param spawnY
     * @param dicoTuiles
     */
    public Carte(int[][] lesTuiles, int hauteur, int largeur, int spawnX, int spawnY, Map<Integer, Tuile> dicoTuiles) {
        this.lesTuiles = lesTuiles;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.spawnX = spawnX;
        this.spawnY = spawnY;
        this.dicoTuiles = dicoTuiles;
    }

    /**
     * Récupère une tuile suivant sa position x,y
     * @param x : position en x
     * @param y : position en y
     * @return une Tuile
     */
    public Tuile getTuile(int x, int y) {
        Tuile t=dicoTuiles.get(lesTuiles[y][x]);
        return t;
    }


    //Getter et setter
    public int[][] getLesTuiles() {
        return lesTuiles;
    }

    public void setLesTuiles(int[][] lesTuiles) {
        this.lesTuiles = lesTuiles;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getSpawnX() {
        return spawnX;
    }

    public void setSpawnX(int spawnX) {
        this.spawnX = spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }

    public void setSpawnY(int spawnY) {
        this.spawnY = spawnY;
    }

    /**
     * Renvoie l'objet sous forle de chaîne de caractères
     * @return un string
     */
    @Override
    public String toString() {
        String res="";
        for (int j = 0; hauteur > j; j++) {
            for (int i = 0; i < largeur; i++) {
                res+=lesTuiles[j][i];
            }
            res+="\n";
        }

        res+="\n";
        return res;
    }
}
