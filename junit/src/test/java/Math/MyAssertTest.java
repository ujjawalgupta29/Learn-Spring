package Math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class MyAssertTest {
    List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");
    @Test
    void test() {
        boolean test = todos.contains("AWS");

        Assertions.assertEquals(true, test);
        Assertions.assertTrue(test);

        Assertions.assertEquals(3, todos.size());
    }
}
