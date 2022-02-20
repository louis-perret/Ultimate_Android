package com.example.ultimateandroid.vues;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ultimateandroid.R;
import com.example.ultimateandroid.modele.Manager;

public class FenetreScore extends AppCompatActivity {

    private Manager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_score);
        manager=(Manager)getIntent().getSerializableExtra("manager");
    }

}
