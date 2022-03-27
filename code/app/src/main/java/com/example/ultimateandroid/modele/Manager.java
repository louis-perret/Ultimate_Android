package com.example.ultimateandroid.modele;

import com.example.ultimateandroid.modele.boucle.BoucleJeu;
import com.example.ultimateandroid.modele.boucle.BoucleJeu16;
import com.example.ultimateandroid.modele.combat.ControleurCombat;
import com.example.ultimateandroid.modele.deplacement.DeplaceurEntite;
import com.example.ultimateandroid.modele.deplacement.DeplaceurEntiteSimple;
import com.example.ultimateandroid.modele.entite.Mouvement;
import com.example.ultimateandroid.modele.joueur.Joueur;
import com.example.ultimateandroid.modele.monde.Carte;
import com.example.ultimateandroid.modele.monde.Monde;
import com.example.ultimateandroid.modele.observateurs.Observateur;
import com.example.ultimateandroid.modele.entite.Entite;
import com.example.ultimateandroid.modele.entite.Position;

import java.io.InputStream;
import java.util.List;

/**
 * Classe qui gère toutes les fonctionnalités du jeu
 */
public class Manager {

    private boolean debutCombat; //vrai si un combat s'est lancé
    private Joueur joueurCourant; //joueur qui joue
    private Entite allie; //l'entité choisie par l'utilisateur
    private Carte carteCourante; //la carte actuellement affichée
    private Banque banque;

    private DeplaceurEntite deplaceur; //pour le déplacement
    private ControleurCombat controleurCombat; //pour les combats
    private Monde monde; //notre monde
    private Thread thread; //thread de la boucle de jeu


    /**
     * Constructeur
      * @param banque : attribut contenant les collections de l'application
     */
    public Manager(Banque banque){
        deplaceur = new DeplaceurEntiteSimple(10);
        controleurCombat = new ControleurCombat(banque.getEncyclopedie());
        monde = new Monde();
        this.banque = banque;
        debutCombat = false;
        joueurCourant = new Joueur("", 0);
    }


    /**
     * Gère le déplacement d'une entité vers le portail
     */
    public void deplacerEntite(){
        debutCombat = deplaceur.deplacer(allie,carteCourante);
    }

    /**
     * Gère un tour de combat entre deux entités
     * @param mAllie : l'attaque utilisée par l'entité du joueur
     */
    public int tourDeCombat(Mouvement mAllie){
        return controleurCombat.tourDeCombat(allie,mAllie,joueurCourant,banque.getEncyclopedie());
    }

    /**
     * Lance une nouvelle vague dans le jeu
     * @return
     */
    public boolean lancerCombat(){
        return controleurCombat.lancerVague(allie,joueurCourant, banque.getEncyclopedie());
    }

    /**
     * Lance la boucle de jeu utile au déplacement d'une entité du joueur
     */
    public void lancerBoucleJeu(List<Observateur> observateurs){
        allie.setPosition(new Position(carteCourante.getSpawnX(), carteCourante.getSpawnY())); //on set sa position au point de spawn de la carte avant de commencer à le déplacer
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
    public void terminerBoucleJeu() {
        if (thread != null) {
            thread.interrupt();
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Problème dans l'arrêt de la boucle de jeu");
            }
        }
    }

    /**
     * Renvoie la liste des starters
     * @return Liste<Entite>
     */
    public List<Entite> getStarterslvl1() {
        return banque.getEncyclopedie().getStarterLvl1();
    }


    /**
     * Ajoute une carte à notre monde
     * @param nomCarte : nom de la carte à ajouter
     * @param fichier : flux de lecture vers le fichier qui contient notre carte
     */
    public void ajouterCarte(String nomCarte, InputStream fichier){
        if(monde == null){
            monde = new Monde();
        }
        monde.ajouterCarte(nomCarte,fichier);
    }

    /**
     * Permet de définir le joueur courant
     * @param pseudo: pseudo du joueur rentré par l'utilisateur
     */
    public void addJoueur(String pseudo){
        joueurCourant = banque.addJoueur(pseudo);
    }

    //Getter et setter
    public Entite getAllie() {
        return allie;
    }

    public void setAllie(int nom, int niveau) {
        //On clone l'entité pour éviter qu'il pointe vers la même référence et ainsi éviter qu'il modifie directement l'entité contenu dans le pokedex
        this.allie = banque.getEncyclopedie().getEntite(nom, niveau).cloner();
    }

    public Carte getCarteCourante() {
        if(carteCourante == null){
            this.setCarteCourante("lobby");
        }
        return carteCourante;
    }

    public boolean isDebutCombat(){
        return debutCombat;
    }

    public void setCarteCourante(String nomCarte) {
        this.carteCourante = monde.getCarte(nomCarte);
    }

    public Monde getMonde() {
        return monde;
    }

    public List<Entite> getStarter() {
        return banque.getEncyclopedie().getStarterLvl1();
    }

    public Joueur getJoueurCourant() {
        return joueurCourant;
    }

    public List<Joueur> getLesJoueurs(){
        return banque.getLesJoueurs();
    }

    public Entite getEnnemiCourant(){
        return controleurCombat.getEnnemiCourant();
    }

    public Banque getBanque() {
        return banque;
    }
}
