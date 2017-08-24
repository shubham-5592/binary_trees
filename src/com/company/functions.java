package com.company;

import java.util.*;

public class functions {


    public static void inorderTraversal(Node node)
    {
        if(node == null)
        {
            System.out.print("Empty Tree");
        }
        else
        {
            inorderTraversalUtil(node);
        }
    }


    public static void inorderTraversalUtil(Node node)
    {
        if(node == null)
        {
            return;
        }
        else
        {
            inorderTraversal(node.left);
            System.out.print(node.key + ", ");
            inorderTraversal(node.right);
        }
    }

    public static void preOrderTraversal(Node node)
    {
        if(node == null)
        {
            System.out.print("Empty Tree");
        }
        else
        {
            preOrderTraversalUtil(node);
        }
    }

    public static void preOrderTraversalUtil(Node node)
    {
        if(node == null)
        {
            return;
        }
        else
        {
            System.out.print(node.key + ", ");
            inorderTraversal(node.left);
            inorderTraversal(node.right);
        }
    }

    public static void postOrderTraversal(Node node)
    {
        if(node == null)
        {
            System.out.print("Empty Tree");
        }
        else
        {
            postOrderTraversalUtil(node);
        }
    }

    public static void postOrderTraversalUtil(Node node)
    {
        if(node == null)
        {
            return;
        }
        else
        {
            inorderTraversal(node.left);
            inorderTraversal(node.right);
            System.out.print(node.key + ", ");
        }
    }

    public static int height(Node node)
    {
        if (node == null) // case where one of the child is null and
        {                 //  other one is not is handled here
            return 0;
        }
        else if(node.left == null && node.right == null) //leaf node case
        {
            return 1;
        }
        else
        {
            int r = height(node.right);
            int l = height(node.left);
            return r>l? r+1:l+1;
        }
    }

    public static void levelOrderTraversal(Node node)
    {
        if(node == null)
        {
            System.out.print("Empty Tree");
        }
        else
        {
            int h = height(node);
            for(int i = 0; i<h ; i++)
            {
                levelOrderTraversalUtil(node,i);
                System.out.print("\n\n");
            }
        }
    }

    public static void levelOrderTraversalUtil(Node node, int level)
    {
        if (node == null)
        {
            return;
        }
        else if (level == 0)
        {
            System.out.print(node.key + ", ");
        }
        else if (level > 1)
        {
            levelOrderTraversalUtil(node.left, level-1);
            levelOrderTraversalUtil(node.right, level-1);
        }
    }

    public static void reverseLevelOrderTraversal(Node node)
    {
        if(node == null)
        {
            System.out.print("Empty Tree");
        }
        else
        {
            int h = height(node);
            for(int i=h; i>0 ; i--)
            {
                levelOrderTraversalUtil(node,i);
                System.out.print("\n\n");
            }
        }
    }


    //TODO complete this.

    public static void printPostOrder(int[] in, int[] pre, int n)
    {

    }

    /*

    Leaf traversal is sequence of leaves traversed from left to right.
    The problem is to check if leaf traversals of two given Binary Trees are same or not.

    Input: Roots of below Binary Trees
         1
	    / \
       2   3
      /   / \
     4   6   7

	      0
	    /  \
       5    8
        \  / \
        4  6  7
Output: same
Leaf order traversal of both trees is 4 6 7

Input: Roots of below Binary Trees
         0
	    / \
       1   2
      / \
     8   9

         1
        / \
       4   3
        \ / \
        8 2  9

Output: Not Same
Leaf traversals of two trees are different.
For first, it is 8 9 2 and for second it is
8 2 9

     */

    /*

    we need to traverse both trees together, and compare each leaf that is encountered.

     */

