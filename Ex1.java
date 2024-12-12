package assignments.ex1;
/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hex.
 * [2-16], 10-16 are represented by A,B,...G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6” , "012b5", “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     */



    /**
    an explanation for myself .... 
 * Converts a formatted number string to its decimal (base-10) equivalent.
 * 
 * @param num A string in the format "<number>b<base>".
 *            Example: "1011b2" (binary), "FFb16" (hexadecimal).
 * @return The decimal value of the number, or -1 if the input is invalid.
 * 
 * Assumptions:
 * - Input format is "<number>b<base>" where:
 *   - <number> is a string of digits or letters valid in the given base.
 *   - <base> is a digit (2-16) or a single letter (A-G) representing bases 10-16.
 * 
 * Edge Cases:
 * - Null or empty input: returns -1.
 * - Invalid format (e.g., "123b", "b16"): returns -1.
 * - Valid input but invalid digits for the base: returns -1.
 * 
 * Example:
 * - Input: "1011b2" → Output: 11
 * - Input: "FFb16" → Output: 255
 * - Input: "123bA" → Output: 123 (base-10 by default)
 */

    public static int number2Int(String num) {
        int ans = -1;

        // Validate the input
        if (num == null || !isNumber(num)) {
            return ans;
        }

        try {
            int bIndex = num.indexOf('b');
            String numberPart = num.substring(0, bIndex);
            String basePart = num.substring(bIndex + 1);

            // Parse the base
            int base = basePart.length() == 1
                    ? Character.isDigit(basePart.charAt(0))
                    ? Integer.parseInt(basePart)
                    : basePart.charAt(0) - 'A' + 10
                    : Integer.parseInt(basePart, 16);

            // Convert the number part to an integer
            ans = Integer.parseInt(numberPart, base);
        } catch (Exception e) {
            ans = -1; // Catch any unexpected parsing errors
        }

        return ans;
    }


    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */

    /**
 * Checks if a string is a valid formatted number in any base [2-16].
 * 
 * @param a The string to check.
 *          Example: "1011b2" (binary), "123bA" (base-10), "EFbG" (base-16).
 * @return True if the string is valid, false otherwise.
 * 
 * Validation Rules:
 * - The string must contain a base identifier ('b') separating the number and base.
 * - The base must be in the range [2,16], represented as a digit (2-9) or a letter (A-G).
 * - The number must only use digits or letters valid for the given base.
 * 
 * Edge Cases:
 * - Null or empty input: returns false.
 * - Invalid base (e.g., "b1", "b17"): returns false.
 * - Invalid characters for the base (e.g., "10b2", "Gh2"): returns false.
 * 
 * Example:
 * - Input: "1011b2" → Output: true
 * - Input: "0bA" → Output: true
 * - Input: "1234b11" → Output: false (invalid base)
 */

    public static boolean isNumber(String a) {
        boolean ans = true;

        if (a == null || a.isEmpty()) {
            return false;
        }

        int bIndex = a.indexOf('b');
        if (bIndex == -1) { // No 'b', assume base 10
            for (char c : a.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            return true;
        }

        // Handle the case with 'b'
        if (bIndex <= 0 || bIndex == a.length() - 1) {
            return false; // 'b' at invalid positions
        }

        String numberPart = a.substring(0, bIndex);
        String basePart = a.substring(bIndex + 1);

        try {
            int base = basePart.length() == 1
                    ? (Character.isDigit(basePart.charAt(0))
                    ? basePart.charAt(0) - '0'
                    : basePart.charAt(0) - 'A' + 10)
                    : Integer.parseInt(basePart, 16);

            if (base < 2 || base > 16) {
                return false;
            }

            for (char c : numberPart.toCharArray()) {
                if (Character.digit(c, base) == -1) {
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            return false; // Parsing failed
        }

        return ans;
    }



    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     *
     * @param num  the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */


// Example usage of int2Number:
// Input: num = 11, base = 2
// Output: "1011b2" (binary representation of 11)

    public static String int2Number(int num, int base) {
        String ans = ""; // Default to empty for invalid cases
        if (num < 0 || base < 2 || base > 16) {
            return ans;
        }

        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int digit = num % base;
            result.insert(0, digit < 10 ? (char) ('0' + digit) : (char) ('A' + digit - 10));
            num /= base;
        }

        if (result.isEmpty()) { 
            result.append('0');
        }

        char baseChar = base > 10 ? (char) ('A' + base - 10) : (char) ('0' + base);
        ans = result + "b" + baseChar; 
        return ans;
    }




    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        if (n1 == null || n2 == null || !isNumber(n1) || !isNumber(n2)) {
            return false;
        }
        ans = number2Int(n1) == number2Int(n2);
        return ans;
    }


    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     *
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     */
    public static int maxIndex(String[] arr) {
        int ans = 0; // Default index
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && isNumber(arr[i])) {
                int value = number2Int(arr[i]);
                if (value > maxValue) {
                    maxValue = value;
                    ans = i;
                }
            }
        }
        return ans;
    }
}
