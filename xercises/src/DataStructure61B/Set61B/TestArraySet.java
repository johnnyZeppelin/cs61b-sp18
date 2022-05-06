package DataStructure61B.Set61B;

import org.junit.Test;

public class TestArraySet {
    @Test
    public void testArraySet() {
        ArraySet<Integer> set = new ArraySet<>();
        set.add(1);
        set.add(2);
        //set.add(null);
        set.add(3);
        assert !set.contains(5);
        assert set.contains(3);
    }
}
