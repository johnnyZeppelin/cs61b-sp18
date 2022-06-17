package lab11.graphs;

import edu.princeton.cs.algs4.Stack;

/**
 * @author Josh Hug (Nuhh.. He was just bragging)
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s, t;
    private boolean cycleFound = false;
    private Maze maze;

    public MazeCycles(Maze m) {
        super(m);
        maze = m;
        s = maze.xyTo1D(1, 1);
        t = maze.xyTo1D(maze.N(), maze.N());
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    @Override
    public void solve() {
        // TODO: Your code here!
        checkCycles(s);
    }

    // Helper methods go here
    private void checkCycles(int v) {
        marked[v] = true;
        announce();
        for (int w : maze.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                announce();
                distTo[w] = distTo[v] + 1;
                checkCycles(w);
            } else {
                if (w == edgeTo[v]) continue;
                else {
                    edgeTo[w] = v;
                    announce();
                    return;
                }
            }
        }
    }
}

