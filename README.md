🚀 Ex1 - Number Format Converter and Calculator

📜 Description

This project implements a number formatting converter and calculator that supports conversions between bases (binary to hexadecimal) and provides features such as equality checking, number validation, and finding the largest number in an array.

⚙️ Features

🔄 Base Conversion: Convert numbers between bases 2 (binary) to 16 (hexadecimal).
✅ Number Validation: Verify if a string follows the correct number format.
🟰 Equality Checking: Check if two numbers in different bases represent the same value.
📊 Find Largest Number: Identify the largest number in an array of formatted strings.
🚀 How to Run

📥 Clone the Repository
git clone https://github.com/WorodOdetallah/EX1.git
🖥️ Open in IntelliJ IDEA
Open IntelliJ IDEA (or your preferred IDE).
Import the project.
▶️ Run the Program
Run the main program using Ex1Main.java.
To test the implementation, execute the JUnit tests in Ex1Test.java.
🧪 Tests

Extensive JUnit tests are included to ensure accuracy:

Validation Tests (isNumber): Check if numbers follow the correct format.
Conversion Tests (int2Number, number2Int): Verify proper conversions between bases.
Equality Tests (equals): Validate if two numbers in different formats are equal.
Array Tests (maxIndex): Find the largest number in an array.
#Example:

assertEquals(11, Ex1.number2Int("1011b2")); // Binary to Decimal
assertTrue(Ex1.equals("FFb16", "255b10")); // Hexadecimal to Decimal Equality
assertFalse(Ex1.isNumber("123b")); // Invalid format

📚 Example Usage
// Input: Binary "1011b2"
System.out.println(Ex1.number2Int("1011b2")); 
// Output: 11 (Decimal)

// Input: Decimal 255 -> Convert to Hexadecimal
System.out.println(Ex1.int2Number(255, 16)); 
// Output: "FFb16"
📂 Repository

🔗 GitHub Repository

⏳ Deadline and Acknowledgment

This project was completed as part of a course assignment and submitted before the deadline (12/12/2024).

