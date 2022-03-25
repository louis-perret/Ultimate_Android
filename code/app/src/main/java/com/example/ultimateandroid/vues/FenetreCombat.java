package com.example.ultimateandroid.vues;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ultimateandroid.R;
import com.example.ultimateandroid.modele.Manager;

public class FenetreCombat extends AppCompatActivity {

    private Manager manager;
    private ImageView imageALlie, imageEnnemi;
    private int largeurEcran, hauteurEcran;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_combat);
        manager = ((App) getApplication()).getManager();
        largeurEcran = getSupportParentActivityIntent().getIntExtra("largeurEran",getResources().getDisplayMetrics().widthPixels);
        hauteurEcran = getSupportParentActivityIntent().getIntExtra("hauteurEran",getResources().getDisplayMetrics().heightPixels);
    }

    @Override
    protected void onStart() {
        super.onStart();
        manager.lancerCombat();
        imageALlie = findViewById(R.id.imageAllie);
        imageALlie.setImageBitmap(BitmapFactory.decodeResource(getResources(), manager.getAllie().getImage()));
        imageALlie.setX(largeurEcran/3F);
        imageALlie.setY(hauteurEcran * 0.80F);
        imageEnnemi = findViewById(R.id.imageEnnemi);
        imageEnnemi.setImageBitmap(BitmapFactory.decodeResource(getResources(),manager.getEnnemiCourant().getImage()));
        imageEnnemi.setX(largeurEcran * 2/3F);
        imageEnnemi.setY(hauteurEcran * 0.2F);
    }
}
