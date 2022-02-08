package com.example.ultimateandroid.vues;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ultimateandroid.R;

public class FenetreLancement extends AppCompatActivity {


    public void lancementJeu(View view){
        Intent intent = new Intent(this,FenetreSelection.class);
        startActivity(intent); //On lance l'activité
    }

    public void quitterJeu(View view) {
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_lancement); //Je rattache le code behind à la fenêtre
    }


}
