package com.example.ultimateandroid.vues;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ultimateandroid.R;
import com.example.ultimateandroid.modele.Manager;

public class FenetreSelection2 extends AppCompatActivity {

    private Manager manager;
    private ImageView imageEnCours ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_selection2);
        manager = ((App)getApplication()).getManager();
        manager.ajouterCarte("lobby",getResources().openRawResource(R.raw.lobby));

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_view, FragmentImage.class, null)
                .commit();
    }

    public void lancementPartie(View view){
        Intent intent = new Intent(this,FenetreJeu.class);
        startActivity(intent); //On lance l'activité
    }

    //TODO finir cette méthode: vérifier si l'images courante et l'image du bouton son les mêmes, si =/= alors on récup le bouton, on vérifie qu'il est cliqué et on change l'image sur le fragment, sinon on fait rien
    public void afficherConsole(FragmentImage fragment){
       /* if () {
            Button bouton = (Button) findViewById(R.id.buttonOrdi);
            bouton.setOnClickListener();
        }*/

    }

    public void afficherOrdi(View view){

    }

    public void afficherTel(View view){


    }
}
