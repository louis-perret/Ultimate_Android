package com.example.ultimateandroid.vues;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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
        Bundle bundle = this.getArguments();

        //View v = getView();
        ImageView image = getActivity().findViewById(R.id.imageFragment);
        Button bouton = getActivity().findViewById(R.id.buttonFragment);

        if (bundle != null){
            Bitmap b = BitmapFactory.decodeResource(getResources(), bundle.getInt("test"));
            String value = bundle.getString("test");
            image.setImageBitmap(b);
        }

    }
}
