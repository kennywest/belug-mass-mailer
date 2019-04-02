package be.belug.mailer;

import java.util.List;

import static be.belug.mailer.Utils.parseInt;
import static com.google.common.collect.Lists.newArrayList;

public class DinerParser {

    private static final double PRIJS_VOLW = 25;
    private static final double PRIJS_KIND = 12.50d;
    private static final String STOOFVLEES_NL = "Stoofvlees";
    private static final String STOOFVLEES_FR = "Carbonade flamande";
    private static final String FRIKADELLEN_VOLW_NL = "Frikadellen (volwassene)";
    private static final String FRIKADELLEN_VOLW_FR = "Fricadelles (adulte)";
    private static final String VEGETARISCH_NL = "Vegetarisch";
    private static final String VEGETARISCH_FR = "Végétarien";
    private static final String FRIKADELLEN_KIND_NL = "Frikadellen (kind)";
    private static final String FRIKADELLEN_KIND_FR = "Fricadelles (enfant)";

    public static List<Diner> parse(List<Object> row) {
        Language language = LanguageParser.parse(row);

        List<Diner> diners = newArrayList();

        boolean participates = parseInt(row.get(33)) > 0;

        if (participates) {
            int adultStoofVlees = parseInt(row.get(34));
            int adultFrikaDellen = parseInt(row.get(35));
            int adultVeggie = parseInt(row.get(36));
            int kidsFrikaDellen = parseInt(row.get(37));

            if (adultStoofVlees > 0) {
                diners.add(new Diner(adultStoofVlees, language.translated(STOOFVLEES_NL, STOOFVLEES_FR), PRIJS_VOLW));
            }

            if (adultFrikaDellen > 0) {
                diners.add(new Diner(adultFrikaDellen, language.translated(FRIKADELLEN_VOLW_NL, FRIKADELLEN_VOLW_FR), PRIJS_VOLW));
            }

            if (adultVeggie > 0) {
                diners.add(new Diner(adultVeggie, language.translated(VEGETARISCH_NL, VEGETARISCH_FR), PRIJS_VOLW));
            }

            if (kidsFrikaDellen > 0) {
                diners.add(new Diner(kidsFrikaDellen, language.translated(FRIKADELLEN_KIND_NL, FRIKADELLEN_KIND_FR), PRIJS_KIND));
            }
        }

        return diners;
    }
}
