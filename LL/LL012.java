package LL;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}
public class LL012 {
    static Node segregate(Node head) {
        if (head == null || head.next == null)
            return head;
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node threeHead = new Node(-1);
        Node headOne = oneHead;
        Node headTwo = twoHead;
        Node headThree = threeHead;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                headOne.next = temp;
                temp = temp.next;
                headOne = headOne.next;
            } else if (temp.data == 1) {
                headTwo.next = temp;
                temp = temp.next;
                headTwo = headTwo.next;
            } else {
                headThree.next = temp;
                temp = temp.next;
                headThree = headThree.next;
            }
        }
        headOne.next = (twoHead.next != null) ? twoHead.next : threeHead.next;
        headTwo.next = threeHead.next;
        headThree.next = null;
        return oneHead.next;
    }
}
