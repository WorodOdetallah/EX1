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

        if (result.isEmpty()) { // More concise than result.length() == 0
            result.append('0');
        }

        char baseChar = base > 10 ? (char) ('A' + base - 10) : (char) ('0' + base);
        ans = result + "b" + baseChar; // No unnecessary .toString() call
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
