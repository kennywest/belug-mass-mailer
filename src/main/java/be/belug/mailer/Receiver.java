package be.belug.mailer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Receiver {

    @JsonProperty("name")
    private final String name;

    @JsonProperty("email")
    private final String email;

    public Receiver(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
