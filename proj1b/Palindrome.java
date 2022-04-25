public class Palindrome {
    /**
     * Gets a word of String type into a Deque type.
     * @param word the word to transfer
     * @return the result of the transformation from word to a Deque
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); ++i) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    /**
     * To check if the deque is a palindrome recursively.
     * @param deque the word to check in deque type
     * @return true if deque is a palindrome;
     * false otherwise
     */
    private boolean isPalindromeHelper(Deque<Character> deque) {
        if (deque.size() == 1 || deque.isEmpty()) {
            return true;
        } else if (deque.removeFirst().equals(deque.removeLast())) {
            return isPalindromeHelper(deque);
        } else {
            return false;
        }
    }

    /**
     * Checks whether the given word is a palindrome.
     * @param word the word to check
     * @return true if the word is a palindrome;
     * false if not.
     */
    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        return isPalindromeHelper(deque);
    }
}
