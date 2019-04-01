package be.belug.mailer;

import java.util.List;
import java.util.Objects;

public class LanguageParser {

    public static Language parse(List<Object> row) {
        return new Language(Objects.toString(row.get(4)));
    }
}
