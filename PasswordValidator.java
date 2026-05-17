import java.util.Scanner;

public class PasswordValidator {

    // CHECK UPPERCASE
    static boolean hasUpper(String password) {
        for (char ch : password.toCharArray())
            if (Character.isUpperCase(ch)) return true;
        return false;
    }

    // CHECK LOWERCASE
    static boolean hasLower(String password) {
        for (char ch : password.toCharArray())
            if (Character.isLowerCase(ch)) return true;
        return false;
    }

    // CHECK DIGIT
    static boolean hasDigit(String password) {
        for (char ch : password.toCharArray())
            if (Character.isDigit(ch)) return true;
        return false;
    }

    // CHECK SPECIAL CHARACTER
    static boolean hasSpecial(String password) {
        String special = "!@#$%^&*()-_=+<>?/";
        for (char ch : password.toCharArray())
            if (special.contains(String.valueOf(ch))) return true;
        return false;
    }

    // MAIN CHECK FUNCTION
    public static void checkPassword(String password) {

        System.out.println("\n===== PASSWORD ANALYSIS =====");

        boolean lengthOK = password.length() >= 8;
        boolean upperOK = hasUpper(password);
        boolean lowerOK = hasLower(password);
        boolean digitOK = hasDigit(password);
        boolean specialOK = hasSpecial(password);

        int score = 0;

        if (lengthOK) score++;
        if (upperOK) score++;
        if (lowerOK) score++;
        if (digitOK) score++;
        if (specialOK) score++;

        double percentage = (score / 5.0) * 100;

        // DISPLAY CONDITIONS
        System.out.println("Length >= 8       : " + lengthOK);
        System.out.println("Uppercase present : " + upperOK);
        System.out.println("Lowercase present : " + lowerOK);
        System.out.println("Digit present     : " + digitOK);
        System.out.println("Special char      : " + specialOK);

        System.out.println("\nScore: " + score + "/5");
        System.out.printf("Strength: %.0f%%\n", percentage);

        // RESULT
        if (percentage == 100) {
            System.out.println("RESULT: STRONG PASSWORD");
        } 
        else if (percentage >= 60) {
            System.out.println("RESULT: MEDIUM PASSWORD");
        } 
        else {
            System.out.println("RESULT: WEAK PASSWORD");
        }

        // =========================
        // SMART SUGGESTIONS
        // =========================
        System.out.println("\n===== SUGGESTIONS =====");

        if (!lengthOK)
            System.out.println("Use at least 8 characters");

        if (!upperOK)
            System.out.println("Add uppercase letters (A-Z)");

        if (!lowerOK)
            System.out.println("Add lowercase letters (a-z)");

        if (!digitOK)
            System.out.println("Add numbers (0-9)");

        if (!specialOK)
            System.out.println("Add special characters (!@#$...)");

        if (percentage < 100)
            System.out.println("Mix all character types for maximum security ");
    }

    // MAIN METHOD
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== PASSWORD STRENGTH CHECKER =====");
            System.out.println("1. Check Password");
            System.out.println("2. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Password: ");
                    String password = sc.nextLine();

                    checkPassword(password);
                    break;

                case 2:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}