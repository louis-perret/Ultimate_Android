package com.example.ultimateandroid.vues.fenetres;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ultimateandroid.R;
import com.example.ultimateandroid.modele.Manager;
import com.example.ultimateandroid.modele.entite.Entite;
import com.example.ultimateandroid.modele.entite.Mouvement;
import com.example.ultimateandroid.vues.App;

/**
 * Code behind de notre fenêtre combat
 */
public class FenetreCombat extends AppCompatActivity {

    private Manager manager;
    private ImageView imageAllie, imageEnnemi, etatAllie, etatEnnemi;
    private TextView vieAllie,vieEnnemi;
    private Button attaque1Allie, attaque2Allie, attaque3Allie, attaque4Allie;

    private int largeurEcran, hauteurEcran, pvTotauxAllie, pvTotauxEnnemi;

    /**
     * Appelée à la création
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_combat);
        manager = ((App) getApplication()).getManager();
        //On récupère la largeur et la hauteur de la fenêtre
        largeurEcran = getIntent().getIntExtra("largeurEran",getResources().getDisplayMetrics().widthPixels);
        hauteurEcran = getIntent().getIntExtra("hauteurEran",getResources().getDisplayMetrics().heightPixels);

        //On récupère chaque élément de l'activité
        imageAllie = findViewById(R.id.imageAllie);
        imageEnnemi = findViewById(R.id.imageEnnemi);
        etatAllie = findViewById(R.id.etatAllie);
        etatEnnemi = findViewById(R.id.etatEnnemi);
        vieAllie = findViewById(R.id.vieAllie);
        vieEnnemi = findViewById(R.id.vieEnnemi);
        attaque1Allie = findViewById(R.id.attaque1Allie);
        attaque2Allie = findViewById(R.id.attaque2Allie);
        attaque3Allie = findViewById(R.id.attaque3Allie);
        attaque4Allie = findViewById(R.id.attaque4Allie);
    }

    /**
     *
     */
    @Override
    protected void onStart() {
        super.onStart();
        manager.lancerCombat();

        pvTotauxAllie = manager.getAllie().getPv();
        pvTotauxEnnemi = manager.getEnnemiCourant().getPv();
        updateCombat();
        imageAllie.setX(largeurEcran/5F);
        imageAllie.setY(hauteurEcran * 0.54F);
        imageEnnemi.setX(largeurEcran * 2/3F);
        imageEnnemi.setY(hauteurEcran * 0.2F);
    }

    /**
     * Permet d'actualiser les pv, les états et les images des entités
     */
    @SuppressLint("SetTextI18n")
    public void updateCombat(){
        Entite allie = manager.getAllie();
        imageAllie.setImageBitmap(BitmapFactory.decodeResource(getResources(), manager.getAllie().getImage()));
        vieAllie.setText(getString(R.string.textePvJoueur) + allie.getPv() + "/" + pvTotauxAllie);
        imageEnnemi.setImageBitmap(BitmapFactory.decodeResource(getResources(),manager.getEnnemiCourant().getImage()));
        vieEnnemi.setText(getString(R.string.textePvEnnemi) + manager.getEnnemiCourant().getPv() + "/" + pvTotauxEnnemi);

        if(manager.getAllie().getEtat() != null){
            etatAllie.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), manager.getAllie().getEtat().getImage()),largeurEcran/12,hauteurEcran/10,false));
        }
        if(manager.getEnnemiCourant().getEtat() != null){
            etatEnnemi.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), manager.getEnnemiCourant().getEtat().getImage()),largeurEcran/12,hauteurEcran/10,false));
        }
        attaque1Allie.setText(allie.getMouvements()[0].getNom());
        attaque2Allie.setText(allie.getMouvements()[1].getNom());
        attaque3Allie.setText(allie.getMouvements()[2].getNom());
        attaque4Allie.setText(allie.getMouvements()[3].getNom());
    }

    /**
     * Effectue un tour de combat
     * @param view : view qui a appelé la méthode
     */
    public void effectuerUneManche(View view){
        Button b = (Button) view;
        Mouvement mouvementAllie = null;
        for(Mouvement m : manager.getAllie().getMouvements()){
            String mName = String.valueOf(m.getNom());
            if(getString(m.getNom()).equals(b.getText().toString())){
                mouvementAllie = m; //on récupère l'attaque d'après le nom
            }
        }

        switch (manager.tourDeCombat(mouvementAllie)){
            case 0: //si les deux entités sont toujours vivantes
                updateCombat();
                break;
            case 1: //si le joueur a mis ko une entité
                updateCombat();
                break;
            case 2: //si le joueur a perdu (son allie est ko)
                lancerFinDeJeu(false);
                break;
            case 3: //si le joueur a finie la vague
                lancerNouvelleVague();
                break;
            case 4: //si le joueur a gagné le jeu (remporté toutes les manches)
                lancerFinDeJeu(true);
                break;
        }
    }

    /**
     * Termine le jeu
     * @param isWinner : true si le joueur à remporté la partie
     */
    public void lancerFinDeJeu(boolean isWinner){
        Intent intent = new Intent(this, FenetreFinDeJeu.class);
        intent.putExtra("isWinner", isWinner);
        startActivity(intent);
        finish();
    }

    /**
     * Lance une nouvelle vague
     */
    public void lancerNouvelleVague(){
        Intent intent = new Intent(this, FenetreJeu.class);
        startActivity(intent);
        finish();
    }
}
