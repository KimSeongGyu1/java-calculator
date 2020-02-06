package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CalculatorTest {
    Calculator tester = new Calculator();

    @Test
    void testGivenString() {
        String givenSample = "2 + 3 * 4 / 2";
        Assertions.assertThat(tester.calculate(givenSample)).isEqualTo(10);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/result.csv", numLinesToSkip = 1)
    void testCalculator(String input, String expected) {
        Assertions.assertThat(tester.calculate(input)).isEqualTo(Integer.parseInt(expected));
    }
}
