package com.example.ultimateandroid.vues.fenetres;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ultimateandroid.R;
import com.example.ultimateandroid.modele.Manager;
import com.example.ultimateandroid.vues.App;

/**
 * Code behind de la fenetre principale de notre jeu
 */
public class FenetreLancement extends AppCompatActivity {

    private Manager manager;

    /**
     * Méthode permettant d'aller à la vue fenetre_lancement au click du bouton
     * @param view
     */
    public void lancementJeu(View view){
        Intent intent = new Intent(this,FenetreSelection.class);
        startActivity(intent); //On lance l'activité
        finish();
    }

    /**
     * Méthode permettant d'aller à la vue fenetre_score au click du bouton
     * @param view : view qui a déclenché l'évènement
     */
    public void consultationScores(View view){
        Intent intent = new Intent(this,FenetreScore.class);
        startActivity(intent); //On lance l'activité
    }

    /**
     * Méthode permettant de quitter le jeu au click du bouton
     * @param view : view qui a déclenché l'évènement
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
        super.onDestroy();
        ((App) getApplication()).getSauveur().sauver(manager.getBanque());
        finish();
    }
}
