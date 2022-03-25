package com.example.ultimateandroid.modele.combat;

import com.example.ultimateandroid.modele.entite.CollectionEntite;
import com.example.ultimateandroid.modele.entite.Entite;

public class ControleurNiveau {

    private CollectionEntite collectionEntite; //la collection de tous les entités

    /**
     * Constructeur
     * @param collectionEntite : collection de tous les pokmon
     */
    public ControleurNiveau(CollectionEntite collectionEntite) {
        this.collectionEntite = collectionEntite;
    }

    /**
     * Augmente l'expérience de l'entité p en fonction du niveau de l'entité ennemi
     * @param allie : entité qui gagne de l'expérience
     * @param ennemi : l'entité ennemi
     */
    public void gagnerExperience(Entite allie, Entite ennemi){
        int xpGagne=0;
        int niveauEnnemi=ennemi.getNiveau();

        if(niveauEnnemi==1){
            xpGagne=35;
        }
        else{
            if(niveauEnnemi==2){
                xpGagne=40;
            }
            else{
                xpGagne=50;
            }
        }

        allie.setExperience(allie.getExperience()+xpGagne);
        if(allie.getExperience()>=100){ //S'il a atteint son expérience maximum
            if(allie.getNiveau()<3) { //S'il est pas au niveau maximum
                xpGagne = allie.getExperience() % 100;
                evoluer(allie, xpGagne); //On le fait évoluer
            }
            else{
                allie.setExperience(100); //Sinon on plafonne son expérience au maximum
            }
        }
    }

    /**
     * Fait évoluer une entité
     * @param allie : Entité à faire évoluer
     * @param experienceRestante : son expérience restante à rajouter après
     */
    public void evoluer(Entite allie, int experienceRestante){
        Entite pEvolue= collectionEntite.getEntite(allie.getEvolution(),allie.getNiveau()+1); //Récupère l'évolution de l'entité
        if(pEvolue == null){
            return; //de l'entité ne peut pas évoluer
        }
        //Modifie chacun de ses attributs par ceux de son évolution
        allie.setNom(pEvolue.getNom());
        allie.setNiveau(pEvolue.getNiveau());
        allie.setPv(pEvolue.getPv());
        allie.setEvolution(pEvolue.getEvolution());
        allie.setAttaque(pEvolue.getAttaque());
        allie.setDefense(pEvolue.getDefense());
        allie.setVitesse(pEvolue.getVitesse());
        allie.setImage(pEvolue.getImage());
        allie.setMouvements(pEvolue.getMouvements());
        allie.setExperience(experienceRestante);
    }
}
