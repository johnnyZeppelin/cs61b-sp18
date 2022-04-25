import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persif lage");
        String actual = "";
        for (int i = 0; i < "persif lage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persif lage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("kayak"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("9"));
        assertTrue(palindrome.isPalindrome("90xb^^bx09"));
        assertTrue(palindrome.isPalindrome(" "));
        assertTrue(palindrome.isPalindrome("            "));
        assertTrue(palindrome.isPalindrome("x"));
        assertTrue(palindrome.isPalindrome("aa"));
        assertTrue(palindrome.isPalindrome("sds"));;
        assertTrue(palindrome.isPalindrome("ab  ba"));
        assertTrue(palindrome.isPalindrome("上海自来水来自海上"));

        assertFalse(palindrome.isPalindrome("ab"));
        assertFalse(palindrome.isPalindrome(" a"));
        assertFalse(palindrome.isPalindrome("catTac"));
        assertFalse(palindrome.isPalindrome("safhsaufh"));
        assertFalse(palindrome.isPalindrome("14fsf5488dwaerf%^%$"));
        assertFalse(palindrome.isPalindrome("大庇天下寒士俱欢颜"));
        assertFalse(palindrome.isPalindrome("上海自来水来自 海上"));
        assertFalse(palindrome.isPalindrome("上海自来水來自海上"));
    }
}
