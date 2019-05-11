import dataAccess.*;
import dataAccess.impl.NutritionnisteDaoImpl;
import model.Nutritionniste;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        if (!Pattern.matches("^[a-zA-Z]+[ \\-']?[[a-zA-Z]+[ \\-']?]*[a-zA-Z]+$", "Gesve1s")) {
            System.out.println("Erreur");
        } else {
            System.out.println("OK");
        }

    }

}
