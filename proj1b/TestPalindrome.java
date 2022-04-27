import netscape.security.UserTarget;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    /**
     * To produce a palindrome off by n.
     * @param firstHalf the first half of the palindrome
     * @param n off by which
     * @param odevity true if the length of the palindrome is an odd number;
     *                false otherwise
     * @return the palindrome
     */
    private String producePalindromeOffByN(String firstHalf, int n, boolean odevity) {
        String secondHalf = "";
        int firstHalfLength = firstHalf.length();
        if (odevity) --firstHalfLength;
        for (int i = firstHalfLength - 1; i > -1; --i) {
            int ran = (int) Math.rint(Math.random());
            secondHalf += (char) (firstHalf.charAt(i) + (ran % 2 == 0 ? n : -n));
        }
        return firstHalf + secondHalf;
    }

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
        String[] testCases = {"", " ", "a", "H", "!", "8", "就", "蠶", "\u000f",
                "kay", "90xb^", "kk", "s&gh s ",
                "#as54 das8 . ^2fw%$)", "      ", "   ,  ", "\u000e+\u0028",
                "上海傘来s水我也2不$到哪来的后《边也忘了，？😄"};
        int n = 5;
        CharacterComparator cc = new OffByOne();
        CharacterComparator ccn = new OffByN(n);
        for (String s : testCases) {
            int ran = (int) Math.rint(Math.random());
            if (s.length() == 0) {
                assertTrue(palindrome.isPalindrome(s));
                assertTrue(palindrome.isPalindrome(s, cc));
                assertTrue(palindrome.isPalindrome(s, ccn));
                continue;
            }
            assertTrue(palindrome.isPalindrome(producePalindromeOffByN(s,0, true)));
            assertTrue(palindrome.isPalindrome(producePalindromeOffByN(s,0, false)));
            assertTrue(palindrome.isPalindrome(producePalindromeOffByN(s,1, true), cc));
            assertTrue(palindrome.isPalindrome(producePalindromeOffByN(s, 1, false), cc));
            assertTrue(palindrome.isPalindrome(producePalindromeOffByN(s, n, true), ccn));
            assertTrue(palindrome.isPalindrome(producePalindromeOffByN(s, n, false), ccn));
            if (s.length() == 1) {
                assertFalse(palindrome.isPalindrome(producePalindromeOffByN(s,2, false)));
                assertFalse(palindrome.isPalindrome(producePalindromeOffByN(s,3, false), cc));
                assertFalse(palindrome.isPalindrome(producePalindromeOffByN(s, (ran == n ? ran + 1 : ran), false), ccn));
            } else {
                assertFalse(palindrome.isPalindrome(producePalindromeOffByN(s,2, true)));
                assertFalse(palindrome.isPalindrome(producePalindromeOffByN(s,3, true), cc));
                assertFalse(palindrome.isPalindrome(producePalindromeOffByN(s, (ran == n ? ran + 1 : ran), true), ccn));
                assertFalse(palindrome.isPalindrome(producePalindromeOffByN(s,2, false)));
                assertFalse(palindrome.isPalindrome(producePalindromeOffByN(s,3, false), cc));
                assertFalse(palindrome.isPalindrome(producePalindromeOffByN(s, (ran == n ? ran + 1 : ran), false), ccn));
            }
        }
        assertFalse(palindrome.isPalindrome("g232jh^&342%^BGjkh&&*%$^45hjsdf"));
        assertFalse(palindrome.isPalindrome("as dfdsa"));
        assertFalse(palindrome.isPalindrome("az", cc));
        assertFalse(palindrome.isPalindrome("ASef*%$^45hjsd^2", cc));
        assertFalse(palindrome.isPalindrome("asdfdsa", cc));
    }
}
