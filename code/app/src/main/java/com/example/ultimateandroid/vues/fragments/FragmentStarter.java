package com.example.ultimateandroid.vues.fragments;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ultimateandroid.R;
import com.example.ultimateandroid.modele.entite.Entite;
import com.example.ultimateandroid.vues.App;
import com.example.ultimateandroid.vues.fenetres.FenetreSelection;

/**
 * Code du fragment fragment_starter
 */
public class FragmentStarter extends Fragment {

    private Entite allie; //entité à afficher

    /**
     * Constructeur de la classe
     */
    public FragmentStarter() {
        super(R.layout.fragment_starter);
    }

    /**
     * onCreate de la vue
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        ImageView image = view.findViewById(R.id.imageFragment);
        Button bouton = view.findViewById(R.id.buttonFragment);

        if (bundle != null){
            allie = (Entite)bundle.getSerializable("starter");
            image.setImageBitmap(BitmapFactory.decodeResource(getResources(), allie.getImage()));
            bouton.setText(allie.getNom());

            bouton.setOnClickListener(view1 -> { //on set l'action du bouton du fragment
                ((App)requireActivity().getApplication()).getManager().setAllie(allie.getNom(), allie.getNiveau()); //on récupère le manager pour set l'allié en fonction du choix de l'utilisateur
                ((FenetreSelection)requireActivity()).lancementPartie(); //puis on lance le jeu
            });
        }
    }
}




