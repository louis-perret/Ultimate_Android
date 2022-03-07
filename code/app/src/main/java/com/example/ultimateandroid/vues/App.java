package com.example.ultimateandroid.vues;

import android.app.Application;

import com.example.ultimateandroid.modele.Manager;
import com.example.ultimateandroid.persistance.Stub;

public class App extends Application {

    private Manager manager;

    @Override
    public void onCreate() {
        super.onCreate();
        manager = new Manager(new Stub().charger());
    }

    public Manager getManager() {
        return manager;
    }
}
