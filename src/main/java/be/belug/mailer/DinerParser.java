package be.belug.mailer;

import java.util.List;

import static be.belug.mailer.Utils.parseInt;
import static com.google.common.collect.Lists.newArrayList;

public class DinerParser {

    public static final double PRIJS_VOLW = 25;
    public static final double PRIJS_KIND = 12.50d;

    public static List<Diner> parse(List<Object> row) {
        List<Diner> diners = newArrayList();

        boolean participates = parseInt(row.get(33)) > 0;

        if (participates) {
            int adultStoofVlees = parseInt(row.get(34));
            int adultFrikaDellen = parseInt(row.get(35));
            int adultVeggie = parseInt(row.get(36));
            int kidsFrikaDellen = parseInt(row.get(37));

            if (adultStoofVlees > 0) {
                diners.add(new Diner(adultStoofVlees, "Stoofvlees", PRIJS_VOLW));
            }

            if (adultFrikaDellen > 0) {
                diners.add(new Diner(adultFrikaDellen, "Frikadellen", PRIJS_VOLW));
            }

            if (adultVeggie > 0) {
                diners.add(new Diner(adultVeggie, "Vegetarisch", PRIJS_VOLW));
            }

            if (kidsFrikaDellen > 0) {
                diners.add(new Diner(kidsFrikaDellen, "Frikadellen", PRIJS_KIND));
            }
        }

        return diners;
    }
}
