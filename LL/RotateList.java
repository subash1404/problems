package LL;
public class RotateList {
    public Node rotateRight(Node head, int k) {
        if (head == null || head.next == null)
            return head;
        Node fast = head;
        int count = 0;
        while (fast != null) {
            if (fast.next == null) {
                count++;
                break;
            }
            fast = fast.next.next;
            count += 2;
        }
        k = k % count;
        if (k == 0)
            return head;
        k = count - k - 1;
        Node temp = head;
        Node first = head;
        for (int i = 0; i < k; i++) {
            temp = temp.next;
        }
        Node next = temp.next;
        temp.next = null;
        head = next;
        while (next.next != null) {
            next = next.next;
        }
        next.next = first;
        return head;
    }
}
