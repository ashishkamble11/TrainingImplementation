package com.company;

public class AVLDemo
{
    Node root;

    int height(Node node)
    {
        if(node==null)
            return 0;

        return node.height;
    }

    void updateHeight(Node node)
    {
        if(node==null)
            return;

        node.height=max(height(node.left),height(node.right))+1;
    }

    int max(int a, int b)
    {
        return (a>b) ? a : b;
    }

    Node rightRotate(Node y)
    {
        Node x=y.left;
        Node t2=x.right;

        x.right=y;
        y.left=t2;

        y.height=max(height(y.left),height(y.right))+1;
        x.height=max(height(x.left),height(x.right))+1;

        return x;
    }

    Node leftRotate(Node x)
    {
        Node y=x.right;
        Node t2=y.left;

        y.left=x;
        x.right=t2;

        x.height=max(height(x.left),height(x.right))+1;
        y.height=max(height(y.left),height(y.right))+1;

        return y;
    }

    int getBalance(Node node)
    {
        if(node==null)
            return 0;
        return  height(node.left)-height(node.right);
    }

    int getMinValue(Node node)
    {
        if(node==null)
            return Integer.MIN_VALUE;

        if(node.left==null)
            return node.key;

        return getMinValue(node.left);
    }

    Node insert(Node node, int key)
    {
        if(node==null)
            return (new Node(key));

        if(key<node.key)
        {
            node.left=insert(node.left,key);
        }
        else if(key>node.key)
        {
            node.right=insert(node.right,key);
        }
        else
            return node;

        node.height=1+max(height(node.left),height(node.right));

        int balance=getBalance(node);

        if(balance > 1 && key < node.left.key)
        {
            return rightRotate(node);
        }
        if(balance < -1 && key > node.right.key)
        {
            return leftRotate(node);
        }
        if(balance > 1 && key > node.left.key)
        {
            node.left=leftRotate(node.left);
            return rightRotate(node);
        }
        if(balance < -1 && key < node.right.key)
        {
            node.right=rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    Node delete(Node node, int key)
    {
        if(node==null)
            return null;

        if(key<node.key)
        {
            node.left=delete(node.left, key);
        }
        else if(key>node.key)
        {
            node.right=delete(node.right, key);
        }
        else
        {
            if (node.left == null)
            {
                node = node.right;
            }
            else if (node.right == null)
            {
                node = node.left;
            }

            else
            {
                int min = getMinValue(node.right);
                node.key = min;
                node.right = delete(node.right, min);
            }
        }
        if(node==null)
        {
            return null;
        }
        updateHeight(node);
        int balance=getBalance(node);

        if(balance>1)
        {
            if(getBalance(node.left)>=0)
            {
                node=rightRotate(node);
            }
            else
            {
                node.left=leftRotate(node.left);
                node=rightRotate(node);
            }
        }

        else if(balance<-1)
        {
            if(getBalance(node.right)<=0)
            {
                node=leftRotate(node);
            }
            else
            {
                node.right=rightRotate(node.right);
                node=leftRotate(node);
            }
        }
        return node;
    }

    void printPreOrder(Node node)
    {
        if(node==null)
            return;

        System.out.println(node.key);
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public static void main(String[] args)
    {
        AVLDemo avl=new AVLDemo();
        avl.root=avl.insert(avl.root,10);
        avl.root=avl.insert(avl.root,20);
        avl.root=avl.insert(avl.root,30);
        avl.root=avl.insert(avl.root,40);
        avl.root=avl.insert(avl.root,50);
        avl.root=avl.insert(avl.root,25);

        System.out.println();
        avl.printPreOrder(avl.root);

        avl.root=avl.delete(avl.root, 25);

        System.out.println();
        avl.printPreOrder(avl.root);
    }
}

class Node
{
    int key, height;
    Node left, right;

    Node(int key)
    {
        this.key=key;
        height=1;
    }
}