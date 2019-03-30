package be.belug.mailer;

import java.util.List;

import static be.belug.mailer.Utils.parseBool;
import static be.belug.mailer.Utils.parseDouble;
import static be.belug.mailer.Utils.parseInt;
import static com.google.api.client.util.Lists.newArrayList;

public class DetailParser {

    public static List<Detail> parse(List<Object> row) {
        List<Detail> details = newArrayList();

        boolean seller = parseInt(row.get(6)) > 0;
        boolean exhibitor = parseInt(row.get(5)) > 0;
        boolean volunteer = parseInt(row.get(7)) > 0;
        boolean elek = parseBool(row.get(25));
        int sellLengthInM = parseInt(row.get(20));
        double exLengthInCm = parseDouble(row.get(13));
        double exWidthInCm = parseDouble(row.get(14));
        double exSurfaceInCm2 = parseDouble(row.get(15));

        if (seller) {
            details.add(new Detail("Verkoop: " + sellLengthInM + "m", "Vergeet je afrokdoeken niet"));
        }

        if (exhibitor) {
            details.add(new Detail(exLengthInCm + "cm x" + exWidthInCm + "cm (" + exSurfaceInCm2 + "m2) expositieruimte", "Vergeet je afrokdoeken niet"));
        }

        if (elek) {
            details.add(new Detail("Stroom", "Vergeet je verlengkabel niet"));
        }

        if (volunteer) {
            details.add(new Detail("Vrijwilliger", "Je krijgt een taakverdeling bij aanvang beurs"));
        }
        return details;
    }
}
