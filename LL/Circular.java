package LL;

import java.util.Scanner;

class Node{
    int data;
    Node prev;
    Node next;
}

class LinkedList{
    Node head;
    public void insertAtFirst(int data){
        Node node = new Node();
        node.data = data;
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
            Node temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = node;
        }
        head = node;
    }
    public void insertAtLast(int data){
        Node node = new Node();
        node.data = data;
        Node temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
        node.next = head;
    }
    public void insertAtPos(int index,int data){
        Node node = new Node();
        node.data = data;
        Node temp = head;
        for(int i=1;i<index;i++){
            temp = temp.next;
        }
        node.next = temp.next;
        node.prev = temp;
        temp.next.prev = node;
        temp.next = node;
    }
    public void print(){
        Node temp = head;
        while(temp.next !=head){
            System.out.print(temp.data);
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
    public void deleteAtFirst(){
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = head.next;
        head = head.next;
        head.prev = null;
    }
    public void deleteAtLast(){
        Node temp = head;
        while (temp.next.next !=head) {
            temp = temp.next;
        }
        temp.next = head;
    }
    public void deleteAtPos(int index){
        Node temp = head;
        for(int i=1;i<index -1;i++){
            temp = temp.next;
        }
        if(temp.next == null){
            deleteAtLast();
            return;
        }
        if(index == 1){
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
        LinkedList ll = new LinkedList();
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
                    exit = true;
                    break;
                default:
                    System.out.println("Enter valid choice");
                    break;
            }
        }
    }
}
