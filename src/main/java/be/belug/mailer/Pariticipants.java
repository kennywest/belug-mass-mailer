package be.belug.mailer;

public class Pariticipants {

    public final int aantal;


    public Pariticipants(int aantal) {
        this.aantal = aantal;
    }

    @Override
    public String toString() {
        return "{" +
                "aantal=" + aantal +
                '}';
    }
}
