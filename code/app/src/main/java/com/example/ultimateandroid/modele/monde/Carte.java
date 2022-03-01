package com.example.ultimateandroid.modele.monde;

import java.io.Serializable;
import java.util.Map;

/**
 * Classe définissant une carte
 */
public class Carte implements Serializable {

    private int[][] lesTuiles; //les élements qui composent la carte
    private int hauteur, largeur, spawnX, spawnY, xPortail, yPortail; //hauteur et largeur de la carte, point de spawn en x & y

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
    public Carte(int[][] lesTuiles, int hauteur, int largeur, int spawnX, int spawnY, int xPortail, int yPortail, Map<Integer, Tuile> dicoTuiles) {
        this.lesTuiles = lesTuiles;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.spawnX = spawnX;
        this.spawnY = spawnY;
        this.xPortail = xPortail;
        this.yPortail = yPortail;
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

    public int getLargeur() {
        return largeur;
    }

    public int getSpawnX() {
        return spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }

    public int getxPortail() {
        return xPortail;
    }

    public int getyPortail() {
        return yPortail;
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
