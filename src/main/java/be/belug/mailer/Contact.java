package be.belug.mailer;

public class Contact {

    public final String voornaam;
    public final String naam;
    public final String email;
    public final Language language;

    public Contact(String voornaam, String naam, String email, Language language) {
        this.voornaam = voornaam;
        this.naam = naam;
        this.email = email;
        this.language = language;
    }

    public Receiver getReceiver() {
        return new Receiver(voornaam + " " + naam, email);
    }

    public boolean isDutch() {
        return language.isDutch();
    }

    public boolean isFrench() {
        return language.isFrench();
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
