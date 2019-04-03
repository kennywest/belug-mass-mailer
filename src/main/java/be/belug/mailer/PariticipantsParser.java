package be.belug.mailer;


import java.util.List;

import static be.belug.mailer.Utils.parseInt;

public class PariticipantsParser {

    public static Pariticipants parse(List<Object> row) {
        return new Pariticipants(parseInt(row.get(33)));
    }
}
