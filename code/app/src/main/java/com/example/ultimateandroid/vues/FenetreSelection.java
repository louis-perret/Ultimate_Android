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

        //création des bundle pour chaque fragment
        Bundle bgauche = new Bundle();
        Bundle bmilieu = new Bundle();
        Bundle bdroit = new Bundle();

        //ajouter les images pour les bundle
        bdroit.putInt("image", R.drawable.ordi);
        bmilieu.putInt("image", R.drawable.tel);
        bgauche.putInt("image", R.drawable.console);

        //ajouter les noms des boutons pour les bundle
        bdroit.putString("nomBouton", getResources().getString(R.string.nomBoutonStarterDroit));
        bmilieu.putString("nomBouton", getResources().getString(R.string.nomBoutonStarterMilieu));
        bgauche.putString("nomBouton", getResources().getString(R.string.nomBoutonStarterGauche));

        //manager fragment, je donne les bundle en argument
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

    /**
     * méthode permettant d'aller sur la vue fenetre_jeu mais aussi d'enregistrer le pseudo du joueur qu'il aura renseigné
     * @param view
     */
    public void lancementPartie(View view){
        Intent intent = new Intent(this,FenetreJeu.class);
        startActivity(intent); //On lance l'activité
    }


}
