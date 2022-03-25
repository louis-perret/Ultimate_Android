package com.example.ultimateandroid.modele.combat;

import com.example.ultimateandroid.modele.entite.CollectionEntite;
import com.example.ultimateandroid.modele.entite.Entite;
import com.example.ultimateandroid.modele.entite.Mouvement;
import com.example.ultimateandroid.modele.joueur.Joueur;

import java.util.Collection;
import java.util.List;


/**
 * Classe qui gère les combats et les vagues
 */
public class ControleurCombat {

    private ControleurManche controleurManche;
    private Entite ennemiCourant; //entité qu'affronte le joueur
    private int numeroVague = 1; //numéro de la vague
    private List<Entite> listeEntiteByVague; //liste des entités ennemi de la vague

    /**
     * Constructeur
     * @param encylopedie : Collection de nos entités
     */
    public ControleurCombat(CollectionEntite encylopedie) {
        this.controleurManche = new ControleurMancheV1(encylopedie);
    }

    /**
     * Gère un tour de combat entre deux entités
     * @param allie : entité du joueur
     * @param mAllie : l'attaque utilisée par l'entité du joueur
     */
    public int tourDeCombat(Entite allie, Mouvement mAllie, Joueur joueur, CollectionEntite pokedex){
        int resultat = controleurManche.effectuerCombat(allie,ennemiCourant,mAllie);
        if(resultat == 1){ //l'entité ennemi est ko
            listeEntiteByVague.remove(0); //on l'enlève de la liste des entités ennemis
            if(!listeEntiteByVague.isEmpty()){ //s'il reste des entités à combattre
                ennemiCourant = listeEntiteByVague.get(0); //on envoie le prochain au casse-pipe
                return 1;
            }
            else{ //sinon la vague est finie
                if(numeroVague == 3){
                    numeroVague=1;
                    joueur.incrementerScore(); //on incrémente son nombre de victoires
                    return 4; //la partie est finie et le joueur a gagné
                }
                allie.setPv(pokedex.getEntite(allie.getNom(),allie.getNiveau()).getPv()); //on le soigne
                numeroVague++;
                return 3;
            }
        }
        else{
            if(resultat == 2){
                numeroVague=1;
                return 2; //l'entité du joueur est ko
            }
        }
        return 0; //aucune entité n'est ko
    }

    /**
     * Gère les vagues d'entité ennemi du jeu
     * @return une liste de 3 entités que devra combattre le joueur
     */

    public boolean lancerVague(Entite allie,Joueur joueur, CollectionEntite pokedex){
        if(numeroVague>3){ //Le joueur a gagné toutes les vagues
            joueur.incrementerScore();
            return true;//Pour prévenir qu'il n'y a plus d'entité à combattre
        }
        listeEntiteByVague=pokedex.getListeEntite(numeroVague,3, allie);  //Sinon on renvoie les entités de la vague d'après
        ennemiCourant=listeEntiteByVague.get(0);
        return false;
    }

    public Entite getEnnemiCourant() {
        return ennemiCourant;
    }


}
