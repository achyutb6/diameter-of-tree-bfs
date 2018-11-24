package aab180004;

import rbk.Graph;
import rbk.BFSOO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SP12 {
    public static int diameter(Graph g) {
        BFSOO bfs = BFSOO.breadthFirstSearch(g, 1);
        Graph.Vertex max = bfs.getSource();
        for(Graph.Vertex u : g){
            if(bfs.getDistance(u) > bfs.getDistance(max)){
                max = u;
            }
        }
        bfs = BFSOO.breadthFirstSearch(g , max);
        Graph.Vertex diameter = bfs.getSource();
        for(Graph.Vertex u : g){
            if(bfs.getDistance(u) > bfs.getDistance(diameter)){
                diameter = u;
            }
        }
        return bfs.getDistance(diameter);
    }

    public static void main(String args[]) throws FileNotFoundException {
        String string = "10 9   1 2 1   1 3 1   2 4 1   2 5 1   3 6 1   3 7 1   4 8 1   7 9 1   7 10 1 1";
        Scanner in;
        // If there is a command line argument, use it as file from which
        // input is read, otherwise use input from string.
        in = args.length > 0 ? new Scanner(new File(args[0])) : new Scanner(string);
        // Read graph from input
        Graph g = Graph.readGraph(in);
        int s = in.nextInt();

        System.out.println(diameter(g));
    }
}
