package com.example.ultimateandroid.vues;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.WindowMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.ultimateandroid.R;
import com.example.ultimateandroid.modele.Manager;
import com.example.ultimateandroid.modele.monde.Carte;
import com.example.ultimateandroid.modele.monde.Tuile;
import com.example.ultimateandroid.modele.observateurs.Observateur;
import com.example.ultimateandroid.modele.observateurs.ObservateurBoucle;
import com.example.ultimateandroid.vues.observateurs.ObservateurBoucleVue;

import java.util.ArrayList;
import java.util.List;

public class FenetreJeu extends AppCompatActivity {

    private Manager manager;
    private Canvas canvas = new Canvas();
    private ConstraintLayout layout;
    private ImageView pokemonAllie;

    private void afficherCarte() {
        Carte carte = manager.getCarteCourante();
        ImageView image;
        for (int j = 0; j < carte.getHauteur(); j++) {
            for (int i = 0; i < carte.getLargeur(); i++) {
                Bitmap b = BitmapFactory.decodeResource(getResources(), carte.getTuile(i, j).getImage()); //on récupère notre image
                image = new ImageView(this);
                image.setImageBitmap(b); //on crée notre image view
                image.setX(i * Tuile.tuileLargeur * 3.5F);
                image.setY(j * Tuile.tuileHauteur * 3.5F);
                layout.addView(image); //puis on l'ajoute dans notre layout
            }
        }
    }

    public void updatePosition(){
        pokemonAllie.setX((float) manager.getPokemonCourant().getPosition().getPositionX());
        pokemonAllie.setY((float) manager.getPokemonCourant().getPosition().getPositionY());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_jeu); //Je rattache le code behind à la fenêtre
        layout = findViewById(R.id.layout2);
        manager=(Manager)getIntent().getSerializableExtra("manager");
        manager.setPokemonCourant(manager.getPokedex().getPokemon("Bulbizarre",1));
        afficherCarte();
        pokemonAllie = new ImageView(this); //On ajoute notre image view pour qu'elle soit au dessus et non en dessous de la map
        pokemonAllie.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.bulb_1));
        pokemonAllie.setX(manager.getCarteCourante().getSpawnX());
        pokemonAllie.setY(manager.getCarteCourante().getSpawnY());
        layout.addView(pokemonAllie);

        List<Observateur> observateurs = new ArrayList<>();
        observateurs.add(new ObservateurBoucle(manager));
        observateurs.add(new ObservateurBoucleVue(this));
        manager.lancerBoucleJeu(observateurs);
    }

}
