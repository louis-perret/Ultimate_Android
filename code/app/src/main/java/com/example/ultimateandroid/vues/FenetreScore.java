package com.example.ultimateandroid.vues;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ultimateandroid.R;
import com.example.ultimateandroid.modele.Manager;
import com.example.ultimateandroid.vues.adaptateur.Adaptateur;

/**
 * code behind de la vue fenetre_score
 */
public class FenetreScore extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Manager manager;

    /**
     * onCreate de la classe
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_score);
        manager=((App)getApplication()).getManager();
    }

    /**
     * implémentation de la RecyclerView pour stocker la liste des joueurs
     */
    @Override
    protected void onResume() {
        super.onResume();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)); //Met les cellules en verticales
        recyclerView.setAdapter(new Adaptateur(manager.getLesJoueurs(),this)); //Créer son adapateur
    }
}
