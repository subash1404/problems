package LL;

public class OddEvenLL {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode odd = head;
        // Save ref of even head
        ListNode evenHead = head.next;
        ListNode even = head.next;
        // Break the Linkage and seperate even and odd nodes into seperate Linked lists
        while (even != null && even.next != null) {
            ListNode nextOdd = odd.next.next;
            ListNode nextEven = even.next.next;
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = nextOdd;
            even = nextEven;
        }
        // Append the even Linked list at the end of odd LL
        odd.next = evenHead;
        return head;
    }
}
