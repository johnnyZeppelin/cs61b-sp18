package paramount;

import org.junit.Test;
import paramount.alphabet.*;

public class TestAlphabet {
    @Test
    public void testOne() {
        B bbc = (B) new C();
        bbc.update();
        bbc.m2();
        System.out.println(bbc.x + ((C) bbc).y);
    }

    @Test
    public void testTwo() {
        A aa = new C();
        //aa.m00();//Wrong! Protected method in other package
    }
}
