package com.example.ultimateandroid.vues.fenetres;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ultimateandroid.R;

public class FenetreFinDeJeu extends AppCompatActivity {

    private TextView text;

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

    public void retourMenu(View view){
        startActivity(new Intent(this,FenetreLancement.class));
        finish();
    }
}
