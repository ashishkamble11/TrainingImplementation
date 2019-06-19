package com.company;

public class BTreeDemo
{
    public static void main(String[] args)
    {
        BT tree=new BT();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);
        tree.insert(70);
        tree.insert(80);
        tree.insert(8);
        tree.insert(22);
        tree.insert(2);

        System.out.println("B Tree:");
        tree.preorder();

        tree.delete(60);
        System.out.println("B Tree:");
        tree.preorder();

        tree.delete(100);
        System.out.println("B Tree:");
        tree.preorder();
    }
}

class BTNode
{
    int data;
    BTNode left,right;

    BTNode(int data)
    {
        this.data=data;
        left=right=null;
    }
}

class BT
{
    BTNode root;

    void insert(int data)
    {
        root=insertNode(root,data);
    }
    BTNode insertNode(BTNode root, int data)
    {
        if (root == null)
            root = new BTNode(data);
        else
        {
            if (data <= root.data)
                root.left = insertNode(root.left, data);
            else
                root.right = insertNode(root.right, data);
        }
        return root;
    }

    void delete(int data)
    {
        if (root==null)
            System.out.println("Tree Empty");

        else if (search(data) == false)
            System.out.println("Sorry " + data + " is not present");
        else
        {
            root = deleteNode(root, data);
            System.out.println(data + " deleted from the tree.");
        }
    }
    BTNode deleteNode(BTNode root, int data)
    {
        BTNode temp1, temp2, n;
        if(root==null)
        {
            System.out.println("Tree Empty.");
        }
        if(root.data == data)
        {
            BTNode left, right;
            left = root.left;
            right = root.right;
            if (left == null && right == null)
                return null;
            else if (left == null)
            {
                temp1 = right;
                return temp1;
            }
            else if (right == null)
            {
                temp1 = left;
                return temp1;
            }
            else
            {
                temp2 = right;
                temp1 = right;
                while (temp1.left != null)
                    temp1 = temp1.left;
                temp1.left=left;
                return temp2;
            }
        }
        if (data < root.data)
        {
            n = deleteNode(root.left, data);
            root.left=n;
        }
        else
        {
            n = deleteNode(root.right, data);
            root.right=n;
        }
        return root;
    }

    boolean search(int data)
    {
        return searchNode(root, data);
    }
    boolean searchNode(BTNode root, int data)
    {
        boolean found=false;

        while(root!=null)
        {
            if(data<root.data)
            {
                root=root.left;
            }
            else if(data>root.data)
            {
                root=root.right;
            }
            else //if(data==root.data)
            {
                found=true;
                break;
            }
            searchNode(root,data);
        }

        return found;
    }

    public void preorder()
    {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(BTNode root)
    {
        if (root != null)
        {
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}