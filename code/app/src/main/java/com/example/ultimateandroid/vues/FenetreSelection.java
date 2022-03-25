package com.example.ultimateandroid.vues;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ultimateandroid.R;
import com.example.ultimateandroid.modele.Manager;
import com.example.ultimateandroid.modele.entite.Entite;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;


public class FenetreSelection extends AppCompatActivity {

    private Manager manager;

    /**
     * Méthode appelée lors de la création de l'activité
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_selection);
        manager = ((App)getApplication()).getManager();
        manager.ajouterCarte("lobby",getResources().openRawResource(R.raw.lobby));

        //création des bundle pour chaque fragment
        List<Entite> starters = manager.getStarter();
        Bundle bgauche = new Bundle();
        Bundle bmilieu = new Bundle();
        Bundle bdroit = new Bundle();

        bgauche.putSerializable("starter", starters.get(0));
        bmilieu.putSerializable("starter", starters.get(1));
        bdroit.putSerializable("starter", starters.get(2));

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
     * Méthode appelée après onCreate
     */
    @Override
    protected void onStart() {
        super.onStart();

        TextView nbVic = findViewById(R.id.textnbVictoire);
        nbVic.setText("nombre de victoire(s): " + manager.getJoueurCourant().getNbVictoire()); //pour afficher le nombre de victoire du joueur courrant
    }

    /**
     * Méthode appelée quand l'activité n'est plus visible à l'écran
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onStop", "onStop selection" );
    }

        //TODO ajouter joueur dans liste joueur
    /**
     * méthode permettant d'aller sur la vue fenetre_jeu mais aussi d'enregistrer le pseudo du joueur qu'il aura renseigné
     * @param view
     */
    public void lancementPartie(View view){
        TextInputEditText pseudo = findViewById(R.id.inputPseudo);
        manager.addJoueur(pseudo.getText().toString());
        Intent intent = new Intent(this,FenetreJeu.class);

        startActivity(intent); //On lance l'activité
    }


}
