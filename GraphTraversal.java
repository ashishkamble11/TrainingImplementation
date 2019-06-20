package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphTraversal
{
    private int numVertices;
    private LinkedList<Integer> adjLists[];
    private boolean visited[];

    GraphTraversal(int vertices)
    {
        numVertices = vertices;
        adjLists = new LinkedList[vertices];
        visited = new boolean[numVertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<Integer>();
    }

    void addEdge(int src, int dest)
    {
        adjLists[src].add(dest);
            adjLists[dest].add(src);
    }

    void DFS(int vertex)
    {

        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator<Integer> ite = adjLists[vertex].listIterator();
        while (ite.hasNext())
        {
            int adj = ite.next();
            if (!visited[adj])
                DFS(adj);
        }
    }

    void BFS(int vertex)
    {
        visited = new boolean[numVertices];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[vertex]=true;
        queue.add(vertex);

        while(queue.size()!=0)
        {
            vertex=queue.poll();
            System.out.print(vertex+" ");

            Iterator<Integer> ite=adjLists[vertex].listIterator();

            while (ite.hasNext())
            {
                int adjVertex = ite.next();
                if (!visited[adjVertex])
                {
                    visited[adjVertex] = true;
                    queue.add(adjVertex);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        GraphTraversal g = new GraphTraversal(5);

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println("Following is Depth First Traversal");
        g.DFS(0);
        System.out.println();

        System.out.println("Following is Breadth First Traversal");
        g.BFS(0);
    }
}
