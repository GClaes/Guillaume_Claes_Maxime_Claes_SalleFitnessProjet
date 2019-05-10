package model;

public class Responsable extends Personne {
    private Integer numeroTravailleur;

    public Responsable(Integer numeroTravailleur, String nom, String prenom) {
        super(nom, prenom);
        this.numeroTravailleur = numeroTravailleur;
    }

    public Integer getNumeroTravailleur() {
        return numeroTravailleur;
    }

}
