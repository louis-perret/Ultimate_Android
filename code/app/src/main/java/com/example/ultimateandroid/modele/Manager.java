package com.example.ultimateandroid.modele;

import com.example.ultimateandroid.modele.boucle.BoucleJeu;
import com.example.ultimateandroid.modele.boucle.BoucleJeu16;
import com.example.ultimateandroid.modele.combat.ControleurManche;
import com.example.ultimateandroid.modele.deplacement.DeplaceurEntite;
import com.example.ultimateandroid.modele.deplacement.DeplaceurEntiteSimple;
import com.example.ultimateandroid.modele.joueur.Joueur;
import com.example.ultimateandroid.modele.monde.Carte;
import com.example.ultimateandroid.modele.monde.Monde;
import com.example.ultimateandroid.modele.monde.Tuile;
import com.example.ultimateandroid.modele.observateurs.Observateur;
import com.example.ultimateandroid.modele.entite.CollectionEntite;
import com.example.ultimateandroid.modele.entite.Entite;
import com.example.ultimateandroid.modele.entite.Position;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Classe qui gère toutes les fonctionnalités du jeu
 */
public class Manager implements Serializable {

    private transient DeplaceurEntite deplaceur; //pour le déplacement
    private transient ControleurManche controleurManche; //pour les combats

    private transient Entite entiteCourant; //l'entité choisie par l'utilisateur
    private transient Entite entiteEnnemiCourant; //entité qu'affronte le joueur
    private transient int numeroVague = 1; //numéro de la vague
    private transient List<Entite> listeEntiteByVague; //liste des entités ennemi de la vague

    private transient Carte carteCourante; //la carte actuellement affichée
    private Monde monde; //notre monde
    private CollectionEntite pokedex; //collection des entités
    private int nbVictoires; //nombre de victoires du joueur
    private Map<Integer, Tuile> dicoTuiles; //dictionnaire contenant toutes les types de tuiles de nos cartes (pour le sauvegarder)
    private transient Thread thread; //thread de la boucle de jeu
    private static final long serialVersionUID = 1815847098800356785L; //pour la sérialisation
    private transient int hauteurSurfaceJeu;
    private transient int largeurSurfaceJeu;

    private List<Joueur> lesJoueurs; //faire une array
    private Joueur joueurCourant;

    /**
     * Constructeur
     * @param collectionEntite : collection des entités
     * @param dicoTuiles : type de tuiles
     */
    public Manager(CollectionEntite collectionEntite, Map<Integer, Tuile>dicoTuiles, List<Joueur> lesJoueurs){
        this.deplaceur = new DeplaceurEntiteSimple(hauteurSurfaceJeu,largeurSurfaceJeu,Tuile.getTuileHauteur());
        this.pokedex= collectionEntite;
        //this.controleurCombat = new ControleurCombatV1(collectionEntite);
        this.dicoTuiles=dicoTuiles;
        this.monde=new Monde();
        this.lesJoueurs = lesJoueurs;
    }

    /**
     * Gère un tour de combat entre deux entités
     * @param allie : entité du joueur
     * @param ennemi : entité ennemi
     * @param mAllie : l'attaque utilisée par l'entité du joueur
     */
    /*
    public int tourDeCombat(Entite allie, Entite ennemi, Mouvement mAllie){
        int resultat = controleurCombat.effectuerCombat(allie,ennemi,mAllie);
        if(resultat == 1){ //l'entité ennemi est ko
            listeEntiteByVague.remove(0); //on l'enlève de la liste des entités ennemis
            if(!listeEntiteByVague.isEmpty()){ //s'il reste des entités à combattre
                setEntiteEnnemiCourant(listeEntiteByVague.get(0)); //on envoie le prochain au casse-pipe
                return 1;
            }
            else{ //sinon la vague est finie
                if(numeroVague == 3){
                    numeroVague=1;
                    setNbVictoires(getNbVictoires()+1); //on incrémente son nombre de victoires
                    return 4; //la partie est finie et le joueur a gagné
                }
                entitieCourant.setPv(pokedex.getEntite(entiteCourant.getNom(),entiteCourant.getNiveau()).getPv()); //on le soigne
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
    }*/

