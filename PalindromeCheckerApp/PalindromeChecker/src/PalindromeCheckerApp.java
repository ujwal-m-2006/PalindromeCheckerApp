// Palindrome strategy interface
interface PalindromeStrategy {
    boolean checkPalindrome(String text);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String text) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String text) {
        java.util.Deque<Character> deque = new java.util.LinkedList<>();
        for (int i = 0; i < text.length(); i++) {
            deque.addLast(text.charAt(i));
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// Context class to use strategy
class PalindromeCheckerContext {
    private PalindromeStrategy strategy;

    public PalindromeCheckerContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String text) {
        return strategy.checkPalindrome(text);
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "madam";

        // Use Stack strategy
        PalindromeCheckerContext context = new PalindromeCheckerContext(new StackStrategy());
        System.out.println(word + " using StackStrategy: " +
                (context.check(word) ? "Palindrome" : "Not Palindrome"));

        // Switch to Deque strategy dynamically
        context.setStrategy(new DequeStrategy());
        System.out.println(word + " using DequeStrategy: " +
                (context.check(word) ? "Palindrome" : "Not Palindrome"));
    }
}