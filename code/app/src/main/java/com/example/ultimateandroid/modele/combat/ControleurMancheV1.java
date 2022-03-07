package com.example.ultimateandroid.modele.combat;

import com.example.ultimateandroid.modele.entite.CollectionEntite;
import com.example.ultimateandroid.modele.entite.Mouvement;
import com.example.ultimateandroid.modele.entite.Entite;


/**
 * Classe gérant le contrôle d'une manche
 */
public class ControleurMancheV1 extends ControleurManche {

    /**
     * Constructeur
     * @param pokedex : La collection d'entité utile au contrôleur niveau
     */
    public ControleurMancheV1(CollectionEntite pokedex){
        iaEntite = new IAEntiteFacile();
        controleurNiveau = new ControleurNiveau(pokedex);
        attaqueur = new AttaqueurEntite();
    }

    @Override
    public int effectuerCombat(Entite allie, Entite ennemi, Mouvement mAllie) {
        Mouvement mEnnemi = iaEntite.choisirAttaque(ennemi);
            if(allie.getVitesse() >= ennemi.getVitesse()){ //si l'entité du joueur est plus rapide
                if(attaqueur.attaquer(allie,ennemi,mAllie)) {
                    controleurNiveau.gagnerExperience(allie, ennemi); //On lui fait gagner de l'expérience
                    return 1; //l'entité ennemi est ko
                }
                else{
                    if(attaqueur.attaquer(ennemi,allie,mEnnemi)) {
                        return 2; //l'entité du joueur est ko
                    }
                }
            }
            else{ //si l'entité ennemi est plus rapide
                if(attaqueur.attaquer(ennemi,allie,mEnnemi)) {
                    return 2; //l'entité du joueur est ko
                }
                else{
                    if(attaqueur.attaquer(allie,ennemi,mAllie)) {
                        controleurNiveau.gagnerExperience(allie, ennemi); //On lui fait gagner de l'expérience
                        return 1; //l'entité ennemi est ko
                    }
                }
            }
            //On applique le comportement des états de l'entité si aucun n'est ko
            allie.appliquerEtat();
            ennemi.appliquerEtat();
            return 0; //aucune entité n'est ko
        }
}
