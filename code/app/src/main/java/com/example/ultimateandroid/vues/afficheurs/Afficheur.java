package com.example.ultimateandroid.vues.afficheurs;

import android.widget.ImageView;

import com.example.ultimateandroid.modele.entite.Position;

/**
 * Interface fonctionnelle pour notre affichage
 */
public interface Afficheur {

    /**
     * Gère l'affichage d'un objet
     * @param objet : objet à afficher
     * @param position : à telle position
     * @return une ImageView
     */
    ImageView affiche(Object objet, Position position);
}
