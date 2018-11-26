/**
 * Implement the algorithm to find the diameter of a tree using the
 * algorithm discussed in class, that runs BFS twice.  Code this
 * algorithm without modifying Graph.java and BFSOO.java, using them
 * from package rbk.
 *
 * int diameter(Graph g) { ... }  // assume that g is an acyclic, connected graph (tree).
 * @author Achyut Bhandiwad(aab180004)
 * @author Saurav Sharma (sxs179830)
 */
package aab180004;

import rbk.Graph;
import rbk.BFSOO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SP12 {

    /**
     * Method to find the diameter of a tree using the
     * algorithm discussed in class, that runs BFS twice
     * Assumption : g is an acyclic, connected graph (tree).
     * @param g
     * @return diameter
     */
    public static int diameter(Graph g) {

        //First run of BFS on graph
        BFSOO bfs = BFSOO.breadthFirstSearch(g, 1);
        Graph.Vertex max = bfs.getSource();
        //Finding the node with max distance
        for(Graph.Vertex u : g){
            if(bfs.getDistance(u) > bfs.getDistance(max)){
                max = u;
            }
        }
        //Second run of BFS of graph with max node as the start node
        bfs = BFSOO.breadthFirstSearch(g , max);
        Graph.Vertex diameter = bfs.getSource();
        for(Graph.Vertex u : g){
            if(bfs.getDistance(u) > bfs.getDistance(diameter)){
                diameter = u;
            }
        }
        //return the distance of the node with max distance in the second run
        return bfs.getDistance(diameter);
    }

    public static void main(String args[]) throws FileNotFoundException {
        //Example graph taken from the Notes
        String string = "10 9   1 2 1   1 3 1   2 4 1   2 5 1   3 6 1   3 7 1   4 8 1   7 9 1   7 10 1 1";
        Scanner in;
        // If there is a command line argument, use it as file from which
        // input is read, otherwise use input from string.
        in = args.length > 0 ? new Scanner(new File(args[0])) : new Scanner(string);
        // Read undirected graph from input
        Graph g = Graph.readGraph(in);
        int s = in.nextInt();

        //Printing the diameter
        System.out.println("Diameter : "+ diameter(g));
    }
}
