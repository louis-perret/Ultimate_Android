package com.example.ultimateandroid.vues.adaptateur;

import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ultimateandroid.R;

/**
 * Code behind de la cellule cellule_joueur
 */
public class ViewHolderJoueur extends RecyclerView.ViewHolder {

    private TextView textViewPseudo; //pseudo du joueur
    private TextView textViewVictoire; //nombres de victoires du joueur

    /**
     * Constructeur
     * @param itemView
     */
    public ViewHolderJoueur(@NonNull View itemView) {
        super(itemView);
        textViewPseudo = itemView.findViewById(R.id.textViewP);
        textViewVictoire = itemView.findViewById(R.id.textViewV);
    }

    //Getter
    public TextView getTextViewP (){ return textViewPseudo;}

    public TextView getTextViewV (){ return textViewVictoire;}
}
