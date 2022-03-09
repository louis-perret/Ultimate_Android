package com.example.ultimateandroid.vues;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ultimateandroid.R;

public class FragmentStarter extends Fragment {
    private FenetreSelection2 activiteParente;

    public FragmentStarter() {super(R.layout.fragment_starter);}

   /*@Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }*/


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = this.getArguments();
        if (b != null){
            String value = b.getString("test");

        }

    }
}
