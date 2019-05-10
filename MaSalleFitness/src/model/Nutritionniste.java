package model;

public class Nutritionniste extends Personne {
    private Integer numReference;
    private String avis;

    public Nutritionniste(Integer numReference, String nom, String prenom, String avis) {
        super(nom, prenom);
        this.numReference = numReference;
        this.avis = avis;
    }



    public Integer getNumReference() {
        return numReference;
    }

    public String getAvis() {
        return avis;
    }

}
