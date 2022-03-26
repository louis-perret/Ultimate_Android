package com.example.ultimateandroid.vues.fenetres;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ultimateandroid.R;
import com.example.ultimateandroid.modele.Manager;
import com.example.ultimateandroid.vues.App;

/**
 * code behind de la vue fenetre_lancement
 */
public class FenetreLancement extends AppCompatActivity {

    private Manager manager;

    /**
     * méthode permettant d'aller à la vue fenetre_lancement au click du bouton
     * @param view
     */
    public void lancementJeu(View view){
        Intent intent = new Intent(this,FenetreSelection.class);
        startActivity(intent); //On lance l'activité
    }

    /**
     *méthode permettant d'aller à la vue fenetre_score au click du bouton
     * @param view
     */
    public void consultationScores(View view){

        Intent intent = new Intent(this,FenetreScore.class);
        startActivity(intent); //On lance l'activité
    }

    /**
     * méthode permettant de quitter le jeu au click du bouton
     * @param view
     */
    public void quitterJeu(View view) {
        finish();
    }

    /**
     * onCreate de la vue
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_lancement); //Je rattache le code behind à la fenêtre
        manager = ((App) getApplication()).getManager();
    }

    @Override
    protected void onDestroy() {
        ((App) getApplication()).getSauveur().sauver(manager.getBanque());
        super.onDestroy();
    }
}
