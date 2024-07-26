package LL;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class PlusOne {
    static Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;
        Node newHead = reverse(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    static Node addOneToLL(Node head) {
        head = reverse(head);
        Node temp = head;
        int carry = 1;
        while (temp != null) {
            int sum = temp.data + carry;
            if (sum < 10) {
                temp.data = sum;
                carry = 0;
                break;
            }
            temp.data = 0;
            temp = temp.next;
        }
        head = reverse(head);
        if (carry == 1) {
            Node node = new Node(1);
            node.next = head;
            return node;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(9);
        Node node = head;
        node.next = new Node(9);
        node = node.next;
        node.next = new Node(9);
        head = addOneToLL(head);
        while (head != null) {
            System.out.print(head.data);
            head = head.next;
        }
    }
}
