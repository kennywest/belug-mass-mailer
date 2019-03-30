package be.belug.mailer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Diner {

    @JsonProperty("aantal")
    private final int aantal;

    @JsonProperty("type")
    private final String type;

    private final double totaal;

    public Diner(int aantal, String type, double prijs) {
        this.aantal = aantal;
        this.type = type;
        this.totaal = prijs * aantal;
    }

    @JsonIgnore
    public double getTotaal() {
        return this.totaal;
    }

    @Override
    public String toString() {
        return "Diner{" +
                "aantal=" + aantal +
                ", type='" + type + '\'' +
                ", totaal=" + totaal +
                '}';
    }
}
