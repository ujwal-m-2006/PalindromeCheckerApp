public class PalindromeCheckerApp {

    // Method to check palindrome using two-pointer technique
    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        String text = "Nurses Run";

        // Normalize string: remove spaces and convert to lowercase
        String normalized = text.replaceAll("\\s+", "").toLowerCase();

        // Check palindrome
        boolean result = isPalindrome(normalized);

        // Print result
        if (result) {
            System.out.println("\"" + text + "\" is a Palindrome (case-insensitive & space-ignored).");
        } else {
            System.out.println("\"" + text + "\" is NOT a Palindrome (case-insensitive & space-ignored).");
        }
    }
}