package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class WeigthedGraph
{

    static class Edge
    {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight)
        {
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
    }

    int v;
    LinkedList<Edge> list[];

    WeigthedGraph(int v)
    {
        this.v=v;
        list=new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            list[i]=new LinkedList<>();
        }
    }

    void addEdge(int src, int dest, int weight)
    {
        Edge edge=new Edge(src, dest, weight);
        list[src].addFirst(edge);

        /*//link from src node to dest node
        graph.list[src].add(dest);

        //as it is undirected graph link from dest node to src node
        //commenting below line will make it directed graph
        //graph.list[dest].add(src);*/
    }

    void printGraph()
    {
        for(int i=0;i<v;i++)
        {
            System.out.println("Nodes of "+i);
            LinkedList<Edge> tempList=list[i];
            for(int j=0; j<tempList.size(); j++)
            {
                System.out.print(i+"->"+tempList.get(j).dest+"("+tempList.get(j).weight+")\t");
            }
            System.out.println();
        }
    }

    /*void DFS(int v)
    {
        int temp=list.length;
        boolean visited[]=new boolean[temp];
        DFSGraph(v,visited);
    }
    void DFSGraph(int v, boolean visited[])
    {
        visited[v]=true;
        System.out.println(v+" ");

        //error in listiterator
        Iterator i=list[v].listIterator();
        while (i.hasNext())
        {
            int n=(Integer) i.next();
            if(!visited[n])
            {
                DFSGraph(n,visited);
            }
        }
    }

    /*void BFS(int v)
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
        int vertices = 6;
        WeigthedGraph graph = new WeigthedGraph(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 0, 4);
        graph.addEdge(4, 1, 4);
        graph.addEdge(4, 5, 6);

        graph.printGraph();
        //graph.DFS(2);
    }
}
