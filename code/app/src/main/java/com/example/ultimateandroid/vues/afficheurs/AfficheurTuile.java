package com.example.ultimateandroid.vues.afficheurs;

import android.widget.ImageView;

import com.example.ultimateandroid.modele.monde.Tuile;
import com.example.ultimateandroid.modele.pokemon.Position;

/**
 * Classe qui gère l'affichage d'une tuile
 */
public class AfficheurTuile  implements Afficheur {

    /**
     * Gère l'affichage d'un objet
     *
     * @param objet    : objet à afficher
     * @param position : à telle position
     * @return une ImageView
     */
    @Override
    public ImageView affiche(Object objet, Position position) {
        /*if (!(objet instanceof Tuile)) {
            throw new IllegalArgumentException("L'objet " + objet.toString() + " passé en paramètre n'est pas une tuile.");
        }
        Tuile tuile = (Tuile) objet;
        ImageView img = new ImageView();
        img.setImage(new Image(tuile.getImage()));
        img.setX(position.getPositionX());
        img.setY(position.getPositionY());
        return img;*/
        return null;
    }
}