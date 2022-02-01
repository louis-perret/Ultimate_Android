package com.example.ultimateandroid.vues;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ultimateandroid.R;

public class FenetreLancement extends AppCompatActivity {

    private TextView titreJeu;
    private Button buttonExit;
    private Button buttonPlay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_lancement); //Je rattache le code behind à la fenêtre
        titreJeu=findViewById(R.id.titreJeu); //Je récupère mon textView de ma fenêtre
        titreJeu.setText(R.string.app_name); //Je set son texte
        buttonExit=findViewById(R.id.buttonExit);
        buttonExit.setText(R.string.boutonQuitter);
        buttonPlay=findViewById(R.id.buttonPlay);
        buttonPlay.setText(R.string.boutonLancement);
    }
}
