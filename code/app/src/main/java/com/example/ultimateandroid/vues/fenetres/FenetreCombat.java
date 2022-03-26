package com.example.ultimateandroid.vues.fenetres;

import android.annotation.SuppressLint;
import android.content.Intent;
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

public class FenetreCombat extends AppCompatActivity {

    private Manager manager;
    private ImageView imageAllie, imageEnnemi;
    private TextView vieAllie,vieEnnemi;
    private Button attaque1Allie, attaque2Allie, attaque3Allie, attaque4Allie;

    private int largeurEcran, hauteurEcran, pvTotauxAllie, pvTotauxEnnemi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_combat);
        manager = ((App) getApplication()).getManager();
        largeurEcran = getIntent().getIntExtra("largeurEran",getResources().getDisplayMetrics().widthPixels);
        hauteurEcran = getIntent().getIntExtra("hauteurEran",getResources().getDisplayMetrics().heightPixels);

        imageAllie = findViewById(R.id.imageAllie);
        imageEnnemi = findViewById(R.id.imageEnnemi);
        vieAllie = (TextView) findViewById(R.id.vieAllie);
        vieEnnemi = (TextView) findViewById(R.id.vieEnnemi);
        attaque1Allie = findViewById(R.id.attaque1Allie);
        attaque2Allie = findViewById(R.id.attaque2Allie);
        attaque3Allie = findViewById(R.id.attaque3Allie);
        attaque4Allie = findViewById(R.id.attaque4Allie);
    }

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

    @SuppressLint("SetTextI18n")
    public void updateCombat(){
        Entite allie = manager.getAllie();
        imageAllie.setImageBitmap(BitmapFactory.decodeResource(getResources(), manager.getAllie().getImage()));
        vieAllie.setText("PV joueur : " + allie.getPv() + "/" + pvTotauxAllie);
        imageEnnemi.setImageBitmap(BitmapFactory.decodeResource(getResources(),manager.getEnnemiCourant().getImage()));
        vieEnnemi.setText("PV ennmemi : " + manager.getEnnemiCourant().getPv() + "/" + pvTotauxEnnemi);

        attaque1Allie.setText(allie.getMouvements()[0].getNom());
        attaque2Allie.setText(allie.getMouvements()[1].getNom());
        attaque3Allie.setText(allie.getMouvements()[2].getNom());
        attaque4Allie.setText(allie.getMouvements()[3].getNom());
    }

    public void effectuerUneManche(View view){
        Button b = (Button) view;
        Mouvement mouvementAllie = null;
        for(Mouvement m : manager.getAllie().getMouvements()){
            if(m.getNom().equals(b.getText())){
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

    public void lancerFinDeJeu(boolean isWinner){
        Intent intent = new Intent(this, FenetreFinDeJeu.class);
        intent.putExtra("isWinner", isWinner);
        startActivity(intent);
    }

    public void lancerNouvelleVague(){
        Intent intent = new Intent(this, FenetreJeu.class);
        startActivity(intent);
    }
}
