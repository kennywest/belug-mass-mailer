package be.belug.mailer;

import java.util.List;

import static be.belug.mailer.Utils.parseBool;
import static be.belug.mailer.Utils.parseDouble;
import static be.belug.mailer.Utils.parseInt;
import static com.google.api.client.util.Lists.newArrayList;

public class DetailParser {

    private static final String VERKOOP_NL = "Verkoop: ";
    private static final String VERKOOP_FR = "Vente: ";
    private static final String STROOM_NL = "Stroom";
    private static final String STROOM_FR = "Courant";
    private static final String VRIJWILLIGER_NL = "Vrijwilliger";
    private static final String VRIJWILLIGER_FR = "Bénévole";
    private static final String VERKOOP_DESCR_NL = "Vergeet je afrokdoeken niet";
    private static final String VERKOOP_DESCR_FR = "N'oubliez pas vos nappes";
    private static final String EXPOSITIERUIMTE_NL = "expositieruimte";
    private static final String EXPOSITIERUIMTE_FR = "espace d'exposition";
    private static final String EXPO_DESCR_NL = VERKOOP_DESCR_NL;
    private static final String EXPO_DESCR_FR = VERKOOP_DESCR_FR;
    private static final String STROOM_DESCR_NL = "Vergeet je verlengkabel niet";
    private static final String STROOM_DESCR_FR = "N'oubliez pas vos allonges";
    private static final String VRIJWILLIGER_DESCR_NL = "Je krijgt een taakverdeling bij aanvang beurs";
    private static final String VRIJWILLIGER_DESCR_FR = "Une tâche vous sera attribuée en début d'expo";

    public static List<Detail> parse(List<Object> row) {
        Language language = LanguageParser.parse(row);

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
            details.add(new Detail(language.translated(VERKOOP_NL, VERKOOP_FR) + sellLengthInM + "m", language.translated(VERKOOP_DESCR_NL, VERKOOP_DESCR_FR)));
        }

        if (exhibitor) {
            details.add(new Detail(exLengthInCm + "cm x " + exWidthInCm + "cm (" + exSurfaceInCm2 + "m2) " + language.translated(EXPOSITIERUIMTE_NL, EXPOSITIERUIMTE_FR), language.translated(EXPO_DESCR_NL, EXPO_DESCR_FR)));
        }

        if (elek) {
            details.add(new Detail(language.translated(STROOM_NL, STROOM_FR), language.translated(STROOM_DESCR_NL, STROOM_DESCR_FR)));
        }

        if (volunteer) {
            details.add(new Detail(language.translated(VRIJWILLIGER_NL, VRIJWILLIGER_FR), language.translated(VRIJWILLIGER_DESCR_NL, VRIJWILLIGER_DESCR_FR)));
        }
        return details;
    }
}
