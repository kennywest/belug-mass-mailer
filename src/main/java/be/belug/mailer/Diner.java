package be.belug.mailer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Diner {

    @JsonProperty("aantal")
    private final int aantal;

    @JsonProperty("type")
    private final String type;

    public Diner(int aantal, String type) {
        this.aantal = aantal;
        this.type = type;
    }
}
