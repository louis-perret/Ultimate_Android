package com.example.ultimateandroid.modele.entite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Classe qui stocke tous les entités
 */
public class CollectionEntite implements Serializable {

    private Map<Integer, List<Entite>> pokedex; //On stocke les entités suivant leur niveau

    /**
     * Constructeur
     * @param niveau1 : Collection des entités de niveau 1
     * @param niveau2 : Collection des entités de niveau 2
     * @param niveau3 : Collection des entités de niveau 3
     */
    public CollectionEntite(List<Entite> niveau1, List<Entite> niveau2, List<Entite> niveau3){
        pokedex= new HashMap<>();
        pokedex.put(1,niveau1);
        pokedex.put(2,niveau2);
        pokedex.put(3,niveau3);
    }

    /**
     * Récupérer une entité en fonction de son nom et de son niveau
     * @param nom : nom de l'entité à récupérer
     * @param niveau : niveau de l'entité à récupérer
     * @return une entité
     */
    public Entite getEntite(String nom, int niveau){
        List<Entite> ens = pokedex.get(niveau);
        Entite entiteRecherche =null;
        for(Entite p : ens){
            if(p.getNom().equals((nom))){
                entiteRecherche =p;
            }
        }
        return entiteRecherche;
    }

    /**
     * Retourne une liste des entités starter
     * @return une liste de l'entité
     */
    public List<Entite> getStarterLvl1(){
        List<Entite> niv1 = pokedex.get(1); //On récupère la liste des entités de niveau 1
        List<Entite> listeStarterNiv1 = new ArrayList<Entite>();
        for (Entite p : niv1){
            if(p.getStarter()){ //Si c'est un starter
                listeStarterNiv1.add(p); //On l'ajoute à la liste
            }
        }
        return listeStarterNiv1;
    }


    /**
     * Renvoie une liste de n entité par rapport au numéro de la vague
     * @param numeroVague : numéro de la vague (correspond au niveau des entités ennemis)
     * @param nbEntiteByVague : nombre de l'entité à renvoyer
     * @param courant : entité de l'utilisateur
     * @return Une liste de n entité à affronter
     */
    public List<Entite> getListeEntite(int numeroVague, int nbEntiteByVague, Entite courant) {
        List<Entite> listeEntite = new ArrayList<>();
        Random random = new Random();
        Entite p;
        while(listeEntite.size()<nbEntiteByVague){
            p=pokedex.get(numeroVague).get(random.nextInt(pokedex.get(numeroVague).size()));
            if(!listeEntite.contains(p) && !p.getStarter()) { //Si l'entité n'a pas déjà été pris et si ce n'est pas un starter
                listeEntite.add(p.cloner()); //On l'ajoute à la liste
            }
        }
        return listeEntite;
    }


    /**
     * Affiche l'instance sous forme de chaîne de caractères
     * @return un string
     */
    @Override
    public String toString(){
        String res="";
        Set<Map.Entry<Integer,List<Entite>>> ens = pokedex.entrySet();
        for(Map.Entry<Integer,List<Entite>> dico : ens){
            res+= "Niveau " + dico.getKey() + " : ";
            for(Entite p : dico.getValue()){
                res+= p.getNom() + ", ";
            }
            res+= "\n";
        }
        return res;
    }

}
