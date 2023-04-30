package ow.henhacks23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Algorithm
{
    Node startingNode;
    HashSet<Node> network;

    public Algorithm(Node start, Node[] network)
    {
        startingNode = start;
        this.network = new HashSet<>(Arrays.stream(network).toList());
    }

    public ArrayList<Node> algorithm(Node endpoint)
    {
        HashSet<Node> net = new HashSet<>(network);
        startingNode.value = 0;
        Node lookAt = startingNode;
        Node temp;

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

        ArrayList<Node> path = new ArrayList<Node>();
        Node curr = endpoint;
        while (curr != null)
        {
            path.add(curr);
            curr = curr.prev;
        }
        return path;

    }
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
