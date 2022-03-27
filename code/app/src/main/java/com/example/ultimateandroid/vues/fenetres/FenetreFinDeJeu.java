package com.example.ultimateandroid.vues.fenetres;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ultimateandroid.R;

/**
 * Code behind de la fenetre de fin de jeu
 */
public class FenetreFinDeJeu extends AppCompatActivity {

    private TextView text;

    /**
     * Appelée à la création de l'activité, initialise le texte à afficher
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_fin_de_jeu);

        text = findViewById(R.id.texteFinDeJeu);
        if(getIntent().getBooleanExtra("isWinner",false)){
            text.setText(R.string.texteVictoire);
        }
        else{
            text.setText(R.string.texteDefaite);
        }
    }

    /**
     * Retourne au menu principal
     * @param view : view qui a appelée l'évènement
     */
    public void retourMenu(View view){
        startActivity(new Intent(this,FenetreLancement.class));
        finish();
    }
}
