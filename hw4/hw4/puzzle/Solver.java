package hw4.puzzle;

import edu.princeton.cs.algs4.MinPQ;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solver {
    private WorldState ws;
    private int sizeOfMoves;
    private Iterable<WorldState> sol;

    /**
     * Constructor which solves the puzzle, computing
     * everything necessary for moves() and solution() to
     * not have to solve the problem again. Solves the
     * puzzle using the A* algorithm. Assumes a solution exists.
     *
     * @param initial
     */
    public Solver(WorldState initial) {
        ws = initial;
        Stack<WorldState> states = new Stack<>();
        states.add(ws);

        MinPQ<Entry<WorldState, Integer>> wordPQ = new MinPQ<>();
        wordPQ.insert(new Entry<>(ws, ws.estimatedDistanceToGoal()));
        while (!wordPQ.isEmpty()) {
            Entry<WorldState, Integer> v = wordPQ.delMin();
            states.add(v.key);
            if (v.value == 0) {
                break;
            }
            for (WorldState w : v.key.neighbors()) {
                if (states.contains(w)) continue;
                wordPQ.insert(new Entry<>(w, w.estimatedDistanceToGoal()));
            }
        }

        sizeOfMoves = states.size();
        sol = states;
    }

    private class Entry<K, V extends Comparable<V>>
            implements Comparable<Entry<K, V>> {
        K key;
        V value;

        public Entry(K k, V v) {
            key = k;
            value = v;
        }

        @Override
        public int compareTo(@NotNull Solver.Entry<K, V> o) {
            return value.compareTo(o.value);
        }
    }

    /**
     * Returns the minimum number of moves to solve the puzzle starting
     * at the initial WorldState.
     *
     * @return
     */
    public int moves() {
        // TODO: 2022-06-18
        return sizeOfMoves;
    }

    public Iterable<WorldState> solution() {
        /* Returns a sequence of WorldStates from the initial WorldState
        to the solution. */
        // TODO: 2022-06-18 return
        return sol;
    }
}
