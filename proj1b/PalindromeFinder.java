import java.util.Scanner;

/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();

        System.out.println("Palindrome off by:");
        int n = new Scanner(System.in).nextInt();
        CharacterComparator cc = new OffByN(n);
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
                System.out.println(word);
            }
        }
    }
}
