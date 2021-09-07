package com.practice.basics.trees;

import java.util.Scanner;

public class BinaryTree {
    Scanner scanner = new Scanner(System.in);
    class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }
    private Node root;

    public void createTree(){
        root = createTree(null,"");
    }

    private Node createTree(Node parent, String lr) {
        if(parent == null){
            System.out.println("Enter root node value: ");
        }else
            System.out.println("Enter the value of "+ lr+ "child of "+parent.data);
        int val = scanner.nextInt();
        Node n = new Node(val);
        System.out.println("Is there a left child of this node: ");
        boolean f = scanner.nextBoolean();
        if(f){
            n.left = createTree(n,"left");
        }
        System.out.println("Is there a right child of this node: ");
        f = scanner.nextBoolean();
        if(f){
            n.right = createTree(n,"right");
        }
        return n;
    }

    public void display(){
        display(this.root);
    }

    private void display(Node node) {
        if(node.left != null)
            System.out.print(node.left.data+" ");
        System.out.print("<-- "+node.data+" --> ");
        if(node.right != null)
            System.out.println(node.right.data+" ");
        System.out.println();
        if(node.left != null)
            display(node.left);
        if(node.right != null)
            display(node.right);
    }

    //size
    public int size(){
        return size(this.root);
    }
    //O(n) -> no of nodes T(n) = 2T(n/2)+O(1)
    private int size(Node node) {
        if(node == null)
            return 0;
        else{
            int count = 0;
            count+=size(node.left);
            count+=size(node.right);
            return count+1;
        }
    }

    //height
    public int height(){
        return height(this.root);
    }

    private int height(Node node) {
        if(node == null)
            return -1;
        else{
            int ht = Math.max(height(node.right),height(node.left));
            return ht+1;
        }
    }
}
