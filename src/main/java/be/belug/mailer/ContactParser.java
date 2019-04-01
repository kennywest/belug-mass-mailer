package be.belug.mailer;

import java.util.List;
import java.util.Objects;

public class ContactParser {

    public static Contact parse(List<Object> row) {
        return new Contact(Objects.toString(row.get(1)),
                Objects.toString(row.get(2)),
                Objects.toString(row.get(3)),
                LanguageParser.parse(row));
    }
}
