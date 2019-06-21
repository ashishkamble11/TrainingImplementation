package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class JobSequencing
{
    static class Jobs
    {
        char jobId;
        int deadline;
        int profit;

        Jobs(char id, int deadl, int prft)
        {
            this.jobId=id;
            this.deadline=deadl;
            this.profit=prft;
        }
    }

    static class Sorting implements Comparator
    {
        @Override
        public int compare(Object o1, Object o2)
        {
            Jobs j1=(Jobs)o1;
            Jobs j2=(Jobs)o2;

            if(j1.profit != j2.profit)
                return j2.profit - j1.profit;
            else
                return j2.deadline - j1.deadline;
        }
    }

    static void jobSequence(Jobs jobs[], int n)
    {
        Sorting sort=new Sorting();

        Arrays.sort(jobs,sort);

        TreeSet<Integer> ts=new TreeSet<>();

        for(int i=0; i<n; i++)
        {
            ts.add(i);
        }
        for(int i=0; i<n; i++)
        {
            Integer x = ts.floor(jobs[i].deadline - 1);

            if (x != null) {
                System.out.print(jobs[i].jobId + " ");
                ts.remove(x);
            }

        }
    }

    public static void main(String args[])
    {
        int n=6;
        Jobs[] jobs=new Jobs[n];

        jobs[0]=new Jobs('a',2,100);
        jobs[1]=new Jobs('b',1,19);
        jobs[2]=new Jobs('c',2,27);
        jobs[3]=new Jobs('d',1,25);
        jobs[4]=new Jobs('e',3,15);
        jobs[5]=new Jobs('f',2,50);

        jobSequence(jobs,n);
    }
}
