import dataAccess.*;
import dataAccess.impl.NutritionnisteDaoImpl;
import model.Nutritionniste;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        if (!Pattern.matches("[^a-z,A-Z]", "Gesves")) {
            System.out.println("Erreur");
        } else {
            System.out.println("OK");
        }

    }

}
