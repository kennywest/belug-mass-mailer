package be.belug.mailer;

public class Language {

    public final String language;

    public Language(String language) {
        this.language = language;
    }

    public boolean isDutch() {
        return "NL".equals(language);
    }

    public boolean isFrench() {
        return "FR".equals(language);
    }

    public String translated(String nl, String fr) {
        if (isDutch()) {
            return nl;
        } else if (isFrench()) {
            return fr;
        }
        return nl;
    }

    @Override
    public String toString() {
        return language;
    }
}
