package com.example.ultimateandroid.persistance;

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
        CourtCircuit courtCircuit = new CourtCircuit(R.string.statusCourt_circuit,R.drawable.status_court_circuit);
        MiseAJour miseAJour = new MiseAJour(R.string.statusMise_a_jour,R.drawable.status_mis_a_jour);
        Humide humide = new Humide(R.string.statusHumide,R.drawable.status_humidite);

        /* Création des attaques */
        Mouvement pistolet_a_eau = new Mouvement(20,R.string.attaquePistolet_a_eau,consoleP, humide);
        Mouvement rapidite = new Mouvement(20,R.string.attaqueRapidite,linux,null);
        Mouvement decharge = new Mouvement(0,R.string.attaqueDecharge,nokia, courtCircuit);
        Mouvement charge = new Mouvement(9,R.string.attaqueCharge,nokia,null);
        Mouvement batterie = new Mouvement(15,R.string.attaqueBatterie,smartphone,courtCircuit);
        Mouvement trempette = new Mouvement(0,R.string.attaqueTrempette,smartphone,null);
        Mouvement mise_a_jour = new Mouvement(10,R.string.attaqueMise_a_jour,linux, miseAJour);
        Mouvement depense = new Mouvement(10,R.string.attaqueDepense,apple,null);
        Mouvement siri = new Mouvement(12,R.string.attaqueSiri,mac,null);
        Mouvement sabotage = new Mouvement(11,R.string.attaqueSabotage,mac,null);
        Mouvement confort = new Mouvement(10,R.string.attaqueConfort,consoleS,null);
        Mouvement stabilite = new Mouvement(5,R.string.attaqueStabilité,windows,null);
        Mouvement vague_psy = new Mouvement(10,R.string.attaqueVague_Psy,windows,null);


        Mouvement lanceEau = new Mouvement(30,R.string.attaqueLance_eau,consoleP, humide);
        Mouvement pied_saute = new Mouvement(21,R.string.attaquePied_saute,consoleP,null);
        Mouvement rapide2 = new Mouvement(30,R.string.attaqueSuper_Rapidite,linux,null);
        Mouvement petitVoltage = new Mouvement(15,R.string.attaquePetit_voltage,nokia, courtCircuit);
        Mouvement superBatterie = new Mouvement(25,R.string.attaqueSuper_batterie,smartphone,null);
        Mouvement mise_a_jour2 = new Mouvement(20,R.string.attaqueMise_a_jour_2,linux, miseAJour);
        Mouvement onereuse = new Mouvement(15,R.string.attaqueDepense_onereuse,apple,null);
        Mouvement superSiri = new Mouvement(22,R.string.Super_Siri,mac,null);
        Mouvement superConfort = new Mouvement(20,R.string.attaqueSuper_Confort,consoleS,null);
        Mouvement belier = new Mouvement(20,R.string.attaqueBelier,consoleS,null);
        Mouvement superSatble = new Mouvement(10,R.string.attaqueSuper_Satibilite,windows,null);



        Mouvement tsunami = new Mouvement(40,R.string.attaqueTsunami,consoleP, humide);
        Mouvement tempeteRapide = new Mouvement(40,R.string.attaqueTempete_de_rapidite,linux,null);
        Mouvement volt = new Mouvement(25,R.string.attaque1000_volt,nokia, courtCircuit);
        Mouvement megaBatterie = new Mouvement(25,R.string.attaqueMega_Batterie,smartphone,null);
        Mouvement miseAjour3 = new Mouvement(25,R.string.attaqueMega_mise_a_jour,linux, miseAJour);
        Mouvement ruine = new Mouvement(30,R.string.attaqueRuine,apple,null);
        Mouvement giga_impact = new Mouvement(40,R.string.attaqueGiga_Impact,apple,null);
        Mouvement megaSiri = new Mouvement(30,R.string.attaqMega_Siri,mac,null);
        Mouvement megaConfort = new Mouvement(30,R.string.attaqueMega_confort,consoleS,null);
        Mouvement megaStable = new Mouvement(30,R.string.attaqueMega_Stabilite,windows,null);



        //Création des stater
        Mouvement[] tabMouvements=new Mouvement[]{rapidite, rapide2, tempeteRapide, mise_a_jour};
        Entite e = new Entite(R.string.nomPC,R.drawable.ordi,70,25,30,30,position, linux,tabMouvements,1,0,R.string.nomLinux, true);
        niveau1.add(e);
        e = new Entite(R.string.nomLinux,R.drawable.linux,100,45,35,40,position, linux,tabMouvements,2,0,R.string.nomSuper_linux, true);
        niveau2.add(e);
        e = new Entite(R.string.nomSuper_linux,R.drawable.linux_evolution,150,60,50,40,position, linux,tabMouvements,3,0,0, true);
        niveau3.add(e);
        tabMouvements=new Mouvement[]{pistolet_a_eau, lanceEau, tsunami, pied_saute };
        e = new Entite(R.string.nomConsole,R.drawable.console,70,30,20,15,position, consoleP,tabMouvements,1,0,R.string.nomGame_Boy_Color, true);
        niveau1.add(e);
        e = new Entite(R.string.nomGame_Boy_Color,R.drawable.console_p,100,50,30,25,position, consoleP,tabMouvements,2,0,R.string.nomDS3, true);
        niveau2.add(e);
        e = new Entite(R.string.nomDS3,R.drawable.console_p_evolution,150,70,50,40,position, consoleP,tabMouvements,3,0,0, true);
        niveau3.add(e);
        tabMouvements=new Mouvement[]{batterie, superBatterie, megaBatterie, trempette};
        e = new Entite(R.string.nomTelephone,R.drawable.tel,70,25,25,20,position, smartphone,tabMouvements,1,0,R.string.nomNokia_Evolution, true);
        niveau1.add(e);
        e = new Entite(R.string.nomNokia_Evolution,R.drawable.tel,100,40,50,20,position, smartphone,tabMouvements,2,0,R.string.nomIphone6, true);
        niveau2.add(e);
        e = new Entite(R.string.nomIphone6,R.drawable.tel,150,60,60,40,position, smartphone,tabMouvements,2,0,0, true);
        niveau3.add(e);

        //Création des ennemis
        //niveau 1
        tabMouvements=new Mouvement[]{charge, decharge, volt, petitVoltage };
        e = new Entite(R.string.nomNokia_3310,R.drawable.nokia,50,10,20,10,position, nokia,tabMouvements,1,0,0, false);
        niveau1.add(e);
        tabMouvements=new Mouvement[]{sabotage, siri, superSiri, megaSiri };
        e = new Entite(R.string.nomMacbook,R.drawable.mac,20,25,15,15,position, mac,tabMouvements,1,0,0, false);
        niveau1.add(e);
        tabMouvements=new Mouvement[]{vague_psy, stabilite, superSatble, megaStable };
        e = new Entite(R.string.nomWindows_1_0,R.drawable.windows,20,15,15,10,position, windows,tabMouvements,1,0,0, false);
        niveau1.add(e);

        //niveau 2
        tabMouvements=new Mouvement[]{belier, confort, superConfort, megaConfort };
        e = new Entite(R.string.nomPS1,R.drawable.console_s,80,35,25,20,position, consoleS,tabMouvements,2,0,0, false);
        niveau2.add(e);
        tabMouvements=new Mouvement[]{ giga_impact, ruine, depense, onereuse };
        e = new Entite(R.string.nomIphone,R.drawable.apple,80,30,35,25,position, apple,tabMouvements,2,0,0, false);
        niveau2.add(e);
        tabMouvements=new Mouvement[]{batterie, superBatterie, megaBatterie, trempette };
        e = new Entite(R.string.nomIBM_Simon,R.drawable.smartphone,80,35,30,25,position, smartphone,tabMouvements,2,0,0, false);
        niveau2.add(e);

        //niveau 3
        tabMouvements=new Mouvement[]{tempeteRapide,rapide2, rapidite, miseAjour3 };
        e = new Entite(R.string.nomSuper_Windows,R.drawable.windows_evolution,100,50,35,35,position, windows,tabMouvements,3,0,0, false);
        niveau3.add(e);
        tabMouvements=new Mouvement[]{pistolet_a_eau, lanceEau, tsunami, pied_saute };
        e = new Entite(R.string.nomPS5,R.drawable.console_s_evolution,100,50,45,35,position, consoleP,tabMouvements,3,0,0, false);
        niveau3.add(e);
        tabMouvements=new Mouvement[]{batterie, superBatterie, megaBatterie, trempette };
        e = new Entite(R.string.nomSamsung,R.drawable.smartphone_evolution,100,45,40,35,position, smartphone,tabMouvements,3,0,0, false);
        niveau3.add(e);


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