    /**
     * Gère le déplacement d'une entité vers le portail
     */
    public void deplacerEntite(){
        if(deplaceur == null){
            deplaceur = new DeplaceurEntiteSimple(hauteurSurfaceJeu,largeurSurfaceJeu,Tuile.getTuileHauteur());
        }
        deplaceur.deplacer(entiteCourant,carteCourante);
    }

    /**
     * Lance la boucle de jeu utile au déplacement d'une entité du joueur
     */

    public void lancerBoucleJeu(List<Observateur> observateurs){
        entiteCourant.setPosition(new Position(carteCourante.getSpawnX(),carteCourante.getSpawnY())); //on set sa position au point de spawn de la carte avant de commencer à le déplacer
        BoucleJeu boucleJeu = new BoucleJeu16();
        for(Observateur o : observateurs){
            boucleJeu.addObservateur(o);
        }
        thread = new Thread(boucleJeu);
        thread.start(); //On lance le thread qui contient la boucle
    }

    /**
     * Arrête le thread de la boucle de jeu
     */
    public void terminerBoucleJeu(){
        thread.interrupt();
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Problème dans l'arrêt de la boucle de jeu");
        }
    }

    /**
     * Gère les vagues d'entité ennemi du jeu
     * @return une liste de 3 entités que devra combattre le joueur
     */
    /*
    public boolean lancerVague(){
        if(numeroVague>3){ //Le joueur a gagné toutes les vagues
            setNbVictoires(getNbVictoires()+1);
            return true;//Pour prévenir qu'il n'y a plus d'entité à combattre
        }
        listeEntiteByVague=pokedex.getListeEntite(numeroVague,3, entiteCourant);  //Sinon on renvoie les entités de la vague d'après
        entiteEnnemiCourant=listeEntiteByVague.get(0);
        return false;
    }*/

    public List<Entite> getStarterslvl1() {
        return pokedex.getStarterLvl1();
    }

    //Getter et setter
    public Entite getEntiteCourant() {
        return entiteCourant;
    }

    public void setEntiteCourant(Entite entiteCourant) {
        //On clone l'entité pour éviter qu'il pointe vers la même référence et ainsi éviter qu'il modifie directement l'entité contenu dans le pokedex
        this.entiteCourant = entiteCourant.cloner();
    }

    public Entite getEntiteEnnemiCourant() {
        return entiteEnnemiCourant;
    }

    public void setEntiteEnnemiCourant(Entite entite) {
        entiteEnnemiCourant.setNom(entite.getNom());
        entiteEnnemiCourant.setPv(entite.getPv());
        entiteEnnemiCourant.setImageCombat(entite.getImageCombat());
        entiteEnnemiCourant.setImage(entite.getImage());
        entiteEnnemiCourant.setMouvements(entite.getMouvements());
        entiteEnnemiCourant.setEtat(entite.getEtat());
        entiteEnnemiCourant.setVitesse(entite.getVitesse());
        entiteEnnemiCourant.setAttaque((entite.getAttaque()));
        entiteEnnemiCourant.setDefense(entite.getDefense());
        entiteEnnemiCourant.setType(entite.getType());
    }

    public Carte getCarteCourante() {
        if(carteCourante == null){
            this.setCarteCourante("lobby");
        }
        return carteCourante;
    }

    public void ajouterCarte(String nomCarte, InputStream fichier){
        if(monde == null){
            monde = new Monde();
        }
        monde.ajouterCarte(nomCarte,fichier,dicoTuiles);
    }

    public void setCarteCourante(String nomCarte) {
        this.carteCourante = monde.getCarte(nomCarte);
    }

    public Monde getMonde() {
        return monde;
    }

    public CollectionEntite getPokedex() {
        return pokedex;
    }

    public void setNumeroVague(int numeroVague) { this.numeroVague=numeroVague; }

    public List<Joueur> getLesJoueurs() {
        return lesJoueurs;
    }

    public Joueur getJoueurCourant() {
        return joueurCourant;
    }
}
