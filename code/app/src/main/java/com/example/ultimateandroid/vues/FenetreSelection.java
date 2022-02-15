package com.example.ultimateandroid.vues;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ultimateandroid.R;
import com.example.ultimateandroid.modele.Manager;

public class FenetreSelection extends AppCompatActivity {

    private Manager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_selection);
        //manager=(Manager)savedInstanceState.get("manager");
    }

    public void lancementPartie(View view){
        Intent intent = new Intent(this,FenetreJeu.class);
        //intent.putExtra("manager",manager);
        startActivity(intent); //On lance l'activité
    }


}
