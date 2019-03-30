package be.belug.mailer;

import java.util.List;

public class PriceCalculator {

    public static double calculatePrice(List<Broodje> broodjes, List<Diner> diners) {
        double totaalBroodjes = broodjes.stream().map(Broodje::getPrijs).reduce(0d, Double::sum);
        double totaalAvondEten = diners.stream().map(Diner::getTotaal).reduce(0d, Double::sum);

        return totaalBroodjes + totaalAvondEten;
    }
}
