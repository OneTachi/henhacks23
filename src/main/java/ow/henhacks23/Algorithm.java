package ow.henhacks23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Algorithm.java
 * HenHacks23
 * OWL
 * 4/30/23
 *
 * Calculates the shortest path of a give network of nodes
 */
public class Algorithm
{
    Node startingNode;
    HashSet<Node> network;

    public Algorithm(Node start, Node[] network)
    {
        startingNode = start;
        this.network = new HashSet<>(Arrays.stream(network).toList());
    }

    /**
     * Calculates path using Djikstra's Algorithm
     * @param endpoint The user's desired end location
     * @return The path from the end location to the user's current location
     */
    public ArrayList<Node> algorithm(Node endpoint)
    {
        //Using a Hashset for unvisited nodes. LATER: use different data structure, cannot pull random
        //element
        HashSet<Node> net = new HashSet<>(network);
        startingNode.value = 0;
        Node lookAt = startingNode;
        Node temp;

        //Algorithm keeps running till there all nodes visited
        while (!(net.isEmpty()))
        {
            temp = lookAt.lookAtConnections();
            System.out.println(lookAt.value);
            net.remove(lookAt);

            lookAt.visited = 1;
            lookAt = temp;

            if (lookAt == null && !net.isEmpty())
            {
                // So unoptimized but works for now lol
                lookAt = (Node) (net.toArray())[0];
            }

        }

        //Returning path
        ArrayList<Node> path = new ArrayList<Node>();
        Node curr = endpoint;
        while (curr != null)
        {
            path.add(curr);
            curr = curr.prev;
        }
        return path;

    }
    //Used for testing
    public static void main(String[] args)
    {
//        Node seven = new Node();
//        Node six = new Node(new Connection[]
//                {
//                        new Connection(seven, 1)
//                });
//
//        Node five = new Node(new Connection[]
//                {
//                   new Connection(six, 3),
//                   new Connection(seven, 6)
//                });
//        Node[] nodes = {six, seven, five};
//        Algorithm alg = new Algorithm(five, nodes);
//
//        ArrayList<Node> answer = alg.algorithm(seven);
//        answer.forEach(n -> System.out.print(n));
    }
}
