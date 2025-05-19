package util;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Utlity {
    public static void main(String[] args) {
        int firstNameLength = 5;
        String randomFirstName = generateRandomFirstName();
        System.out.println("Random Capitalized First Name: " + randomFirstName);

        String randomLastName = generateRandomLastName();
        System.out.println("Random Capitalized Last Name: " + randomLastName);

        String dynamicEmail = generateDynamicEmail();
        System.out.println("Dynamic Email: " + dynamicEmail);

        String dynamicPhoneNumber = generateEgyptianPhoneNumber();
        System.out.println("Dynamic Egyptian Phone Number: " + dynamicPhoneNumber);

        String dynamicPassword = generateDynamicPassword();
        System.out.println("Dynamic Password: " + dynamicPassword);
    }

    public static String generateRandomFirstName() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        int length = 5; // Change the length if needed
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(letters.length());
            sb.append(letters.charAt(index));
        }

        return sb.substring(0, 1).toUpperCase() + sb.substring(1); // Capitalize the first letter
    }
    public static String generateUniqueUsername() {
        String lettersAndDigits = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // Letters and numbers
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // Adjust the length to 8 to allow space for uniqueness
        int length = 8;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(lettersAndDigits.length());
            sb.append(lettersAndDigits.charAt(index));
        }

        // Append a shorter timestamp (last two digits of the current milliseconds)
        String uniqueUsername = sb.toString() + "_" + (System.currentTimeMillis() % 100);

        // Trim to a max of 10 characters
        if (uniqueUsername.length() > 10) {
            uniqueUsername = uniqueUsername.substring(0, 10);
        }

        return uniqueUsername;
    }


    public static String generateRandomLastName() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        int length = 7; // You can change the length if needed
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(letters.length());
            sb.append(letters.charAt(index));
        }

        // Capitalize the first letter and return the name
        String lastName = sb.toString();
        return lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
    }
    public static String generateRandomMiddleName() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        int length = 7; // You can change the length if needed
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(letters.length());
            sb.append(letters.charAt(index));
        }

        return sb.toString();
    }

    public static String generateDynamicEmail() {

        String uniqueId = UUID.randomUUID().toString().substring(0, 8);

        String dynamicEmail = "user" + uniqueId + "@example.com";

        return dynamicEmail;
    }

    public static String generateEgyptianPhoneNumber() {
        final AtomicInteger counter = new AtomicInteger(0);

        String[] egyptianPrefixes = {"010", "011", "012", "015"};
        String prefix = egyptianPrefixes[(int) (Math.random() * egyptianPrefixes.length)];


        int randomNumber = (int) (Math.random() * 10000000);


        AtomicInteger uniqueValue = counter;


        return "+20" + prefix + String.format("%07d", randomNumber) + uniqueValue;
    }
    public static long generateUniqueEmployeeId() {
        Random random = new Random();

        // Minimum 6-digit value (100000), maximum 6-digit value (999999)
        long min = 100000L;
        long max = 999999L;

        // Generate a random 6-digit employee ID
        long uniqueEmployeeId = min + (long) (random.nextDouble() * (max - min + 1));

        // Return the generated ID
        return uniqueEmployeeId;
    }




    public static String generateDynamicPassword() {
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'\",.<>?";

        // Combine all character sets
        String allCharacters = capitalLetters + smallLetters + numbers + specialCharacters;

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        // Ensure at least one character from each set is included
        password.append(capitalLetters.charAt(random.nextInt(capitalLetters.length())));
        password.append(smallLetters.charAt(random.nextInt(smallLetters.length())));
        password.append(numbers.charAt(random.nextInt(numbers.length())));
        password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));

        // Fill the remaining characters to meet the 7-character minimum
        int remainingLength = 7 - password.length();
        for (int i = 0; i < remainingLength; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }

        // Shuffle the password to randomize character positions
        return shuffleString(password.toString());
    }

    private static String shuffleString(String input) {
        ArrayList<Object> characters = new ArrayList<>();
        for (char c : input.toCharArray()) {
            characters.add(c);
        }
        Collections.shuffle((java.util.List<?>) characters);
        StringBuilder shuffled = new StringBuilder();
        for (Object c : characters) {
            shuffled.append(c);
        }
        return shuffled.toString();
    }


    public static String shuffleString() {
        String input = String.valueOf(1);
        char[] characters = input.toCharArray();
        Random random = new Random();
        for (int i = characters.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }
        return new String(characters);
    }

    public static String generateRandomPostalCode() {
        Random random = new Random();
        return String.format("%05d", random.nextInt(100000));
    }

    public static String generateRandomAddress() {
        Random random = new Random();
        int number = random.nextInt(100) + 1;
        char letter1 = (char) ('a' + random.nextInt(26));
        char letter2 = (char) ('a' + random.nextInt(26));
        char letter3 = (char) ('a' + random.nextInt(26));

        return number + "" + letter1 + letter2 + letter3;
    }

    public static String generateRandomCity() {
        String[] cities = {"New York", "London", "Paris", "Tokyo", "Cairo", "Sydney", "Mumbai", "Beijing", "Dubai", "Rio de Janeiro", "Berlin", "Toronto", "Los Angeles", "Cape Town", "Singapore", "Mexico City", "Seoul", "Moscow", "Istanbul", "Bangkok"};
        Random random = new Random();
        return cities[random.nextInt(cities.length)];
    }

    public static String generateRandomCompanyName() {
        String[] companies = {"TechCorp", "Global Solutions", "NextGen Innovations", "BlueSky Technologies", "Quantum Systems", "EcoLogic Industries", "Fusion Dynamics", "Visionary Labs", "EverGreen Ventures", "Summit Enterprises"};
        Random random = new Random();
        return companies[random.nextInt(companies.length)];

    }
    public static void openBrowserNetworkTab() throws AWTException {
        // Create Robot instance
        Robot robot = new Robot();

        // Add a delay for setup (optional)
        robot.delay(2000); // Wait for the browser window to be active

        // Step 1: Press Ctrl+Shift+I to open Developer Tools
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_I);

        // Add a delay for Developer Tools to open
        robot.delay(1000);

        // release press buttons
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_I);

        // Step 2: Navigate to the Network tab
        // Use Right Arrow key multiple times to move to the Network tab
        for (int i = 0; i < 3; i++) {
            // Press and hold Ctrl
            robot.keyPress(KeyEvent.VK_CONTROL);

            // Press and release
            robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
            robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);

            // Release Ctrl
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Add a small delay between presses
            robot.delay(200);
        }
    }

}




