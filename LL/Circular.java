package LL;

import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;
}

class CircularLinkedList {
    Node head;

    public void insertAtFirst(int data) {
        Node node = new Node();
        node.data = data;
        if (head == null) {
            head = node;
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;

            node.next = head;
            node.prev = last;

            head.prev = node;
            last.next = node;

            head = node;
        }
    }

    public void insertAtLast(int data) {
        Node node = new Node();
        node.data = data;
        Node last = head.prev;
        // Node temp = head;
        // while (temp.next != head) {
        // temp = temp.next;
        // }
        last.next = node;
        node.prev = last;
        node.next = head;
        head.prev = node;
    }

    public void insertAtPos(int index, int data) {
        Node node = new Node();
        node.data = data;
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        node.prev = temp;
        temp.next.prev = node;
        temp.next = node;
    }

    public void print() {
        Node temp = head;
        while (temp.next != head) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    // public void sort(){
    // Node temp = head;
    // while(true){
    // Node index = temp.next;
    // while(index != head){
    // if(temp.data > index.data){
    // int val = temp.data;
    // temp.data = index.data;
    // index.data = val;
    // }
    // index = index.next;
    // }
    // if (temp.next == head) break;
    // else temp = temp.next;
    // }
    // }
    public void sort() {
        Node temp = head;
        while (temp.next != head) { // temp != head not needed as i loop in bubble sort goes only till n-1
            Node index = temp.next;
            while (index != head) {
                if (temp.data > index.data) {
                    int val = temp.data;
                    temp.data = index.data;
                    index.data = val;
                }
                index = index.next;
            }
            temp = temp.next;
        }
    }

    public void deleteAtFirst() {
        Node last = head.prev;
        last.next = head.next;
        head = head.next;
        head.prev = last;
    }

    public void deleteAtLast() {
        Node last = head.prev;
        last.prev.next = head;
        head.prev = last.prev.prev;
    }

    public void deleteAtPos(int index) {
        Node temp = head;
        for (int i = 1; i < index - 1; i++) {
            temp = temp.next;
        }
        if (temp.next == null) {
            deleteAtLast();
            return;
        }
        if (index == 1) {
            deleteAtFirst();
            return;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }
}

public class Circular {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList ll = new CircularLinkedList();
        boolean exit = false;
        while (!exit) {
            System.out.print("Enter choice :");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert: ");
                    int data = sc.nextInt();
                    ll.insertAtFirst(data);
                    break;
                case 2:
                    System.out.print("Enter data to insert: ");
                    data = sc.nextInt();
                    ll.insertAtLast(data);
                    break;
                case 3:
                    System.out.print("Enter data to insert: ");
                    data = sc.nextInt();
                    System.out.print("Enter pos :");
                    int index = sc.nextInt();
                    ll.insertAtPos(index, data);
                    break;
                case 4:
                    ll.deleteAtFirst();
                    break;
                case 5:
                    ll.deleteAtLast();
                    break;
                case 6:
                    System.out.print("Enter pos :");
                    index = sc.nextInt();
                    ll.deleteAtPos(index);
                    break;
                case 7:
                    ll.print();
                    break;
                case 8:
                    ll.sort();
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Enter valid choice");
                    break;
            }
        }
    }
}
