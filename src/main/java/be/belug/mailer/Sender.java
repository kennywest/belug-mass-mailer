package be.belug.mailer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sender {

    @JsonProperty("name")
    private final String name;

    @JsonProperty("email")
    private final String email;

    public Sender() {
        this.name = "Brick Mania Wetteren";
        this.email = "wetteren@belug.be";
    }
}
