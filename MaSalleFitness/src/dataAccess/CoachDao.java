package dataAccess;

import model.Coach;

import java.util.ArrayList;

public interface CoachDao {
    ArrayList<Coach> listingCoach() throws Exception;
}
