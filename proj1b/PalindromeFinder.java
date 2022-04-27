import java.util.Scanner;

/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    /**
     * Outputs palindrome(s) in the given lexicon.
     * @param lexicon the file address of the lexicon
     * @param minLength the minimum length of the palindrome
     */
    private static void outPutPalindrome(String lexicon, int minLength) {
        System.out.println("Palindrome(s) off by:");
        int n = new Scanner(System.in).nextInt();
        outPutOffByNPalindrome(lexicon, minLength, n);
    }

    /**
     * Output off-by-n palindrome(s) out of the given lexicon.
     * @param lexiconLocator the file address of the given lexicon
     * @param minLength the minimum length of the palindrome word
     * @param offByN off by offByN
     */
    private static void outPutOffByNPalindrome(String lexiconLocator, int minLength, int offByN) {
        In in = new In(lexiconLocator);
        Palindrome palindrome = new Palindrome();
        CharacterComparator cc = new OffByN(offByN);
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
                System.out.println(word);
            }
        }
    }

    /**
     * Count the number of off-by-n palindrome(s) out of the given lexicon.
     * @param lexiconLocator the file address of the given lexicon
     * @param minLength the minimum length of the palindrome word
     * @param offByN off by offByN
     * @return the number
     */
    private static int countOffByNPalindrome(String lexiconLocator, int minLength, int offByN) {
        int count = 0;
        In in = new In(lexiconLocator);
        Palindrome palindrome = new Palindrome();
        CharacterComparator cc = new OffByN(offByN);
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
                ++count;
            }
        }
        return count;
    }

    /**
     * Finds for what n are there the most palindromes in the given lexicon.
     * @param lexicon the givem lexicon
     * @param minLength the minimum length of a palindrome
     */
    private static void findMostNForPalindrome(String lexicon, int minLength) {
        int maxNumber = 0;
        int maxIndex = 0;
        for (int i = 0; i < 26; ++i) {
            int num = countOffByNPalindrome(lexicon, minLength, i);
            System.out.println("Number of off-by-" + i + " palindrome(s): " + num);
            if (maxNumber < num) {
                maxNumber = num;
                maxIndex = i;
            }
        }
        System.out.println("\nThere are the most palindromes in English for "
                + maxIndex + ". " + maxNumber + " in total. And they are:");
        outPutOffByNPalindrome(lexicon, minLength, maxIndex);
        System.out.println("There are the most palindromes in English for "
                + maxIndex + ". " + maxNumber + " in total.");
    }

    /**
     * Find the longest off-by-n palindrome in the given lexicon.
     * @param lexicon the given lexicon
     * @param minLength the minimum length of a palindrome
     * @param offByN off-by-offByN
     * @return the palindrome demanded
     */
    private static String longestPalindromeForN(String lexicon, int minLength, int offByN) {
        String res = "";
        In in = new In(lexicon);
        Palindrome palindrome = new Palindrome();
        CharacterComparator cc = new OffByN(offByN);
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() > res.length() && word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
                res = word;
            }
        }
        return res;
    }
    /**
     * Find the longest off-by-n palindrome in the given lexicon for any n.
     * @param lexicon the given lexicon
     * @param minLength the minimum length of a palindrome
     */
    private static void findLongestPalindromeForAnyN(String lexicon, int minLength) {
        String res = "";
        int index = 0;
        for (int i = 0; i < 26; ++i) {
            String longestForI = longestPalindromeForN(lexicon, minLength, i);
            if (res.length() < longestForI.length()) {
                res = longestForI;
                index = i;
            }
        }
        System.out.println("The longest off-by-n palindrome for any n is:");
        System.out.println(res);
        System.out.println("It is off-by-" + index + " and " + res.length() + "-letter-long.");
    }

    public static void main(String[] args) {
        int minLength = 4;
        String lexicon = "../library-sp18/library-sp18/data/words.txt";

        //outPutPalindrome(lexicon, minLength);
        //findMostNForPalindrome(lexicon, minLength);
        //findLongestPalindromeForAnyN(lexicon, minLength);
    }
}
