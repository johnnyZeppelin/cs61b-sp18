package DataStructure61B.Map61B;

import edu.princeton.cs.algs4.In;
import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testMap61BItr() {
        Map61B<String, Integer> map61B = new ArrayMap<>();
        map61B.put("London", 2012);
        map61B.put("Rio", 2016);
        map61B.put("Tokyo", 2020);
        map61B.put("Paris", 2024);
        map61B.put("Germany", 2024);
        map61B.put("Tokyo", 2021);

        assertEquals(5, map61B.size());
        for (Pair<String, Integer> p : (ArrayMap<String, Integer>) map61B) {
            System.out.println(p.getKey());
        }
    }

    @Test
    public void testMap61BOfEql() {
        Map61B<String, Integer> map61B = new ArrayMap<>();
        map61B.put("London", 2012);
        map61B.put("Rio", 2016);
        map61B.put("Tokyo", 2020);
        map61B.put("Paris", 2024);
        map61B.put("Germany", 2024);
        map61B.put("Tokyo", 2021);

        List<Pair<String, Integer>> pairList = new ArrayList<>();
        for (Pair<String, Integer> p : (ArrayMap<String, Integer>) map61B) {
            pairList.add(p);
        }
        Map61B<String, Integer> map61B1 = ArrayMap.of(pairList);
        assertTrue(map61B1.equals(map61B));
    }

    @Test
    public void testMap61BToStr() {
        Map61B<String, Integer> map61B = new ArrayMap<>();
        System.out.println(map61B);
        map61B.put("London", 2012);
        map61B.put("Rio", 2016);
        map61B.put("Tokyo", 2020);
        map61B.put("Paris", 2024);
        map61B.put("Germany", 2024);
        map61B.put("Tokyo", 2021);

        System.out.println(map61B);
        System.out.println(new Pair<>("df", 13.5));
    }

    @Test
    public void testExeption() {
        ArrayMap<String, Integer> arrayMap = new ArrayMap<>();
        arrayMap.put("Hello", 12);
        System.out.println(arrayMap.get("hello"));
    }

    @Test
    public void testException1() {
        try {
            System.out.println("lmao");
            throw new RuntimeException("for no reason");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("no way");
    }
}
