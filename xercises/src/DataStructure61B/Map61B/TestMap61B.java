package DataStructure61B.Map61B;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMap61B {
    @Test
    public void testArrayMap() {
        Map61B<String, Double> map61B = new ArrayMap<String, Double>();
        map61B.put("Ajax", 4.);
        map61B.put("Real", 13.5);
        map61B.put("Milano", 7.);
        map61B.put("Liverpool", 6.5);
        map61B.put("Bayern", 6.);
        map61B.put("Real", 14.);
        map61B.put("Barca", 5.);

        assert map61B.containsKey("Milano") == true;
        assert map61B.containsKey("wdfwe") == false;
        assert map61B.size() != 7;
        assert map61B.size() == 6;
        assert map61B.get("Real") == 14.000;
        assert map61B.get("Re") == null;
        assert map61B.get("Real") != 13.50;
        assert map61B.containsKey("Bar") == false;
        System.out.println(map61B.keys());

        Map61B<Integer, Integer> integerMap61B = new ArrayMap<Integer, Integer>();
        integerMap61B.put(13, 15);

        int exp = 15;
        assertEquals(exp, integerMap61B.get(13).longValue());
        assertEquals(exp, integerMap61B.get(13).byteValue());
        assertEquals((Integer) 15, integerMap61B.get(13));

        assertEquals((Double) 6.5, Map61BHelper.get(map61B, "Liverpool"));

        System.out.println(Map61BHelper.maxKey(map61B));
    }
    @Test
    public void testArrayMap1() {
        Map61B<String, Double> map61B = new ArrayMap1<String, Double>();
        map61B.put("Real", 13.5);
        map61B.put("Milano", 7.);
        map61B.put("Liverpool", 6.5);
        map61B.put("Bayern", 6.);
        map61B.put("Real", 14.);
        map61B.put("Barca", 5.);

        assert map61B.containsKey("Milano") == true;
        assert map61B.containsKey("wdfwe") == false;
        assert map61B.size() != 6;
        assert map61B.size() == 5;
        assert map61B.get("Real") == 14.000;
        assert map61B.get("Re") == null;
        assert map61B.get("Real") != 13.50;
        assert map61B.containsKey("Bar") == false;
        System.out.println(map61B.keys());

        Map61B<Integer, Integer> integerMap61B = new ArrayMap1<Integer, Integer>();
        integerMap61B.put(13, 15);

        int exp = 15;
        //assertEquals((long) exp, integerMap61B.get(13));
        assertEquals(exp, integerMap61B.get(13).longValue());
        assertEquals(exp, integerMap61B.get(13).byteValue());
        assertEquals((Integer) 15, integerMap61B.get(13));
    }
}
