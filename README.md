# Ex1 - Number Format Converter and Calculator

## Description
This project implements a number formatting converter and calculator as defined in the assignment requirements. It allows converting numbers between different bases (binary to hexadecimal) and performs operations like equality checking, validation, and more.

## How to Run
1. Clone the repository from GitHub.
2. Open the project in IntelliJ IDEA or your preferred IDE.
3. Run the main program using `Ex1Main.java`.
4. To test, execute the JUnit tests in `Ex1Test.java`.

## Features
- Conversion between bases (2-16).
- Number validation.
- Equality checking for numbers in different bases.
- Find the largest number in an array of formatted strings.

## Example Usage
Example:
- Input: `"1011b2"`
  - Output: `11` (Decimal)

- Input: `255` (Decimal) → Convert to Hexadecimal
  - Output: `"FFb16"`

## JUnit Tests
Comprehensive JUnit tests are included in `Ex1Test.java` to verify:
- Conversion accuracy (e.g., `int2Number` and `number2Int`).
- Validity of number formats (`isNumber`).
- Equality of numbers in different formats (`equals`).
- Finding the largest number in an array (`maxIndex`).

## GitHub Repository
[Your Repository Link]

## Deadline and Acknowledgment
This project was completed as part of the course assignment and submitted before the deadline (12/12/2024).
