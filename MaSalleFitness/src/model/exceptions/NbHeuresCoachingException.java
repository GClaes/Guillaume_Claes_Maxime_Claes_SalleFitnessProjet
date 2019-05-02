package model.exceptions;

public class NbHeuresCoachingException extends IllegalArgumentException {
    private Integer nbHeuresCoachingErrone;

    public NbHeuresCoachingException(Integer nbHeuresCoachingErrone) {
        this.nbHeuresCoachingErrone = nbHeuresCoachingErrone;
    }

    @Override
    public String getMessage() {
        return "Le nombre d'heure de coaching est errone et vaut " + nbHeuresCoachingErrone;
    }
}
