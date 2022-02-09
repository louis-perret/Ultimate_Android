package com.example.ultimateandroid.vues;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ultimateandroid.R;

public class FenetreJeu extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_jeu); //Je rattache le code behind à la fenêtre
    }
}
