package synthesizer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the ArrayRingBuffer class.
 *
 * @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.enqueue(1);
        arb.enqueue("fr ");
        arb.enqueue('%');
        arb.enqueue(12.89);
        assertEquals(1, arb.dequeue());
        assertEquals("fr ", arb.dequeue());
        assertFalse(arb.dequeue().equals(12.89));
        assertEquals(12.89, arb.dequeue());
        assertEquals(0, arb.fillCount);

        for (int i = 0; i < 10; ++i) {
            arb.enqueue(i);
        }
        //arb.enqueue("lk");
        assertEquals(0, arb.peek());
        for (Object object : arb) System.out.println(object);
    }

    /**
     * Calls tests for ArrayRingBuffer.
     */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
