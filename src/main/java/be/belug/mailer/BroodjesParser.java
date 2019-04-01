package be.belug.mailer;

import java.util.List;

import static be.belug.mailer.Utils.parseInt;
import static com.google.common.collect.Lists.newArrayList;

public class BroodjesParser {

    private static final double PRIJS_BROODJE = 2.5;
    private static final String ZATERDAG_NL = "Zaterdag";
    private static final String ZATERDAG_FR = "Samedi";
    private static final String ZONDAG_NL = "Zondag";
    private static final String ZONDAG_FR = "Dimanche";
    private static final String KAAS_NL = "Kaas";
    private static final String KAAS_FR = "Fromage";
    private static final String KAAS_HESP_NL = "Kaas & Hesp";
    private static final String KAAS_HESP_FR = "Jambon/Fromage";
    private static final String PREPARE_NL = "Préparé";
    private static final String PREPARE_FR = "Américain préparé";

    public static List<Broodje> parse(List<Object> row) {
        Language language = LanguageParser.parse(row);

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
            broodjes.add(new Broodje(language.translated(ZATERDAG_NL, ZATERDAG_FR), cheeseSat, language.translated(KAAS_NL, KAAS_FR), (cheeseSat - positiveValueOf(freeBroodjesSat--)) * PRIJS_BROODJE));
        }
        if (hamCheeseSat > 0) {
            broodjes.add(new Broodje(language.translated(ZATERDAG_NL, ZATERDAG_FR), hamCheeseSat, language.translated(KAAS_HESP_NL, KAAS_HESP_FR), (hamCheeseSat - positiveValueOf(freeBroodjesSat--)) * PRIJS_BROODJE));
        }
        if (prepareSat > 0) {
            broodjes.add(new Broodje(language.translated(ZATERDAG_NL, ZATERDAG_FR), prepareSat, language.translated(PREPARE_NL, PREPARE_FR), (prepareSat - positiveValueOf(freeBroodjesSat)) * PRIJS_BROODJE));
        }
        if (cheeseSun > 0) {
            broodjes.add(new Broodje(language.translated(ZONDAG_NL, ZONDAG_FR), cheeseSun, language.translated(KAAS_NL, KAAS_FR), (cheeseSun - positiveValueOf(freeBroodjesSun--)) * PRIJS_BROODJE));
        }
        if (hamCheeseSun > 0) {
            broodjes.add(new Broodje(language.translated(ZONDAG_NL, ZONDAG_FR), hamCheeseSun, language.translated(KAAS_HESP_NL, KAAS_HESP_FR), (hamCheeseSun - positiveValueOf(freeBroodjesSun--)) * PRIJS_BROODJE));
        }
        if (prepareSun > 0) {
            broodjes.add(new Broodje(language.translated(ZONDAG_NL, ZONDAG_FR), prepareSun, language.translated(PREPARE_NL, PREPARE_FR), (prepareSun - positiveValueOf(freeBroodjesSun)) * PRIJS_BROODJE));
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
