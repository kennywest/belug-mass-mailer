package be.belug.mailer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Broodje {

    @JsonProperty("dag")
    private final String dag;

    @JsonProperty("aantal")
    private final int aantal;

    @JsonProperty("type")
    private final String type;

    public Broodje(String dag, int aantal, String type) {
        this.dag = dag;
        this.aantal = aantal;
        this.type = type;
    }
}
