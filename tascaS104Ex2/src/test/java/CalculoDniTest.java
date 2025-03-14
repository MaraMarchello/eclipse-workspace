import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

public class CalculoDniTest {
    private final CalculoDni calculoDni = new CalculoDni();

    @ParameterizedTest
    @MethodSource("provideDniTestCases")
    void testDniLetterCalculation(int number, char expectedLetter) {
        assertEquals(expectedLetter, calculoDni.calculateLetter(number));
    }

    private static Stream<Arguments> provideDniTestCases() {
        return Stream.of(
            Arguments.of(12345678, 'Z'),
            Arguments.of(11111111, 'H'),
            Arguments.of(22222222, 'J'),
            Arguments.of(33333333, 'P'),
            Arguments.of(44444444, 'A'),
            Arguments.of(55555555, 'K'),
            Arguments.of(66666666, 'Q'),
            Arguments.of(77777777, 'B'),
            Arguments.of(88888888, 'Y'),
            Arguments.of(99999999, 'R')
        );
    }

    @Test
    void testInvalidDniNumber() {
        assertThrows(IllegalArgumentException.class, () -> calculoDni.calculateLetter(-1));
    }

    @ParameterizedTest
    @MethodSource("provideValidationTestCases")
    void testDniValidation(String completeDni, boolean expectedResult) {
        assertEquals(expectedResult, calculoDni.validateDni(completeDni));
    }

    private static Stream<Arguments> provideValidationTestCases() {
        return Stream.of(
            Arguments.of("12345678Z", true),
            Arguments.of("11111111H", true),
            Arguments.of("12345678X", false),  
            Arguments.of("1234567", false),    
            Arguments.of("123456789Z", false), 
            Arguments.of(null, false),         
            Arguments.of("ABCDEFGHZ", false)   
        );
    }
}
