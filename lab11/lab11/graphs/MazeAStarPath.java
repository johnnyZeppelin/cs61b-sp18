package lab11.graphs;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Josh Hug
 */
public class MazeAStarPath extends MazeExplorer {
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;

    public MazeAStarPath(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    /**
     * Estimate of the distance from v to the target.
     */
    private int h(int v) {
        return Math.abs(v / maze.N() - t / maze.N()) + Math.abs(v % maze.N() - t % maze.N());
    }

    /**
     * Finds vertex estimated to be closest to target.
     */
    private int findMinimumUnmarked() {
        return -1;
        /* You do not have to use this method. */
    }

    /**
     * Performs an A star search from vertex s.
     */
    private void astar(int s) {
        // TODO
        PriorityQueue<Entry<Integer, Integer>> verticesQueue = new PriorityQueue<>();
        verticesQueue.add(new Entry<>(s, h(s)));
        while (!verticesQueue.isEmpty()) {
            int v = verticesQueue.remove().getKey();
            marked[v] = true;
            announce();
            if (v == t) targetFound = true;
            if (targetFound) return;
            for (int w : maze.adj(v)) {
                if (marked[w]) continue;
                edgeTo[w] = v;
                announce();
                distTo[w] = distTo[v] + 1;
                verticesQueue.add(new Entry<>(w, h(w)));
            }
        }
    }

    private class Entry<K, V extends Comparable<V>> implements Comparable<Entry<K, V>> {
        private K key;
        private V value;

        public Entry() {
            key = null;
            value = null;
        }

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public int compareTo(@NotNull MazeAStarPath.Entry<K, V> o) {
            return value.compareTo(o.value);
        }
    }

    @Override
    public void solve() {
        astar(s);
    }

}

