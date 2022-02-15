package com.example.ultimateandroid.vues;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ultimateandroid.R;
import com.example.ultimateandroid.modele.Manager;

public class FenetreJeu extends AppCompatActivity {

    private Manager manager;


    public void deplacerAGauche(){
        manager.deplacerPokemon("Q");
    }
    public void deplacerADroite(){
        manager.deplacerPokemon("D");
    }
    public void deplacerEnHaut(){
        manager.deplacerPokemon("Z");
    }
    public void deplacerEnBas(){
        manager.deplacerPokemon("S");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_jeu); //Je rattache le code behind à la fenêtre
        //manager.setPokemonCourant(manager.getPokedex().getPokemon("Bulbizarre",1));
        //manager=(Manager)savedInstanceState.get("manager");
    }
}
