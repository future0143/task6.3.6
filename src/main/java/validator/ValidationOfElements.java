package validator;

import org.junit.jupiter.api.Assertions;

public class ValidationOfElements {

    public static void validateTitle(String titleExpected, String titleActual) {
        Assertions.assertEquals(titleExpected, titleActual);
    }
}