package com.example.ultimateandroid.vues;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ultimateandroid.R;
import com.example.ultimateandroid.modele.Manager;
import com.example.ultimateandroid.persistance.Stub;

import java.io.File;
import java.io.IOException;

/**
 * code behind de la vue fenetre_lancement
 */
public class FenetreLancement extends AppCompatActivity {

    private Manager manager;

    /**
     * méthode permettant d'aller à la vue fenetre_lancement au click du bouton
     * @param view
     */
    public void lancementJeu(View view){
        Intent intent = new Intent(this,FenetreSelection.class);
        startActivity(intent); //On lance l'activité
    }

    /**
     *méthode permettant d'aller à la vue fenetre_score au click du bouton
     * @param view
     */
    public void consultationScores(View view){
        Intent intent = new Intent(this,FenetreScore.class);
        startActivity(intent); //On lance l'activité
    }

    /**
     * méthode permettant de quitter le jeu au click du bouton
     * @param view
     */
    public void quitterJeu(View view) {
        finish();
    }

    /**
     * onCreate de la vue
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //taille de la fenêtre : displayMetrix
        setContentView(R.layout.fenetre_lancement); //Je rattache le code behind à la fenêtre
        manager = ((App)getApplication()).getManager();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = getResources().getConfiguration().screenWidthDp;
        int height = getResources().getConfiguration().screenHeightDp;
        System.out.println("cc");
    }
}
