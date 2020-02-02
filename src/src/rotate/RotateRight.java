package rotate;

import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}


public class RotateRight {
    public static ListNode rotateRight(ListNode head, int k){
    ListNode cur = head;
    Deque<Integer> queue = new LinkedList<>();
    while (cur != null){
    queue.offer(cur.val);
    cur = cur.next;
    }
    if (queue.isEmpty()){return null;}
    for (int i = 0; i < k%queue.size(); i++){
        queue.offerFirst(queue.pollLast());
    }
    ListNode list = new ListNode(0);
    ListNode h = list;
    for (int i: queue){
        h.next = new ListNode(i);
        h = h.next;
    }
    return list.next;
    }

    public static ListNode rotateRight2(ListNode head, int k) {
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;

        // close the linked list into the ring
        ListNode old_tail = head;
        int n;
        for(n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;


        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(0);
        ListNode cur = l1;
        int[] num = {1,2,3,4,5};
        for (int i: num){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
       ListNode node = rotateRight(l1.next, 2);
     //   ListNode node2 = rotateRight2(l1.next, 20);
        System.out.println(node);
      //  System.out.println(node2);
    }
}
