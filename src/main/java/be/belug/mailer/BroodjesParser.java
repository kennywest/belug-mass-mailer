package be.belug.mailer;

import java.util.List;

import static be.belug.mailer.Utils.parseInt;
import static com.google.common.collect.Lists.newArrayList;

public class BroodjesParser {

    public static final double PRIJS_BROODJE = 2.5;

    public static List<Broodje> parse(List<Object> row) {
        List<Broodje> broodjes = newArrayList();

        int cheeseSat = parseInt(row.get(27));
        int hamCheeseSat = parseInt(row.get(28));
        int prepareSat = parseInt(row.get(29));
        int freeBroodjesSat = 1;

        int cheeseSun = parseInt(row.get(30));
        int hamCheeseSun = parseInt(row.get(31));
        int prepareSun = parseInt(row.get(32));
        int freeBroodjesSun = 1;

        if (cheeseSat > 0) {
            broodjes.add(new Broodje("Zaterdag", cheeseSat, "Kaas", (cheeseSat - positiveValueOf(freeBroodjesSat--)) * PRIJS_BROODJE));
        }
        if (hamCheeseSat > 0) {
            broodjes.add(new Broodje("Zaterdag", hamCheeseSat, "Kaas & Hesp", (hamCheeseSat - positiveValueOf(freeBroodjesSat--)) * PRIJS_BROODJE));
        }
        if (prepareSat > 0) {
            broodjes.add(new Broodje("Zaterdag", prepareSat, "Préparé", (prepareSat - positiveValueOf(freeBroodjesSat)) * PRIJS_BROODJE));
        }
        if (cheeseSun > 0) {
            broodjes.add(new Broodje("Zondag", cheeseSun, "Kaas", (cheeseSun - positiveValueOf(freeBroodjesSun--)) * PRIJS_BROODJE));
        }
        if (hamCheeseSun > 0) {
            broodjes.add(new Broodje("Zondag", hamCheeseSun, "Kaas & Hesp", (hamCheeseSun - positiveValueOf(freeBroodjesSun--)) * PRIJS_BROODJE));
        }
        if (prepareSun > 0) {
            broodjes.add(new Broodje("Zondag", prepareSun, "Préparé", (prepareSun - positiveValueOf(freeBroodjesSun)) * PRIJS_BROODJE));
        }

        return broodjes;
    }

    private static int positiveValueOf(int value) {
        if (value >= 0) {
            return value;
        }

        return 0;
    }
}
