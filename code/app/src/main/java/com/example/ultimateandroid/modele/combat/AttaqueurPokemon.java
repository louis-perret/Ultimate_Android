package com.example.ultimateandroid.modele.combat;

import static java.lang.Math.ceil;

import com.example.ultimateandroid.modele.pokemon.Mouvement;
import com.example.ultimateandroid.modele.pokemon.Pokemon;

/**
 * Cette classe permet de gérer l'attaque d'un pokemon vers un autre
 */
public class AttaqueurPokemon implements Attaqueur{

    private CalculCoefficient calculCoefficient= new CalculCoefficientV1();

    /**
     * Gère l'attaque d'un pokemon vers un autre
     * @param attaquant : pokemon attaquant
     * @param attaque : pokepon attaqué
     * @param m : l'attaque utilisée
     * @return True si le pokemon attaquant a gagné le combat
     */
    @Override
    public boolean attaquer(Pokemon attaquant, Pokemon attaque, Mouvement m) {
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
