package org.example;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class Main {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    @Test
    public void testIsEven() {
        assertTrue(isEven(4));
        assertTrue(isEven(10));
    }
}

