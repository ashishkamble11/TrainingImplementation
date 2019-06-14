package com.company;

import java.util.Scanner;

public class Array
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int[][] arr=new int[3][2];
                //{{0,0,1},{0,1,2},{1,0,3},{1,1,4}};
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<2;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println("Array Elements:");
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<2;j++)
            {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}