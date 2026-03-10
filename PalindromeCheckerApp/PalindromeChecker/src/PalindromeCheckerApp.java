import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    // Loop reverse method
    public static boolean loopReverse(String text) {
        String reversed = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }
        return text.equals(reversed);
    }

    // Stack method
    public static boolean stackMethod(String text) {
        Stack<Character> stack = new Stack<>();
        for (char c : text.toCharArray()) {
            stack.push(c);
        }
        for (char c : text.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }

    // Deque method
    public static boolean dequeMethod(String text) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : text.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String word = "madam";

        // Loop Reverse timing
        long start = System.nanoTime();
        boolean result1 = loopReverse(word);
        long end = System.nanoTime();
        System.out.println("Loop Reverse: " + (result1 ? "Palindrome" : "Not Palindrome") +
                " | Time: " + (end - start) + " ns");

        // Stack timing
        start = System.nanoTime();
        boolean result2 = stackMethod(word);
        end = System.nanoTime();
        System.out.println("Stack Method: " + (result2 ? "Palindrome" : "Not Palindrome") +
                " | Time: " + (end - start) + " ns");

        // Deque timing
        start = System.nanoTime();
        boolean result3 = dequeMethod(word);
        end = System.nanoTime();
        System.out.println("Deque Method: " + (result3 ? "Palindrome" : "Not Palindrome") +
                " | Time: " + (end - start) + " ns");
    }
}