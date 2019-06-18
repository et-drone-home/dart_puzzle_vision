import static org.junit.Assert.*;

import org.junit.Test;

public class RpnCalculatorTest {

    @Test
    public void oneReturnOne() {
        int evaluatedPostfix = RpnCalculator.calculate("1");
        assertEquals(1, evaluatedPostfix);
    }

    @Test
    public void fiveReturnsFive() {
        int evaluatedPostfix = RpnCalculator.calculate("5");
        assertEquals(5, evaluatedPostfix);
    }

    @Test
    public void twentyAddsIntoTwoAndGivesMeTwentyTwo(){
        int evaluatedPostfix = RpnCalculator.calculate("20 2 +");
        assertEquals(22, evaluatedPostfix);
    }

    @Test
    public void oneHundredAndTwentyAddsIntoTwoAndGivesMeOneTwentyTwo(){
        int evaluatedPostfix = RpnCalculator.calculate("100 20 +");
        assertEquals(120, evaluatedPostfix);
    }

    @Test
    public void tenIsSubtractedFromTwoAndEightIsReturned(){
        int evaluatedPostfix = RpnCalculator.calculate("10 2 -");
        assertEquals(8, evaluatedPostfix);
    }

    @Test
    public void oneSubtractedFromTwoAndNEgativeOneIsReturned(){
        int evaluatedPostfix = RpnCalculator.calculate("1 2 -");
        assertEquals(-1, evaluatedPostfix);
    }

    @Test
    public void tenDividedByFiveIsTwo(){
        int evaluatedPostfix = RpnCalculator.calculate("10 5 /");
        assertEquals(2, evaluatedPostfix);
    }

    @Test
    public void multipleTwoNumbersGiveMeCorrectValue(){
        int evaluatedPostfix = RpnCalculator.calculate("10 5 *");
        assertEquals(50, evaluatedPostfix);
    }

    @Test
    public void tenIsDividedByTwoFirstAndThenMultipliedBySix(){
        int evaluatedPostfix = RpnCalculator.calculate("10 10 2 + +");
        assertEquals(50, evaluatedPostfix);
    }


}
