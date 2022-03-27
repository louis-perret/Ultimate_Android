package com.example.ultimateandroid.modele.entite;

import com.example.ultimateandroid.modele.entite.etat.Etat;

import java.io.Serializable;

public class Entite implements Serializable {

    private int nom; //son nom
    private int image; //son image de déplacement
    private int pv; //ses pv
    private int attaque; //ses points d'attaque
    private int defense; //ses points de défense
    private int vitesse; //ses points de vitesse

    private transient Position position; //ses coordonées
    private Type type; //son type
    private Mouvement[] mouvements; //contient ses 4 attaques
    private int niveau; //son niveau (1 au minimum)
    private int experience; //son expérience (0 au minimum)
    private int evolution; //contient le nom de son évolution
    private Boolean isStarter; //true si c'est un starter, false sinon
    private transient Etat etat; //état d'une entité


    /**
     * Constructeur de la classe
     * @param nom : son nom
     * @param image : son image
     * @param pv : ses points de vies
     * @param attaque : ses points d'attaque
     * @param defense : ses points de défence
     * @param vitesse : ses points de vitesse
     * @param niveau : son niveau
     * @param experience : son expérience
     * @param evolution : le nom de son évolution
     */
    public Entite(int nom, int image, int pv, int attaque, int defense, int vitesse, Position position, Type type, Mouvement[] tabMouvements, int niveau, int experience, int evolution, Boolean isStarter) {
        this.nom=nom;
        this.image = image;
        this.pv=pv;
        this.attaque = attaque;
        this.defense = defense;
        this.vitesse = vitesse;
        this.position = position;
        this.type = type;
        this.mouvements=tabMouvements;
        this.niveau=niveau;
        this.experience=experience;
        this.evolution=evolution;
        this.isStarter = isStarter;
        this.etat=null;
    }

    /**
     * Clone l'entité (Patron Prototype)
     * @return une Entite
     */
    public Entite cloner(){
        return new Entite(getNom(),getImage(),getPv(),getAttaque(),getDefense(),getVitesse(), getPosition(),getType(),getMouvements(),getNiveau(),getExperience(),getEvolution(),getStarter());
    }

    /**
     * Applique les effets de son états (Patron Etat)
     */
    public void appliquerEtat(){
        if(etat != null){ //s'il a un état
            etat.comportement(this); //on applique son comportement
        }
    }


    /* Getter et Setter */


    public int getNom() { return nom; }
    public void setNom(int nom) {
        this.nom=nom;
    }

    public int getPv(){ return pv; }
    public void setPv(int pv){
        if(pv <= 0){
            this.pv=0;
        }
        else{
            this.pv=pv;
        }
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getAttaque() {
        return attaque;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

   public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Mouvement[] getMouvements() {
        return mouvements;
    }

    public void setMouvements(Mouvement[] mouvements) {
        int i=0;
        for(Mouvement m : mouvements) {
            this.mouvements[i] = m;
            i=i+1;
        }
        this.mouvements=mouvements;
    }

    /**
     * Retourne sa technique par rapport à son nom
     * @param  : nom de l'attaque
     * @return un Mouvement
     */
   public Mouvement getMouvement(int nom){
        for (Mouvement m : mouvements){
            if(m.getNom() == nom){
                return m;
            }
        }
        return null; //pas trouvé
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getEvolution() {
        return evolution;
    }

    public void setEvolution(int evolution) {
        this.evolution = evolution;
    }

    public Boolean getStarter() {return isStarter;}

    public void setStarter(Boolean starter) {isStarter = starter;}

    public Etat getEtat(){
        return etat;
    }
    public void setEtat(Etat etat){
        this.etat=etat;
    }

    /**
     * Renvoie true si deux instances sont identiques (ici d'après leur nom)
     * @param o : objet à comparer
     * @return un booleen
     */
    @Override
    public boolean equals(Object o){
        if(o==null) return false;
        if(this==o) return true;
        if(this.getClass()!=o.getClass()) return false;

        Entite p=(Entite)o;
        if(getNom() == p.getNom()) return true;
        return false;
    }

    /**
     * Renvoie un hashCode unique pour une instance
     * @return un int
     */
    @Override
    public int hashCode(){
        int premier=13;
        int result=1;

        result=premier*result + nom;
        return result;
    }

    /**
     * Renvoie l'instance sous forme de chaîne de caractères
     * @return un string
     */
    @Override
    public String toString(){
        String res = "Entité : " + this.getNom() + " de type " + this.getType()  + ". A comme technique : ";
        for (Mouvement m : mouvements){
            res  += m.getNom();
        }
        return res;
    }
}
