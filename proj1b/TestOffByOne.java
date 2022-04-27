import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('I', 'H'));
        assertTrue(offByOne.equalChars('2', '1'));
        assertTrue(offByOne.equalChars('[', '\\'));
        assertTrue(offByOne.equalChars('@', '?'));
        assertTrue(offByOne.equalChars('%', '&'));
        assertTrue(offByOne.equalChars('=', '>'));
        assertTrue(offByOne.equalChars('\n', '\t'));
        assertTrue(offByOne.equalChars('\b', '\u0009'));
        assertTrue(offByOne.equalChars('\u000c', '\u000b'));
        assertTrue(offByOne.equalChars('\t', '\b'));
        assertTrue(offByOne.equalChars(' ', '!'));
        assertTrue(offByOne.equalChars('刘', (char) ('刘'+1)));
        assertTrue(offByOne.equalChars('髙', '高'));
        //System.out.println((int) '髙' + " " + (int) '高' + (char) ('刘'+1));

        assertFalse(offByOne.equalChars('a', 'a'));
        assertFalse(offByOne.equalChars('z', 'a'));
        assertFalse(offByOne.equalChars('b', 'B'));
        assertFalse(offByOne.equalChars('a', '3'));
        assertFalse(offByOne.equalChars('2', '2'));
        assertFalse(offByOne.equalChars('!', '$'));
        assertFalse(offByOne.equalChars('#', 'J'));
        assertFalse(offByOne.equalChars('^', 'f'));
        assertFalse(offByOne.equalChars(' ', '\n'));
        assertFalse(offByOne.equalChars('\u0009', '\u0009'));
        assertFalse(offByOne.equalChars('叙', '德'));
        /*System.out.println((int) '叙'+" "+(int) '敘' +" "+ (int) '德' + " " + (int)'徳');
        System.out.println((int)'许'+" "+ (int)'許');*/
        assertFalse(offByOne.equalChars('德', '徳'));
        assertFalse(offByOne.equalChars('g', '许'));
        assertFalse(offByOne.equalChars('许', '許'));
        assertFalse(offByOne.equalChars('敘', '叙'));
    }
    // Your tests go here.
    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class.
}
