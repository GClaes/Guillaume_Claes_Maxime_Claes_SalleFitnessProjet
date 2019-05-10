package dataAccess;

import model.Nutritionniste;

import java.util.List;

public interface NutritionnisteDao {
    List<Nutritionniste> listingNutritionnistes();
    List<Nutritionniste> nutritionnistesDesCandidatsEntrainesParUnCoach(int coachMatricule);
}
