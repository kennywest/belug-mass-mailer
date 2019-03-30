package be.belug.mailer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Broodje {

    @JsonProperty("dag")
    private final String dag;

    @JsonProperty("aantal")
    private final int aantal;

    @JsonProperty("type")
    private final String type;

    private final double prijs;

    public Broodje(String dag, int aantal, String type, double prijs) {
        this.dag = dag;
        this.aantal = aantal;
        this.type = type;
        this.prijs = prijs;
    }

    @JsonIgnore
    public double getPrijs() {
        return this.prijs;
    }

    @Override
    public String toString() {
        return "Broodje{" +
                "dag='" + dag + '\'' +
                ", aantal=" + aantal +
                ", type='" + type + '\'' +
                ", prijs=" + prijs +
                '}';
    }
}
