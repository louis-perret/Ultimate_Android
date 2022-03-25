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
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.ultimateandroid.R;
import com.example.ultimateandroid.modele.entite.Entite;

/**
 * code du fragment fragment_starter
 */
public class FragmentStarter extends Fragment {

    private View activite;
    private Entite allie;
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
        Bundle bundle = this.getArguments();
        activite = view;
        ImageView image = activite.findViewById(R.id.imageFragment);
        Button bouton = activite.findViewById(R.id.buttonFragment);

        if (bundle != null){
            allie = (Entite)bundle.getSerializable("starter");
            image.setImageBitmap(BitmapFactory.decodeResource(getResources(), allie.getImage()));
            bouton.setText(allie.getNom());
        }
    }


}




