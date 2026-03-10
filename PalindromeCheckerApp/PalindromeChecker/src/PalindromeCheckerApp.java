import java.util.Stack;

class PalindromeChecker {

    // Method to check palindrome using Stack internally
    public boolean checkPalindrome(String text) {
        Stack<Character> stack = new Stack<>();

        // Push all characters to stack
        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }

        // Compare by popping from stack
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "madam";

        // Create PalindromeChecker object
        PalindromeChecker checker = new PalindromeChecker();

        // Call method to check palindrome
        boolean result = checker.checkPalindrome(word);

        // Display result
        if (result) {
            System.out.println(word + " is a Palindrome (using PalindromeChecker service).");
        } else {
            System.out.println(word + " is NOT a Palindrome (using PalindromeChecker service).");
        }
    }
}