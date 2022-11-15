package junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SquareEquationTest {
    private SquareEquation squareEquation;
    private Roots roots;

    @ParameterizedTest
    @CsvSource({
            "1, 1, -6, -3, 2",
            "1, -10, 25, 5, 5",
            "1, -2, -3, -1, 3",
            "-1, -2, 15, 3, -5"
    })
    @DisplayName("Testing of the solution to quadratic equations")
    void solutionTest(double a, double b, double c, int x1, int x2) {
        squareEquation = new SquareEquation(a, b, c);
        roots = squareEquation.solution();
        assertEquals(x1, roots.x1);
        assertEquals(x2, roots.x2);
    }

    @ParameterizedTest
    @DisplayName("with exception")
    @CsvSource({
            "1, 2, 3"
    })
    void solutionTestExc(double a, double b, double c) {
        squareEquation = new SquareEquation(a, b, c);
        assertThrows(ArithmeticException.class, () -> squareEquation.solution());
    }
}