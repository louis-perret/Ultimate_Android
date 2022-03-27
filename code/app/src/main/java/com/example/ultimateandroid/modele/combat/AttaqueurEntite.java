package com.example.ultimateandroid.modele.combat;

import static java.lang.Math.ceil;

import com.example.ultimateandroid.modele.entite.Mouvement;
import com.example.ultimateandroid.modele.entite.Entite;

/**
 * Cette classe permet de gérer l'attaque d'une entité vers un autre
 */
public class AttaqueurEntite extends Attaqueur{

    public AttaqueurEntite(){
        calculCoefficient = new CalculCoefficientV1();
    }
    /**
     * Gère l'attaque d'une entité vers une autre
     * @param attaquant : entité attaquant
     * @param attaque : entité attaquée
     * @param m : l'attaque utilisée
     * @return True si l'entité attaquant a gagné le combat
     */
    @Override
    public boolean attaquer(Entite attaquant, Entite attaque, Mouvement m) {
        //calculé en prenant en compte l'attaque de l'attaquant, les dégats du mouvement, puis le type de l'attaque utilisée ainsi que la défense de l'attaqué
        int degat = (int)ceil((attaquant.getAttaque()/100.0+1)*m.getDegats()*calculCoefficient.getCoefficient(m.getType(),attaque
                .getType())*(1-attaque.getDefense()/100.0));
        attaque.setPv(attaque.getPv()-degat); //Actualise ses pv
        m.comportement(attaque); //Effectue le comportement de l'attaque
        if(attaque.getPv()<=0){ //Si l'adversaire est ko
            return true;
        }
        return false;
    }
}
