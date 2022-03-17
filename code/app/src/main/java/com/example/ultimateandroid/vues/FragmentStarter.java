package com.example.ultimateandroid.vues;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ultimateandroid.R;

/**
 * code du fragment fragment_starter
 */
public class FragmentStarter extends Fragment {
    private FenetreSelection activiteParente;


    /**
     * constructeur de la classe
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

        int someInt = requireArguments().getInt("some_int");
        Bundle bundle = this.getArguments();
        //View v = getView();
        ImageView image = view.findViewById(R.id.imageFragment);
        Button bouton = view.findViewById(R.id.buttonFragment);

        if (bundle != null){
            Bitmap b = BitmapFactory.decodeResource(getResources(), bundle.getInt("image"));
            String value = bundle.getString("image");
            String nameB = bundle.getString("nomBouton");
            image.setImageBitmap(b);
            bouton.setText(nameB);

        }
    }

}




