package business;

import model.Nutritionniste;

import java.util.ArrayList;

public interface NutritionnisteService {
    ArrayList<Nutritionniste> listingNutritionnistes();
    ArrayList<Nutritionniste> nutritionnistesDesCandidatsEntrainesParUnCoach(int coachMatricule);
}
