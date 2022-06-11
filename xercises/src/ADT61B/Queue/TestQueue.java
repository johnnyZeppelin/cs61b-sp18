package ADT61B.Queue;

import org.junit.Test;

public class TestQueue {
    @Test
    public void testQueue61B() {
        Queue61B<Integer> queue61B = new Queue<>();
        assert queue61B.dequeue() == null;
        for (int i = 0; i < 5; ++i) {
            queue61B.enqueue(i + 1);
        }
        assert 5 == ((Queue) queue61B).size();
        assert !((Queue) queue61B).isEmpty();
        assert queue61B.dequeue().equals(1);
        assert queue61B.dequeue().equals(2);
        ((Queue) queue61B).printList();
        assert ((Queue) queue61B).size() == 3;
        assert queue61B.dequeue().equals(3);
        assert queue61B.dequeue().equals(4);
        assert queue61B.dequeue().equals(5);
        assert ((Queue) queue61B).isEmpty();
    }
}
