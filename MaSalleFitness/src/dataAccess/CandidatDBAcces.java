package dataAccess;

import dataAccess.exceptions.ConnectionException;
import model.Candidat;

import java.sql.*;

public class CandidatDBAcces implements CandidatDataAccess {
    public void ajoutCandidat(Candidat candidat) throws ConnectionException {
        Connection connection = SingletonConnection.getInstance();      //A mettre dans le main
        String instructionSQL = "...";

    }
}
