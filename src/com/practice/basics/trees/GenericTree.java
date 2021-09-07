package com.practice.basics.trees;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {
    Scanner scanner = new Scanner(System.in);
    private class Node{
        int data;
        ArrayList<Node> children;

        public Node(int val) {
            data = val;
            children = new ArrayList<>();
        }

        public Node(){
            this(0);
        }
    }
    private Node root;

    public void createTree(){
        root = createTree(null,-1);
    }
    private Node createTree(Node parent, int ith){
        if(parent == null){
            System.out.println("Enter root node value ");
        }else{
            System.out.println("Enter the value of "+ith+" child of "+parent.data);
        }
        int val = scanner.nextInt();
        Node n = new Node(val);
        System.out.println("Enter no of children for this node: ");
        int noc = scanner.nextInt();
        for(int i = 0 ; i < noc ; i++){
            Node child = createTree(n,i);
            n.children.add(child);
        }
        return n;

    }
    //O(no of nodes)
    public void display(){
        display(root);
    }

    private void display(Node node){
        System.out.print(node.data+" -->");
        for(int i = 0 ; i < node.children.size() ; i++){
            System.out.println(node.children.get(i).data+" ");
        }
        System.out.println();
        for(Node child: node.children){
            display(child);
        }
    }

    //no of nodes(size)
    public int size(){
        return size(root);
    }

    private int size(Node node){
        int count = 0;
        for(Node child: node.children){
            count+=size(child);
        }
        return count+1;
    }

    //height of tree
    public int height(){
        return height(root);
    }

    private int height(Node node) {
        int ht = 0;
        for(Node child: node.children){
            int th = height(child);
            ht = Math.max(ht,th);
        }
        return ht+1;

    }

    //search for a no return true if it exist else false
    public boolean search(int no){
        return search(root,no);
    }

    private boolean search(Node node, int no) {
        if(node.data == no){
            return true;
        }else{
            for(Node child: node.children){
                boolean isPresent = search(child,no);
                if(isPresent){
                    return true;
                }
            }
            return false;
        }
    }
}
