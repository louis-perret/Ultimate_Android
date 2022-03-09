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
        manager = ((App)getApplication()).getManager();
        manager.ajouterCarte("lobby",getResources().openRawResource(R.raw.lobby));

        Bundle bgauche = new Bundle();
        Bundle bmilieu = new Bundle();
        Bundle bdroit = new Bundle();

        String imageDroit = "@drawable/arbre";
        bdroit.putString("test", imageDroit);

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_gauche, FragmentStarter.class, bgauche)
                .commit();

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_milieu, FragmentStarter.class, bmilieu)
                .commit();

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_droit, FragmentStarter.class, bdroit)
                .commit();

    }

    public void lancementPartie(View view){
        Intent intent = new Intent(this,FenetreJeu.class);
        startActivity(intent); //On lance l'activité
    }


}
