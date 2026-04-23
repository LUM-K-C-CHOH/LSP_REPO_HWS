package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GradeCalculatorTest {

    private final GradeCalculator calculator = new GradeCalculator();

    @Test
    void testAverageReturnsCorrectValue() {
        assertEquals(90.0, calculator.average(90, 90, 90));
    }

    @Test
    void testLetterGradeReturnsCorrectLetter() {
        assertEquals("B", calculator.letterGrade(85));
    }

    @Test
    void testIsPassingReturnsTrueForPassingAverage() {
        assertTrue(calculator.isPassing(60));
    }

    @Test
    void testBoundaryScoreZeroIsAllowed() {
        assertEquals(0.0, calculator.average(0, 0, 0));
    }

    @Test
    void testBoundaryScoreOneHundredIsAllowed() {
        assertEquals(100.0, calculator.average(100, 100, 100));
    }

    @Test
    void testAverageThrowsExceptionForNegativeScore() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.average(-1, 80, 90));
    }

    @Test
    void testAverageThrowsExceptionForScoreAboveOneHundred() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.average(101, 80, 90));
    }
}
