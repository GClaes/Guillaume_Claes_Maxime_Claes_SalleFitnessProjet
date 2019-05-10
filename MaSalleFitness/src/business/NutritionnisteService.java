package business;

import model.Nutritionniste;

import java.util.List;

public interface NutritionnisteService {
    List<Nutritionniste> listingNutritionnistes();
    List<Nutritionniste> nutritionnistesDesCandidatsEntrainesParUnCoach(int coachMatricule);
}
