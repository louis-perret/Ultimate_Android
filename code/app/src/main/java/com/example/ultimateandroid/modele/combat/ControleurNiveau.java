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
     * @param p : entité qui gagne de l'expérience
     * @param ennemi : l'entité ennemi
     */
    public void gagnerExperience(Entite p, Entite ennemi){
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

        p.setExperience(p.getExperience()+xpGagne);
        if(p.getExperience()>=100){ //S'il a atteint son expérience maximum
            if(p.getNiveau()<3) { //S'il est pas au niveau maximum
                xpGagne = p.getExperience() % 100;
                evoluer(p, xpGagne); //On le fait évoluer
            }
            else{
                p.setExperience(100); //Sinon on plafonne son expérience au maximum
            }
        }
    }

    /**
     * Fait évoluer une entité
     * @param p : Entité à faire évoluer
     * @param experienceRestante : son expérience restante à rajouter après
     */
    public void evoluer(Entite p, int experienceRestante){
        Entite pEvolue= collectionEntite.getEntite(p.getEvolution(),p.getNiveau()+1); //Récupère l'évolution de l'entité
        if(pEvolue == null){
            return; //de l'entité ne peut pas évoluer
        }
        //Modifie chacun de ses attributs par ceux de son évolution
        p.setNom(pEvolue.getNom());
        p.setNiveau(pEvolue.getNiveau());
        p.setPv(pEvolue.getPv());
        p.setEvolution(pEvolue.getEvolution());
        p.setAttaque(pEvolue.getAttaque());
        p.setDefense(pEvolue.getDefense());
        p.setVitesse(pEvolue.getVitesse());
        p.setImage(pEvolue.getImage());
        p.setMouvements(pEvolue.getMouvements());
        p.setImageCombat(pEvolue.getImageCombat());
        p.setExperience(experienceRestante);
    }
}
