package be.belug.mailer;


import java.util.List;

import static be.belug.mailer.Utils.parseInt;

public class PariticipantsParser {

    public static Pariticipants parse(List<Object> row) {
        boolean participates = parseInt(row.get(33)) > 0;

        if (participates) {
            return new Pariticipants(parseInt(row.get(34)) + parseInt(row.get(35)) + parseInt(row.get(36)) + parseInt(row.get(37)));
        }

        return new Pariticipants(0);
    }
}
