package Math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

    @Test
    void calculateSum() {
        int[] numbers = {1, 2, 3};
        MyMath math = new MyMath();
        int calculatedSum = math.calculateSum(numbers);
        Assertions.assertEquals(6, calculatedSum);
    }
}