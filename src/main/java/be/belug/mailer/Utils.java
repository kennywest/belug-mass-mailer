package be.belug.mailer;

import java.util.Objects;

public final class Utils {

    private Utils() {
    }

    public static int parseInt(Object o) {
        return Integer.parseInt("0" + Objects.toString(o));
    }

    public static double parseDouble(Object o) {
        return Double.parseDouble("0" + Objects.toString(o));
    }

    public static boolean parseBool(Object o) {
        return "JA".equalsIgnoreCase(Objects.toString(o));
    }
}
