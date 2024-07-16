package LL;

import java.util.HashMap;

public class LoopInLL {
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
  // Find the starting point of a loop using Hashing 
  public ListNode detectCycle(ListNode head) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        ListNode temp = head;
        while(temp != null){
            if(map.containsKey(temp)){
                return temp;
            }
            map.put(temp,1);
            temp = temp.next;
        }
        return null;
    }
    //Find the starting point of a loop using Tortoise Hare
     public ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                slow = head;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    // Detect a loop in LL using tortiose Hare
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode fp = head.next;
        ListNode sp = head;
        while (fp != sp) {
            if (fp.next == null || fp.next.next == null) {
                return false;
            }
            fp = fp.next.next;
            sp = sp.next;
        }
        return true;
    }

    // Reverse a linked list using recursion
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    // Find the length of a loop
    static int countNodesinLoop(Node head) {
        HashMap<Node, Integer> map = new HashMap<>();
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return index - map.get(temp);
            }
            map.put(temp, index++);
            temp = temp.next;
        }
        return 0;
    }
    // Find the length of the loop (Tortoise Hare)
    static int countNodesinLoop2(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                int count = 1;
                fast = fast.next;
                while (fast != slow) {
                    fast = fast.next;
                    count++;
                }
                return count;
            }
        }
        return 0;
    }
}
