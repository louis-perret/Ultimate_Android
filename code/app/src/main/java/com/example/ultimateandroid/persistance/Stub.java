package com.example.ultimateandroid.persistance;

import androidx.annotation.NonNull;

import com.example.ultimateandroid.R;
import com.example.ultimateandroid.modele.Banque;
import com.example.ultimateandroid.modele.joueur.Joueur;
import com.example.ultimateandroid.modele.monde.Tuile;
import com.example.ultimateandroid.modele.entite.CollectionEntite;
import com.example.ultimateandroid.modele.entite.Mouvement;
import com.example.ultimateandroid.modele.entite.NomType;
import com.example.ultimateandroid.modele.entite.Entite;
import com.example.ultimateandroid.modele.entite.Position;
import com.example.ultimateandroid.modele.entite.Type;
import com.example.ultimateandroid.modele.entite.etat.CourtCircuit;
import com.example.ultimateandroid.modele.entite.etat.Humide;
import com.example.ultimateandroid.modele.entite.etat.MiseAJour;

import java.io.FileInputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Classe simulant un chargement à partir d'un jeu de données
 */
public class Stub extends Chargeur{

    /**
     * Charge un objet Manager à partir d'un jeu de données
     * @return un Manager
     */
    @Override
    public Banque charger() {

        //test pour les scores
        List<Joueur> lesJoueurs = new ArrayList<>();
        Joueur j1 = new Joueur("Hansi", 2);
        Joueur j2 = new Joueur("Levi", 6);
        Joueur j3 = new Joueur("Erwin", 4);
        lesJoueurs.add(j1);
        lesJoueurs.add(j2);
        lesJoueurs.add(j3);

        List<Entite> niveau1=new ArrayList<>();
        List<Entite> niveau2=new ArrayList<>();
        List<Entite> niveau3=new ArrayList<>();

        /* Création des types */
        List<NomType> faiblesses = new ArrayList<>();
        List<NomType> forces = new ArrayList<>();



        faiblesses.add(NomType.smartphone);
        forces.add(NomType.windows);
        forces.add(NomType.mac);
        forces.add(NomType.consolePortable);
        forces.add(NomType.consoleSalon);
        Type linux = new Type(NomType.linux,forces,faiblesses);

        faiblesses = new ArrayList<>();
        faiblesses.add(NomType.linux);
        faiblesses.add(NomType.consoleSalon);
        forces = new ArrayList<>();
        forces.add(NomType.apple);
        forces.add(NomType.windows);
        forces.add(NomType.consolePortable);
        Type mac = new Type(NomType.mac,forces,faiblesses);

        faiblesses = new ArrayList<>();
        faiblesses.add(NomType.linux);
        faiblesses.add(NomType.mac);
        faiblesses.add(NomType.consoleSalon);
        forces = new ArrayList<>();
        forces.add(NomType.smartphone);
        forces.add(NomType.nokia);
        Type windows = new Type(NomType.windows,forces,faiblesses);

        faiblesses = new ArrayList<>();
        faiblesses.add(NomType.mac);
        forces = new ArrayList<>();
        forces.add(NomType.nokia);
        Type apple = new Type(NomType.apple,forces,faiblesses);

        faiblesses = new ArrayList<>();
        faiblesses.add(NomType.windows);
        faiblesses.add(NomType.apple);
        faiblesses.add(NomType.smartphone);
        faiblesses.add(NomType.consolePortable);
        forces = new ArrayList<>();

        Type nokia = new Type(NomType.nokia,forces,faiblesses);

        faiblesses = new ArrayList<>();
        faiblesses.add(NomType.windows);
        faiblesses.add(NomType.consolePortable);
        forces = new ArrayList<>();
        forces.add(NomType.linux);
        forces.add(NomType.nokia);
        Type smartphone = new Type(NomType.smartphone,forces,faiblesses);

        faiblesses = new ArrayList<>();
        faiblesses.add(NomType.linux);
        faiblesses.add(NomType.mac);
        forces = new ArrayList<>();
        forces.add(NomType.smartphone);
        forces.add(NomType.nokia);
        forces.add(NomType.consolePortable);
        Type consoleP = new Type(NomType.consolePortable,forces,faiblesses);


        faiblesses = new ArrayList<>();
        faiblesses.add(NomType.linux);
        faiblesses.add(NomType.consolePortable);
        forces = new ArrayList<>();
        forces.add(NomType.mac);
        forces.add(NomType.windows);
        forces.add(NomType.consolePortable);
        Type consoleS = new Type(NomType.consoleSalon,forces,faiblesses);


        Position position = new Position(0,0);
        CourtCircuit courtCircuit = new CourtCircuit("Court-circuit","/Status/poison.png");
        MiseAJour miseAJour = new MiseAJour("Mise à jour","/Status/paralysie.png");
        Humide humide = new Humide("Humide","/Status/brulure.png");

        /* Création des attaques */
        Mouvement pistolet_a_eau = new Mouvement(20,"Pistolet à eau",consoleP, humide);
        Mouvement rapidite = new Mouvement(20,"Rapidité",linux,null);
        Mouvement decharge = new Mouvement(0,"Décharge",nokia, courtCircuit);
        Mouvement charge = new Mouvement(9,"Charge",nokia,null);
        Mouvement batterie = new Mouvement(15,"Batterie",smartphone,null);
        Mouvement trempette = new Mouvement(0,"Trempette",smartphone,null);
        Mouvement mise_a_jour = new Mouvement(10,"Mise à jour",linux, miseAJour);
        Mouvement depense = new Mouvement(10,"Dépense",apple,null);
        Mouvement siri = new Mouvement(12,"Siri",mac,null);
        Mouvement sabotage = new Mouvement(11,"Sabotage",mac,null);
        Mouvement confort = new Mouvement(10,"Confort",consoleS,null);
        Mouvement stabilite = new Mouvement(5,"Stabilité",windows,null);
        Mouvement vague_psy = new Mouvement(10,"Vague Psy",windows,null);


        Mouvement lanceEau = new Mouvement(30,"Lance-eau",consoleP, humide);
        Mouvement pied_saute = new Mouvement(21,"Pied sauté",consoleP,null);
        Mouvement rapide2 = new Mouvement(30,"Super Rapidité ",linux,null);
        Mouvement petitVoltage = new Mouvement(15,"Petit voltage",nokia, courtCircuit);
        Mouvement superBatterie = new Mouvement(25,"Super batterie",smartphone,null);
        Mouvement mise_a_jour2 = new Mouvement(20,"Mise à jour 2",linux, miseAJour);
        Mouvement onereuse = new Mouvement(15,"Dépense onéreuse",apple,null);
        Mouvement superSiri = new Mouvement(22,"Super Siri",mac,null);
        Mouvement superConfort = new Mouvement(20,"Super Confort",consoleS,null);
        Mouvement belier = new Mouvement(20,"Bélier",consoleS,null);
        Mouvement superSatble = new Mouvement(10,"Super Satibilité",windows,null);



        Mouvement tsunami = new Mouvement(40,"Tsunami",consoleP, humide);
        Mouvement tempeteRapide = new Mouvement(40,"Tempête de rapidité",linux,null);
        Mouvement volt = new Mouvement(25,"1000 volt",nokia, courtCircuit);
        Mouvement megaBatterie = new Mouvement(25,"Mega Batterie",smartphone,null);
        Mouvement miseAjour3 = new Mouvement(25,"Mega mise à jour",linux, miseAJour);
        Mouvement ruine = new Mouvement(30,"Ruine",apple,null);
        Mouvement giga_impact = new Mouvement(40,"Giga-Impact",apple,null);
        Mouvement megaSiri = new Mouvement(30,"Mega Siri",mac,null);
        Mouvement megaConfort = new Mouvement(30,"Mega confort",consoleS,null);
        Mouvement megaStable = new Mouvement(30,"Mega Stabilité",windows,null);



        //Création des stater
        Mouvement[] tabMouvements=new Mouvement[]{rapidite, rapide2, tempeteRapide, rapidite};
        Entite e = new Entite("PC",R.drawable.ordi,70,25,30,10,position, linux,tabMouvements,1,0,"Herbizarre", true);
        niveau1.add(e);
        tabMouvements=new Mouvement[]{pistolet_a_eau, lanceEau, tsunami, pied_saute };
        e = new Entite("Console",R.drawable.console,70,30,20,15,position, consoleP,tabMouvements,1,0,"Reptincel", true);
        niveau1.add(e);
        tabMouvements=new Mouvement[]{batterie, superBatterie, megaBatterie, trempette};
        e = new Entite("Téléphone",R.drawable.tel,70,25,25,20,position, smartphone,tabMouvements,1,0,"Carabaffe", true);
        niveau1.add(e);

        //Création des ennemis
        //niveau 1
        tabMouvements=new Mouvement[]{charge, decharge, volt, petitVoltage };
        e = new Entite("Nikia 3310",R.drawable.nokia,70,20,20,10,position, nokia,tabMouvements,1,0,"Super Nokia", false);
        niveau1.add(e);
        tabMouvements=new Mouvement[]{sabotage, siri, superSiri, megaSiri };
        e = new Entite("MacBook",R.drawable.mac,70,25,25,15,position, mac,tabMouvements,1,0,"Mac book pro", false);
        niveau1.add(e);
        tabMouvements=new Mouvement[]{vague_psy, stabilite, superSatble, megaStable };
        e = new Entite("Windows 1.0",R.drawable.windows,70,25,15,10,position, windows,tabMouvements,1,0,"Windows 10", false);
        niveau1.add(e);

        //niveau 2
        tabMouvements=new Mouvement[]{belier, confort, superConfort, megaConfort };
        e = new Entite("PS1",R.drawable.console_s,80,35,25,20,position, consoleS,tabMouvements,2,0,"PS5", false);
        niveau2.add(e);
        tabMouvements=new Mouvement[]{pistolet_a_eau, lanceEau, tsunami, pied_saute };
        e = new Entite("Gameboy Color",R.drawable.console_p,40,30,25,25,position, consoleP,tabMouvements,2,0,"DS3D", false);
        niveau2.add(e);
        tabMouvements=new Mouvement[]{batterie, superBatterie, megaBatterie, trempette };
        e = new Entite("IBM Simon",R.drawable.smartphone,80,35,30,25,position, smartphone,tabMouvements,2,0,"Super téléphone", false);
        niveau2.add(e);

        //niveau 3
        tabMouvements=new Mouvement[]{tempeteRapide,rapide2, rapidite, miseAjour3 };
        e = new Entite("Super Linux",R.drawable.linux,90,50,35,35,position, linux,tabMouvements,3,0,"Super linux", false);
        niveau3.add(e);
        tabMouvements=new Mouvement[]{ giga_impact, ruine, depense, onereuse };
        e = new Entite("iPhone",R.drawable.apple,90,40,35,30,position, apple,tabMouvements,3,0,"Apple 11", false);
        niveau3.add(e);
        tabMouvements=new Mouvement[]{batterie, superBatterie, megaBatterie, trempette };
        e = new Entite("Samsung",R.drawable.smartphone_evolution,90,45,40,35,position, smartphone,tabMouvements,3,0,"super spartphone", false);
        niveau2.add(e);


        CollectionEntite collectionEntite = new CollectionEntite(niveau1,niveau2,niveau3);

        Tuile tuileHerbe = new Tuile(0, R.drawable.herbe,true,0);
        Tuile tuilePbg = new Tuile(1,R.drawable.portail_bas_gauche,true,2);
        Tuile tuilePbd = new Tuile(2,R.drawable.portail_bas_droite,true,2);
        Tuile tuilePhg = new Tuile(3,R.drawable.portail_haut_gauche,false, 0);
        Tuile tuilePhd = new Tuile(4,R.drawable.portail_haut_droite,false, 0);
        Tuile tuileBrique = new Tuile(5,R.drawable.brique,false,0);
        Tuile tuileSortie = new Tuile(6,R.drawable.sortie,true,1);
        Tuile tuileSolA = new Tuile(7,R.drawable.sol_arene,true,3);
        Tuile tuilePanneau = new Tuile(8,R.drawable.panneau,false,0);
        Tuile tuileArbre = new Tuile(9,R.drawable.arbre,false,0);
        Tuile tuilePilier = new Tuile(10,R.drawable.pilier,false,0);
        Tuile tuileRocher = new Tuile(11,R.drawable.rocher,false,0);
        Tuile tuileSol = new Tuile(12,R.drawable.sol,true,0);
        Tuile tuileTronc = new Tuile(13,R.drawable.tronc,false,0);

        //Création des tuiles
        Map<Integer,Tuile> dicoTuiles=new HashMap<>();
        dicoTuiles.put(tuileHerbe.getId(),tuileHerbe);
        dicoTuiles.put(tuilePbg.getId(),tuilePbg);
        dicoTuiles.put(tuilePbd.getId(),tuilePbd);
        dicoTuiles.put(tuilePhg.getId(),tuilePhg);
        dicoTuiles.put(tuilePhd.getId(),tuilePhd);
        dicoTuiles.put(tuileBrique.getId(),tuileBrique);
        dicoTuiles.put(tuileSortie.getId(),tuileSortie);
        dicoTuiles.put(tuileSolA.getId(),tuileSolA);
        dicoTuiles.put(tuilePanneau.getId(),tuilePanneau);
        dicoTuiles.put(tuileArbre.getId(),tuileArbre);
        dicoTuiles.put(tuilePilier.getId(),tuilePilier);
        dicoTuiles.put(tuileRocher.getId(),tuileRocher);
        dicoTuiles.put(tuileSol.getId(),tuileSol);
        dicoTuiles.put(tuileTronc.getId(),tuileTronc);
        return new Banque(collectionEntite,lesJoueurs,dicoTuiles);
    }
}
