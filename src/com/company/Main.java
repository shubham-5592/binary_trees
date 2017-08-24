package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Node tree;

        tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);
        tree.right.left.right = new Node(8);
        tree.right.right.right = new Node(9);

        //System.out.print("Boundary traversal IS : ");
        //functions.boundaryTraversal(tree);

        Node perfectTree;

        perfectTree = new Node(1);
        perfectTree.left = new Node(2);
        perfectTree.right = new Node(3);

        perfectTree.left.left = new Node(4);
        perfectTree.left.right = new Node(5);
        perfectTree.right.left = new Node(6);
        perfectTree.right.right = new Node(7);

        perfectTree.left.left.left = new Node(8);
        perfectTree.left.left.right = new Node(9);
        perfectTree.left.right.left = new Node(10);
        perfectTree.left.right.right = new Node(11);
        perfectTree.right.left.left = new Node(12);
        perfectTree.right.left.right = new Node(13);
        perfectTree.right.right.left = new Node(14);
        perfectTree.right.right.right = new Node(15);

        perfectTree.left.left.left.left = new Node(16);
        perfectTree.left.left.left.right = new Node(17);
        perfectTree.left.left.right.left = new Node(18);
        perfectTree.left.left.right.right = new Node(19);
        perfectTree.left.right.left.left = new Node(20);
        perfectTree.left.right.left.right = new Node(21);
        perfectTree.left.right.right.left = new Node(22);
        perfectTree.left.right.right.right = new Node(23);
        perfectTree.right.left.left.left = new Node(24);
        perfectTree.right.left.left.right = new Node(25);
        perfectTree.right.left.right.left = new Node(26);
        perfectTree.right.left.right.right = new Node(27);
        perfectTree.right.right.left.left = new Node(28);
        perfectTree.right.right.left.right = new Node(29);
        perfectTree.right.right.right.left = new Node(30);
        perfectTree.right.right.right.right = new Node(31);

        System.out.println("Alag se level order traversal : ");
        functions.differentTypeLevelOrder(perfectTree);
    }
}
