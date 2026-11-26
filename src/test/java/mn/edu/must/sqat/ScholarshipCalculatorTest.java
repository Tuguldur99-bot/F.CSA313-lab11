package mn.edu.must.sqat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ScholarshipCalculatorTest {

    ScholarshipCalculator calc;

    @BeforeEach
    void setUp() { calc = new ScholarshipCalculator(); }

    // ===== B1: assertions made exact (same inputs as the starter, exact expected values) =====

    @Test
    void letterGrade_midRangeScores_returnExactLetters() {
        assertEquals("A", calc.letterGrade(95));
        assertEquals("B", calc.letterGrade(85));
        assertEquals("C", calc.letterGrade(75));
        assertEquals("D", calc.letterGrade(65));
        assertEquals("F", calc.letterGrade(30));
    }

    @Test
    void letterGrade_invalidInputs_throw() {
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(-1));
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(101));
    }

    @Test
    void gpa_returnsExactAverages() {
        assertEquals(3.5, calc.gpa(new double[]{95, 85}), 0.0001);
        assertEquals(1.5, calc.gpa(new double[]{75, 65}), 0.0001);
        assertEquals(0.0, calc.gpa(new double[]{40}), 0.0001);
    }

    @Test
    void gpa_invalidInputs_throw() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(null));
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(new double[]{}));
    }

    @Test
    void scholarship_returnsExactPercents() {
        assertEquals(100, calc.scholarship(3.9, 16, false));
        assertEquals(70, calc.scholarship(3.5, 13, false));
        assertEquals(50, calc.scholarship(3.1, 5, false));
        assertEquals(0, calc.scholarship(2.0, 1, false));
        assertEquals(0, calc.scholarship(4.0, 20, true));
    }

    @Test
    void scholarship_invalidInputs_throw() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(4.1, 10, false));
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(3.0, -1, false));
    }

    // ===== B2: boundary-value tests =====

    @ParameterizedTest(name = "letterGrade({0}) = {1}")
    @CsvSource({
            "100,   A",
            "90,    A",
            "89.99, B",
            "80,    B",
            "79.99, C",
            "70,    C",
            "69.99, D",
            "60,    D",
            "59.99, F",
            "0,     F"
    })
    void letterGrade_boundaries_returnExactLetter(double score, String expected) {
        assertEquals(expected, calc.letterGrade(score));
    }

    @Test
    void letterGrade_justOutsideRange_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(-0.01));
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(100.01));
    }

    @ParameterizedTest(name = "gpa([{0}]) = {1}")
    @CsvSource({
            "95, 4.0",
            "85, 3.0",
            "75, 2.0",
            "65, 1.0",
            "30, 0.0"
    })
    void gpa_singleGrade_returnsGradePoints(double score, double expected) {
        assertEquals(expected, calc.gpa(new double[]{score}), 0.0001);
    }

    @Test
    void gpa_allFiveLetters_averageIs2() {
        assertEquals(2.0, calc.gpa(new double[]{95, 85, 75, 65, 30}), 0.0001);
    }

    @ParameterizedTest(name = "scholarship({0}, {1}, {2}) = {3}")
    @CsvSource({
            "3.8,  15, false, 100",
            "3.8,  14, false, 70",
            "3.79, 15, false, 70",
            "3.4,  12, false, 70",
            "3.4,  11, false, 50",
            "3.39, 12, false, 50",
            "3.0,  0,  false, 50",
            "2.99, 20, false, 0",
            "0.0,  0,  false, 0",
            "4.0,  20, false, 100",
            "3.9,  0,  false, 50",
            "3.9,  16, true,  0"
    })
    void scholarship_boundaries_returnExactPercent(double gpa, int credits, boolean violation, int expected) {
        assertEquals(expected, calc.scholarship(gpa, credits, violation));
    }

    @Test
    void scholarship_justOutsideRange_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(-0.01, 10, false));
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(4.01, 10, false));
    }
}
