package com.example.ultimateandroid.vues;

import android.content.Intent;
import android.os.Bundle;
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

public class FenetreLancement extends AppCompatActivity {

    private Manager manager;

    public void lancementJeu(View view){
        Intent intent = new Intent(this,FenetreSelection.class);
        intent.putExtra("manager",manager);
        startActivity(intent); //On lance l'activité
    }

    public void consultationScores(View view){
        Intent intent = new Intent(this,FenetreScore.class);
        startActivity(intent); //On lance l'activité
    }


    public void quitterJeu(View view) {
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_lancement); //Je rattache le code behind à la fenêtre
        manager = new Stub().charger();
        manager.ajouterCarte("lobby",getResources().openRawResource(R.raw.lobby));
    }



}
