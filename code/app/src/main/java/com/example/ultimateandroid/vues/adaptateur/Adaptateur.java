package com.example.ultimateandroid.vues.adaptateur;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ultimateandroid.R;
import com.example.ultimateandroid.modele.joueur.Joueur;
import com.example.ultimateandroid.vues.FenetreScore;

import java.util.List;

public class Adaptateur extends RecyclerView.Adapter {

    private List<Joueur> lesJoueurs;
    private FenetreScore actParent;

    public Adaptateur( List<Joueur> lesJoueurs, FenetreScore actParent) {
        this.lesJoueurs = lesJoueurs;
        this.actParent = actParent;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View leLayout =  actParent.getLayoutInflater().inflate(R.layout.cellule_joueur, parent, false);
        return new ViewHolderJoueur(leLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Joueur joueur = lesJoueurs.get(position);
        ((ViewHolderJoueur)holder).getTextViewP().setText(joueur.getPseudo());
        ((ViewHolderJoueur)holder).getTextViewV().setText(String.valueOf(joueur.getNbVictoire()));
    }

    @Override
    public int getItemCount() {
        return lesJoueurs.size();
    }
}
