package LL;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1, head2 = l2;
        int carry = 0;
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        while (head1 != null || head2 != null) {
            int sum = carry;
            if (head1 != null) {
                sum += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.val;
                head2 = head2.next;
            }
            ListNode node = new ListNode(sum % 10);
            curr.next = node;
            curr = curr.next;
            carry = sum / 10;
        }
        if (carry == 1) {
            ListNode node = new ListNode(carry);
            curr.next = node;
        }
        return dummyNode.next;
    }
}
