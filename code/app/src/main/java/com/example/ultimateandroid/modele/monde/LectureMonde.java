package com.example.ultimateandroid.modele.monde;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Classe utilitaire permettant de lire un fichier .txt
 */
public class LectureMonde {

    /**
     * Charge un fichier dans une chaîne de caractères
     * @param fichier : chemin du fichier
     * @return un string
     */
    public static String chargerFichier(InputStream fichier) {
        StringBuilder builder = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(fichier));
            String ligne;
            while((ligne = br.readLine()) != null){
                builder.append(ligne + "\n");

            }
            br.close();
            fichier.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return builder.toString();
    }

    /**
     * Transforme une chaîne de caractères en int
     * @param nombre : nombre à transformer en int
     * @return un int
     */
    public static int parseInt(String nombre) {
        try{
            return Integer.parseInt(nombre);
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
