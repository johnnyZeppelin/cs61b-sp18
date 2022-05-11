import static org.junit.Assert.*;
import org.junit.Test;


public class TestArrayDequeGold {
    @Test
    public void testTaskI() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sol1 = new ArrayDequeSolution<>();
        while (true) {
            Integer a = StdRandom.uniform(2);
            if (a % 2 == 0) {
                sad1.addFirst(a);
                sad1.addLast(a + 2);
                sad1.addLast(a + 3);
                sad1.addFirst(a + 4);
                assertEquals(a + 4, sad1.removeFirst().intValue());
                assertEquals(a + 3, sad1.removeLast().intValue());
                assertEquals(2, sad1.size());
            } else {
                sol1.addFirst(a);
                sol1.addLast(a + 2);
                sol1.addLast(a + 3);
                sol1.addFirst(a + 4);
                assertEquals(a + 4, sol1.removeFirst().intValue());
                assertEquals(a + 3, sol1.removeLast().intValue());
                assertEquals(2, sol1.size());
            }
        }
    }
}
