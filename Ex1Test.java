package assignments.ex1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v, 11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);
        assertTrue(Ex1.equals(s10, s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (int i = 0; i < not_good.length; i = i + 1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }

    @Test
    void int2NumberTest() {
        assertEquals("11b2", Ex1.int2Number(3, 2));// 3 in base 2 is 11
        assertEquals("FFbG", Ex1.int2Number(255, 16)); // 255 in base 16 is FF
        assertEquals("400b5", Ex1.int2Number(100, 5)); // 100 in base 5 is 400
        assertEquals("0b2", Ex1.int2Number(0, 2));

        assertEquals("", Ex1.int2Number(-1, 10)); // Negative number
        assertEquals("", Ex1.int2Number(10, 20)); // Invalid base
        assertEquals("", Ex1.int2Number(10, 1)); // Invalid base
        assertEquals("", Ex1.int2Number(10, 17)); // Ba

    }

    @Test
    void maxIndexTest() {
        String[] arr1 = {"101b2", "11b10", "AAbG", "FFb16"};
        assertEquals(2, Ex1.maxIndex(arr1)); // "AAbG" (value 255) is the largest

        String[] arr2 = {"1b2", "0b2", "10bA", "F0bG"};
        assertEquals(3, Ex1.maxIndex(arr2)); // "F0bG" (value 240) is the largest

        // Test for null and invalid numbers
        String[] arr3 = {"123b5", null, "XYZbA", "15b2"};
        assertEquals(0, Ex1.maxIndex(arr3)); // "123b5" (value 38) is the largest

        String[] arr4 = {null, "invalid", "-1b3", "1b2"};
        assertEquals(3, Ex1.maxIndex(arr4)); // "1b2" is the only valid number

        // Test for empty array (edge case)
        String[] arr5 = {};
        // Cannot call maxIndex on an empty array (assumed non-empty based on the problem description)

    }

    @Test
    void equalsTest() {
        // Test for equal values
        assertTrue(Ex1.equals("1011b2", "11b10")); // Binary and decimal
        assertTrue(Ex1.equals("AAbG", "255b16"));  // Hexadecimal comparison

        // Test for unequal values
        assertFalse(Ex1.equals("123bA", "456b10")); // Different numbers

        // Test for invalid inputs
        assertFalse(Ex1.equals("123b", null)); // Invalid input
        assertFalse(Ex1.equals("123bA", "XYZbG")); // Both invalid

        // Edge case: Same value but different formats
        assertTrue(Ex1.equals("0b2", "0b10")); // Both represent 0
    }



    @Test
    void number2IntTest() {
        // Test for valid numbers
        assertEquals(11, Ex1.number2Int("1011b2")); // Binary: 1011 -> 11
        assertEquals(255, Ex1.number2Int("FFb16")); // Hexadecimal: FF -> 255
        assertEquals(100, Ex1.number2Int("400b5")); // Base 5: 400 -> 100
        assertEquals(12, Ex1.number2Int("12")); // No 'b', defaults to base 10

        // Test for invalid numbers
        assertEquals(-1, Ex1.number2Int("XYZbA")); // Invalid format
        assertEquals(-1, Ex1.number2Int(null)); // Null input
        assertEquals(-1, Ex1.number2Int("123")); // Missing base specifier
        assertEquals(-1, Ex1.number2Int("")); // Empty string
        assertEquals(-1, Ex1.number2Int("b2")); // No number part
    }


}
