package com.practice.basics.linkedlist;

public class LinkedList {
    Node head;

    public static LinkedList insertAtBeginning(LinkedList list, int data){
        Node newNode = new Node(data);

        if(list.head == null)
            list.head = newNode;
        else{
            newNode.next = list.head;
            list.head = newNode;
        }
        return list;
    }


    public static LinkedList insertAtPosition(LinkedList list, int data, int position){
        Node head = list.head;
        while(position-- != 0 ){
            if(position == 1){
                Node newNode = new Node(data);
                newNode.next = head.next;
                head.next = newNode;
                break;
            }
            head = head.next;
        }
        return list;
    }

    public static LinkedList insertAtEnd(LinkedList list, int data){
        Node newNode = new Node(data);
        newNode.next = null;

        if(list.head == null)
            list.head = newNode;
        else{
            Node temp = list.head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
        return list;
    }

    public static LinkedList deleteAtBeginning(LinkedList list){
        if(list.head.next == null)
            return null;
        else{
            Node temp = list.head;
            list.head = temp.next;
        }
        return list;
    }

    public static LinkedList deleteAtEnd(LinkedList list){
        Node temp = list.head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return list;
    }

    public static void printList(LinkedList list){
        Node temp = list.head;
        System.out.print("LinkedList: ");
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list = insertAtEnd(list, 1);
        list = insertAtEnd(list,2);
        list = insertAtEnd(list,3);
        list = insertAtBeginning(list,4);
        list = insertAtBeginning(list , 5);
        list = insertAtPosition(list,7,3);
        list = insertAtPosition(list,10,4);
        list = deleteAtBeginning(list);
        list = deleteAtEnd(list);
        printList(list);
    }

}
