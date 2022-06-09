package hw3.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        int N = oomages.size();
        List<Oomage>[] buckets = new List[M];
        for (int i = 0; i < M; ++i) {
            buckets[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; ++i) {
            Oomage noo = oomages.get(i);
            List<Oomage> thisBucket = buckets[(noo.hashCode() & 0x7fffffff) % M];
            if (!thisBucket.contains(oomages)) thisBucket.add(noo);
        }
        double inf = (double) N / 50.0, sup = (double) N / 2.5;
        for (int i = 0; i < M; ++i) {
            double loadNum = buckets[i].size();
            if (loadNum < inf || loadNum > sup) return false;
        }
        return true;
    }
}
