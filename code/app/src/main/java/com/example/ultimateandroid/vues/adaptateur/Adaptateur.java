package com.example.ultimateandroid.vues.adaptateur;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ultimateandroid.R;
import com.example.ultimateandroid.modele.joueur.Joueur;
import com.example.ultimateandroid.vues.fenetres.FenetreScore;

import java.util.List;

/**
 * Adaptateur du RecyclerView de FenetreScore
 */
public class Adaptateur extends RecyclerView.Adapter {

    private List<Joueur> lesJoueurs; //liste des joueurs à afficher
    private FenetreScore actParent;

    /**
     * Constructeur
     * @param lesJoueurs : liste des joueurs à afficher
     * @param actParent : activité parente du recyclerView
     */
    public Adaptateur( List<Joueur> lesJoueurs, FenetreScore actParent) {
        this.lesJoueurs = lesJoueurs;
        this.actParent = actParent;
    }

    /**
     * Créer la cellule
     * @param parent : ViewGroup dans lequel sera ajouté la cellule
     * @param viewType : Type de la nouvelle cellule
     * @return : cellule_joueur
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View leLayout =  actParent.getLayoutInflater().inflate(R.layout.cellule_joueur, parent, false);
        return new ViewHolderJoueur(leLayout);
    }

    /**
     * Ajoute les informations dans la cellule appprès sa création
     * @param holder : Cellule
     * @param position : Position de la donnée a ajouté dans la collection de joueurs
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Joueur joueur = lesJoueurs.get(position);
        ((ViewHolderJoueur)holder).getTextViewP().setText(joueur.getPseudo());
        ((ViewHolderJoueur)holder).getTextViewV().setText(String.valueOf(joueur.getNbVictoire()));
    }

    /**
     * Retourne la taille de la collection de joueurs
     * @return : int
     */
    @Override
    public int getItemCount() {
        return lesJoueurs.size();
    }
}
