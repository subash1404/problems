package LL;
import java.util.*;
class Node{
    int data;
    Node next;
}

class LinkedList{
    Node head;
    public void insertAtLast(int data){
        Node node = new Node();
        node.data = data;
        node.next = null;
        if(head == null){
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }
    public void insertAtFirst(int data){
        Node node = new Node();
        node.data = data;
        node.next = head;
        head = node;
    }
    public void insertAtPos(int index,int data){
        if(index < 0){
            System.out.println("Negative Index");
            return;
        }
        if(index == 1){
            insertAtFirst(data);
            return;
        }
        Node node = new Node();
        node.data = data;
        Node temp = head;
        for(int i=0;i<index-1;i++){
            // temp = temp.next;
            if(temp.next != null){
                temp = temp.next;
                System.out.println(temp.data);
            }else{
                System.out.println("Index out of bounds");
                return;
            }
        }
        node.next = temp.next;
        temp.next = node;
    }
    public void deleteAtFirst(){
        head = head.next;
    }
    public void deleteAtLast(){
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }
    public void deleteAtPos(int index){
        if(index == 0) {
            deleteAtFirst();
            return;
        }
        if(index < 0){
            System.out.println("Negative Index");
            return;
        }
        Node temp = head;
        for(int i=0;i<index -1;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
    public void print(){
        Node temp = head;
        while(temp.next != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}
public class Singly {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        boolean exit = false;
        while(!exit){
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
