package com.company;

public class DijkstraShortestPath
{

    static final int V=6;

    int minDistance(int dist[], boolean sptset[])
    {
        int min=Integer.MAX_VALUE, min_index=-1;

        for(int i=0; i<V; i++)
        {
            if(sptset[i] == false && dist[i] <= min)
            {
                min=dist[i];
                min_index=i;
            }
        }
        return min_index;
    }

    void printGraph(int dist[], int n)
    {
        System.out.println("Vertex\tDistance from source:");
        for(int i=0;i<V;i++)
        {
            System.out.println(i+"\t"+dist[i]);
        }
    }

    void shortestPath(int graph[][], int src)
    {
        int dist[]=new int[V];
        boolean sptset[]=new boolean[V];

        for(int i=0;i<V;i++)
        {
            dist[i]=Integer.MAX_VALUE;
            sptset[i]=false;
        }

        dist[src]=0;

        for(int j=0;j<V-1;j++)
        {
            int minDist=minDistance(dist,sptset);
            sptset[minDist]=true;
            for(int i=0;i<V;i++)
            {
                if(!sptset[i] && graph[minDist][i]!=0 && dist[minDist]!=Integer.MAX_VALUE && dist[minDist]+graph[minDist][i]<dist[i])
                {
                    dist[i]=dist[minDist]+graph[minDist][i];
                }
            }
        }
        printGraph(dist,V);
    }

    public static void main(String[] args)
    {
        int graph[][]=new int[][]
                {
                        {0,4,0,0,0,0},
                        {4,0,8,0,0,0},
                        {0,8,0,7,0,4},
                        {0,0,7,0,9,14},
                        {0,0,0,9,0,10},
                        {0,0,4,14,10,0}
                };

        DijkstraShortestPath dsp=new DijkstraShortestPath();
        dsp.shortestPath(graph,0);
    }
}
