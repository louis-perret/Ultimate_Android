package com.example.ultimateandroid.vues.afficheurs;

import android.widget.ImageView;

import com.example.ultimateandroid.modele.entite.Position;

/**
 * Classe qui gère l'affichage d'une entité
 */
public class AfficheurEntite implements Afficheur {

    /**
     * Gère l'affichage d'un objet
     * @param objet : objet à afficher
     * @param position : à telle position
     * @return une ImageView
     */

    @Override
    public ImageView affiche(Object objet, Position position) {
        /*if (!(objet instanceof Entite)) {
            throw new IllegalArgumentException("L'objet " + objet.toString() + " passé en paramètre n'est pas une entité.");
        }
        Entite entite = (Entite) objet;
        ImageView img = new ImageView(entite.getImage());
        img.setX(position.getPositionX());
        img.setY(position.getPositionY());
        return img;*/
        return null;
    }
}