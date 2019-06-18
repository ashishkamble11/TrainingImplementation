package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class BTDemo
{
    class Node
    {
        int data;
        Node left,right;

        Node(int data)
        {
            this.data=data;
            left=right=null;
        }
    }

    Node root;

    BTDemo()
    {
        root=null;
    }

    void printTreeFormat()
    {
        if(root == null)
            return;

        Queue<Node> q =new LinkedList<Node>();

        q.add(root);

        while(true)
        {
            int nodeCount = q.size();
            if(nodeCount == 0)
                break;

            while(nodeCount > 0)
            {
                Node node = q.peek();
                System.out.print(node.data + " ");
                q.remove();
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                nodeCount--;
            }
            System.out.println();
        }
    }

    void preOrder()
    {
        printPreOrder(root);
    }
    void printPreOrder(Node root)
    {
        if(root==null)
            return;

        System.out.println(root.data);
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    void postOrder()
    {
        printPostOrder(root);
    }
    void printPostOrder(Node root)
    {
        if(root==null)
            return;

        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.println(root.data);
    }

    void inOrder()
    {
        printInOrder(root);
    }
    void printInOrder(Node root)
    {
        if(root==null)
            return;

        printInOrder(root.left);
        System.out.println(root.data);
        printInOrder(root.right);
    }

    //inserting in a bst manner
    void insert(int x)
    {
        root=insertNode(root,x);
    }
    Node insertNode(Node root, int x)
    {
        if(root==null)
        {
            root=new Node(x);
            return root;
        }
        else
        {
            if(x<=root.data)
            {
                if(root.left!=null)
                {
                        insertNode(root.left,x);
                }
                else
                {
                    root.left=new Node(x);
                }
            }
            else if(x>=root.data)
            {
                if(root.right!=null)
                {
                        insertNode(root.right,x);
                }
                else
                {
                    root.right=new Node(x);
                }
            }
        }
        return root;
    }


    void delete(int x)
    {
        root=deleteNode(root,x);
    }
    Node deleteNode(Node root, int x)
    {
        if(root==null)
        {
            return root;
        }

        if(x<root.data)
        {
            root.left=deleteNode(root.left,x);
        }
        else if(x>root.data)
        {
            root.right=deleteNode(root.right,x);
        }
        else
        {
            //Checking for node with one child
            //if(node.left==null && node.right==null)
                //return root;
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;

            //node with two childs
            root.data=minValue(root.right);
            //int newData=minValue(root.right);
            root.right=deleteNode(root.right,root.data);
        }
        return root;
    }

    int minValue(Node root)
    {
        int minV=root.data;
        while(root.left!=null)
        {
            minV=root.left.data;
            root=root.left;
        }
        return minV;
    }

    public static void main(String[] args)
    {
        BTDemo bt =new BTDemo();
        bt.insert(50);
        bt.insert(30);
        bt.insert(20);
        bt.insert(40);
        bt.insert(70);
        bt.insert(60);
        bt.insert(80);

        System.out.println("Preorder:");
        bt.preOrder();
        System.out.println("Postorder:");
        bt.postOrder();
        System.out.println("Inorder:");
        bt.inOrder();

        System.out.println();
        bt.printTreeFormat();

        System.out.println("Deleting 50:");
        bt.delete(20);
        bt.printTreeFormat();
    }
}
