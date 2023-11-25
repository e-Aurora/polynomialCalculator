package Homework;

public class LinkedList {
    Node head;

    LinkedList() {
        head = null;
    }

    LinkedList(Node head) {
        this.head = head;
    }

    void print(){
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void add(int data) {
        Node temp = head;
        if(head == null) {
            head = new Node(data);
            return;
        }
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    Node insert(int index, int data) {
        Node temp = head;
        Node newNode = new Node(data);
        if(index == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        for(int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    Node deleteI(int index) {
        Node temp = head;
        if(index == 0) {
            head = head.next;
            return head;
        }
        for(int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    Node deleteD(int data) {
        Node temp = head;
        if(head.data == data) {
            head = head.next;
            return head;
        }
        while(temp.next.data != data) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    int get(int index) {
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    void set(int index, int data) {
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.data = data;
    }

}

class Node{
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node() {
        this.data = 0;
        this.next = null;
    }

}
