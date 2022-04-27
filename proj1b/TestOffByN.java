import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN {
    @Test
    public void testEqualChars() {
        //int n = new Scanner(System.in).nextInt();
        int n = 5;
        CharacterComparator offByN = new OffByN(n);
        char[] testCases = {' ', '#', '\n', '\u002f',
                '3', 'f', 'Z', 'A', (char) 39,
                '传', '塊', '，', '》'};
        for (char c : testCases) {
            if (Math.rint(Math.random()) % 2 == 0) {
                assertTrue(offByN.equalChars(c, (char) (c + n)));
            } else {
                assertTrue(offByN.equalChars(c, (char) (c - n)));
            }
        }

        for (char c : testCases) {
            assertFalse(offByN.equalChars(c, c));
            int rand = (int) Math.rint(Math.random());
            assertFalse(offByN.equalChars(c, (char) (c + (rand == n ? rand + 1 : rand))));
        }
    }
}