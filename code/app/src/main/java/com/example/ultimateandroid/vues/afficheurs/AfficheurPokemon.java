package com.example.ultimateandroid.vues.afficheurs;

import android.widget.ImageView;

import com.example.ultimateandroid.modele.pokemon.Pokemon;
import com.example.ultimateandroid.modele.pokemon.Position;

/**
 * Classe qui gère l'affichage d'un pokemon
 */
public class AfficheurPokemon implements Afficheur {

    /**
     * Gère l'affichage d'un objet
     * @param objet : objet à afficher
     * @param position : à telle position
     * @return une ImageView
     */

    @Override
    public ImageView affiche(Object objet, Position position) {
        /*if (!(objet instanceof Pokemon)) {
            throw new IllegalArgumentException("L'objet " + objet.toString() + " passé en paramètre n'est pas un pokemon.");
        }
        Pokemon pokemon = (Pokemon) objet;
        ImageView img = new ImageView(pokemon.getImage());
        img.setX(position.getPositionX());
        img.setY(position.getPositionY());
        return img;*/
        return null;
    }
}