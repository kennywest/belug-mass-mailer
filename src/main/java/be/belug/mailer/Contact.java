package be.belug.mailer;

public class Contact {

    public final String voornaam;
    public final String naam;
    public final String email;
    public final String language;

    public Contact(String voornaam, String naam, String email, String language) {
        this.voornaam = voornaam;
        this.naam = naam;
        this.email = email;
        this.language = language;
    }

    public Receiver getReceiver() {
        return new Receiver(voornaam + " " + naam, email);
    }

    public boolean isDutch() {
        return "NL".equals(language);
    }

    public boolean isFrench() {
        return "FR".equals(language);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "voornaam='" + voornaam + '\'' +
                ", naam='" + naam + '\'' +
                ", email='" + email + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
