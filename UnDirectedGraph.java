package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class UnDirectedGraph
{
    int v;
    LinkedList<Integer> list[];

    UnDirectedGraph(int v)
    {
        this.v=v;
        list=new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            list[i]=new LinkedList<>();
        }
    }

    static void addEdge(UnDirectedGraph graph, int src, int dest)
    {
        //link from src node to dest node
        graph.list[src].add(dest);

        //as it is undirected graph link from dest node to src node
        //commenting below line will make it directed graph
        graph.list[dest].add(src);
    }

    static void printGraph(UnDirectedGraph graph)
    {
        for(int i=0;i<graph.v;i++)
        {
            System.out.println("Nodes of "+i);
            for(Integer j:graph.list[i])
            {
                System.out.print(i+"->"+j+"\t");
            }
            System.out.println();
        }
    }

    /*static void DFS(int v)
    {
        boolean visited[]=new boolean[v];
        DFSGraph(v,visited);
    }
    void DFSGraph(int v, boolean visited[])
    {
        visited[v]=true;
        System.out.println(v+" ");

        //error in listiterator
        Iterator<Integer> i=list[v].listIterator();
        while (i.hasNext())
        {
            int n=i.next();
            if(!visited[n])
            {
                DFSGraph(n,visited);
            }
        }
    }

    void BFS(int v)
    {
        boolean visited[]=new boolean[v];
        BFSGraph(v,visited);
    }
    void BFSGraph(int v, boolean visited[])
    {
        LinkedList<Integer> que=new LinkedList<Integer>();

        visited[v]=true;
        que.add(v);

        while(que.size()!=0)
        {
            v=que.poll();
            System.out.print(v+" ");

            //error in listiterator
            Iterator<Integer> i=list[v].listIterator();
            while(i.hasNext())
            {
                int n=i.next();
                if(!visited[n]);
                {
                    visited[n]=true;
                    que.add(n);
                }
            }
        }
    }*/

    public static void main(String[] args)
    {
        int v=5;
        UnDirectedGraph graph=new UnDirectedGraph(v);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);
        addEdge(graph,4,0);

        printGraph(graph);
    }
}
