package Math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

    private MyMath math = new MyMath();

    @Test
    void calculateSum() {
        int[] numbers = {1, 2, 3};
        int calculatedSum = math.calculateSum(numbers);
        Assertions.assertEquals(6, calculatedSum);
    }

    @Test
    void calculateZeroSum() {
        int[] numbers = {};
        int calculatedSum = math.calculateSum(numbers);
        Assertions.assertEquals(0, calculatedSum);
    }
}