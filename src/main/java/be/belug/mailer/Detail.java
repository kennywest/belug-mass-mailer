package be.belug.mailer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Detail {

    @JsonProperty("expositieruimte")
    private final String expositieruimte;

    @JsonProperty("comment")
    private final String comment;

    public Detail(String expositieruimte, String comment) {
        this.expositieruimte = expositieruimte;
        this.comment = comment;
    }
}
