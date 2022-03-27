package com.example.ultimateandroid.vues.fenetres;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.ultimateandroid.R;
import com.example.ultimateandroid.modele.Manager;
import com.example.ultimateandroid.modele.monde.Carte;
import com.example.ultimateandroid.modele.observateurs.Observateur;
import com.example.ultimateandroid.modele.observateurs.ObservateurBoucle;
import com.example.ultimateandroid.vues.App;
import com.example.ultimateandroid.vues.observateurs.ObservateurBoucleVue;

import java.util.ArrayList;
import java.util.List;

/**
 * Code behind de la vue fenetre_jeu
 */
public class FenetreJeu extends AppCompatActivity {

    private Manager manager;
    private ConstraintLayout layout;
    private ImageView imageAllie;
    private int largeurEcran;
    private int hauteurEcran;
    private int largeurTuile;
    private int hauteurTuile;

    /**
     * Permet de modifier la valeur de la position de l'image
     */
    private void setPositionImageAllie(){
        imageAllie.setX((float)manager.getAllie().getPosition().getPositionX() * 3);
        imageAllie.setY((float)manager.getAllie().getPosition().getPositionY() * 3);
    }

    /**
     * Méthode permettant d'afficher la carte du jeu
     */
    private void afficherCarte() {
        Carte carte = manager.getCarteCourante();
        ImageView image;
        for (int j = 0; j < carte.getHauteur(); j++) {
            for (int i = 0; i < carte.getLargeur(); i++) {
                Bitmap b1 = BitmapFactory.decodeResource(getResources(), carte.getTuile(i, j, manager.getBanque().getDicoTuiles()).getImage()); //on récupère notre image
                Bitmap b2 = Bitmap.createScaledBitmap(b1, largeurTuile, hauteurTuile,false);
                image = new ImageView(this);
                image.setImageBitmap(b2); //on crée notre image view
                image.setX(i * largeurTuile);
                image.setY(j * hauteurTuile);
                layout.addView(image); //puis on l'ajoute dans notre layout
            }
        }
    }

    /**
     * Permet de mettre à jour a postion de l'entité sur la carte
     */
    public void updatePosition(){
        setPositionImageAllie();
    }


    /**
     * Lance un combat
     */
    public void lancerCombat(){
        Intent intent = new Intent(this,FenetreCombat.class);
        intent.putExtra("largeurEcran",largeurEcran);
        intent.putExtra("hauteurEcran", hauteurEcran);
        startActivity(intent);
        finish();
    }

    /**
     * onCreate de la vue
     * @param savedInstanceState:
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_jeu); //Je rattache le code behind à la fenêtre
        layout = findViewById(R.id.layout2);
        manager = ((App)getApplication()).getManager();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        largeurEcran = displayMetrics.widthPixels;
        hauteurEcran = displayMetrics.heightPixels;
        largeurTuile = largeurEcran/manager.getCarteCourante().getLargeur();
        hauteurTuile = hauteurEcran/manager.getCarteCourante().getHauteur();

        afficherCarte();
        imageAllie = new ImageView(this); //On ajoute notre image view pour qu'elle soit au dessus et non en dessous de la map
        //on rescale l'image pour qu'elle s'adapte à la taille d'une tuile
        imageAllie.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(),manager.getAllie().getImage()),largeurTuile, hauteurTuile,false));
        layout.addView(imageAllie);
    }

    /**
     *
     */
    @Override
    protected void onStart() {
        super.onStart();
        List<Observateur> observateurs = new ArrayList<>();
        observateurs.add(new ObservateurBoucle(manager));
        observateurs.add(new ObservateurBoucleVue(this));
        manager.lancerBoucleJeu(observateurs);
    }

    /**
     *
     */
    @Override
    protected void onStop() {
        super.onStop();
        manager.terminerBoucleJeu();
    }
}
