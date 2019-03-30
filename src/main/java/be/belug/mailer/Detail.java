package be.belug.mailer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Detail {

    @JsonProperty("wat")
    private final String wat;

    @JsonProperty("comment")
    private final String comment;

    public Detail(String wat, String comment) {
        this.wat = wat;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "wat='" + wat + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
