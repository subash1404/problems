package LL;

import java.util.HashMap;
import java.util.Map;

class Node{
    int val;
    Node next;
    Node random;

    Node(int val){
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPtr {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node temp = head;
        while(temp != null){
            Node node = new Node(temp.val);
            map.put(temp,node);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            Node node = map.get(temp);
                node.next = map.get(temp.next);
                node.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }

    public Node copyRandomListOptimal(Node head) {
        Node temp = head;
        while (temp != null) {
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = temp.next.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.random != null)
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        temp = head;
        Node dNode = new Node(-1);
        Node res = dNode;
        while (temp != null) {
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dNode.next;
    }
}
