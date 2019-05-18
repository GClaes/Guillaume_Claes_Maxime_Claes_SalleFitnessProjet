package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdresseTest {

    @Test
    public void doitProduireLeMemeHashSiAttributAvecMajuscules() {
        Adresse adresse1 = new Adresse("Hondelange", "6780", "Emile-Kirsch", "29");
        Adresse adresse2 = new Adresse("HoNdElAnGe", "6780", "EMILE-kirsch", "29");
        assertEquals(adresse2.getCode(), adresse1.getCode());
    }

}