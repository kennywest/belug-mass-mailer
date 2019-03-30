package be.belug.mailer;

public class Contact {

    public final String voornaam;
    public final String naam;
    public final String email;

    public Contact(String voornaam, String naam, String email) {
        this.voornaam = voornaam;
        this.naam = naam;
        this.email = email;
    }

    public Receiver getReceiver() {
        return new Receiver(voornaam + " " + naam, email);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "voornaam='" + voornaam + '\'' +
                ", naam='" + naam + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