    public static boolean compareLeafs(Node n1, Node n2)
    {
        if(n1 == null)
        {
            System.out.print("N1 NULL");
            return false;
        }
        else if (n2 == null)
        {
            System.out.print("N2 NULL");
            return false;
        }
        else
        {
            // Create empty stacks.  These stacks are going
            // to be used for iterative traversals.
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();

            s1.push(n1);
            s2.push(n2);

            // Loop until either of two stacks is not empty
            while (!s1.empty() || !s2.empty())
            {
                // If one of the stacks is empty means other
                // stack has extra leaves so return false
                if (s1.empty() || s2.empty())
                    return false;

                Node temp1 = s1.pop();
                while (temp1!=null && !isLeaf(temp1))
                {
                    // Push right and left children of temp1.
                    // Note that right child is inserted
                    // before left
                    if (temp1.right != null)
                        s1.push(temp1. right);
                    if (temp1.left != null)
                        s1.push(temp1.left);
                    temp1 = s1.pop();
                }

                // same for tree2
                Node temp2 = s2.pop();
                while (temp2!=null && !isLeaf(temp2))
                {
                    if (temp2.right != null)
                        s2.push(temp2.right);
                    if (temp2.left != null)
                        s2.push(temp2.left);
                    temp2 = s2.pop();
                }

                // If one is null and other is not, then
                // return false
                if (temp1==null && temp2!=null)
                    return false;
                if (temp1!=null && temp2==null)
                    return false;

                // If both are not null and data is not
                // same return false
                if (temp1!=null && temp2!=null)
                {
                    if (temp1.key != temp2.key)
                        return false;
                }
            }

            // If control reaches this point, all leaves
            // are matched
            return true;


        }

    }

    public static boolean isLeaf(Node n)
    {
        if (n == null)
            return false;
        else if (n.left == null && n.right == null)
            return true;
        else
            return false;
    }


    /*
           1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9


The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9
     */

    public static void verticalTraversal(Node n)
    {

        if(n != null)
        {
            SortedMap<Integer, Vector<Integer>> h = new TreeMap<>();
            verticalTraversalUtil(n, 0, h);

            for (Vector<Integer> i : h.values())
            {
                for (int j: i)
                {
                    System.out.print(j +", ");
                }
                System.out.println();
            }
        }
        else
        {
            System.out.print("Empty Tree bro!");
        }



    }

    public static void verticalTraversalUtil(Node n, int l, SortedMap<Integer, Vector<Integer>> h)
    {

        if(n != null)
        {
            if(h.containsKey(l))
            {
                h.get(l).add(n.key);
                verticalTraversalUtil(n.left, l-1, h);
                verticalTraversalUtil(n.right, l+1, h);
            }
            else
            {
                Vector<Integer> temp = new Vector<>();
                temp.add(n.key);
                h.put(l,temp);
                verticalTraversalUtil(n.left, l-1, h);
                verticalTraversalUtil(n.right, l+1, h);
            }
        }
    }

    //<editor-fold desc="Boundary Traversal">

    public static void printLeftEdgesTopDown(Node n)
    {
        if(n != null)
        {

            if(n.left != null)
            {
                System.out.println(n.key);
                printLeftEdgesTopDown(n.left);
            }
            else if(n.right != null)
            {
                System.out.println(n.key);
                printLeftEdgesTopDown(n.right);
            }
        }
    }

    public static void printLeavesLeftRight(Node n)
    {
        if(n != null)
        {
            if ( n.left == null && n.right == null)
            {
                System.out.println(n.key);
            }
            printLeavesLeftRight(n.left);
            printLeavesLeftRight(n.right);
        }
    }

    public static void printRightEdgesDownTop(Node n)
    {
        if(n != null)
        {

            if(n.right != null)
            {
                printRightEdgesDownTop(n.right);
                System.out.println(n.key);
            }
            else if(n.left != null)
            {
                printRightEdgesDownTop(n.left);
                System.out.println(n.key);
            }
        }
    }

    public static void boundaryTraversal(Node n)
    {
        if(n == null)
        {
            System.out.println("EMPTY TREE BRO");
        }
        else
        {
            printLeftEdgesTopDown(n);
            printLeavesLeftRight(n);
            printRightEdgesDownTop(n.right);
        }
    }

    //</editor-fold>

    /// REQUIRES A PERFECT TREE
    public static void differentTypeLevelOrder(Node n)
    {
        if(n!=null)
        {
            System.out.print(n.key + ", ");
            if (n.left != null)
                System.out.print(n.left.key + ", " + n.right.key+", ");
            if (n.left.left !=null)
            {
                Queue<Node> queue = new LinkedList<>();
                queue.add(n.left);
                queue.add(n.right);
                Node first = null;
                Node second = null;
                while(!queue.isEmpty())
                {
                    first = queue.peek();
                    queue.remove();
                    second = queue.peek();
                    queue.remove();

                    System.out.print(first.left.key + ", " + second.right.key + ", ");
                    System.out.print(first.right.key + ", " + second.left.key + ", ");

                    if(first.left.left !=null)
                    {
                        queue.add(first.left);
                        queue.add(second.right);
                        queue.add(first.right);
                        queue.add(second.left);

                    }


                }
                System.out.println();
            }
        }
        else
        {
            System.out.println("Tree empty hai bro");
        }
    }


}
