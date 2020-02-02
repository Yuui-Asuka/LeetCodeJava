package mergetwolist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { this.val = x; }


    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class Solution {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
    ListNode head = new ListNode(0);
    ListNode p = l1, q = l2, current = head;
    List<Integer> list = new ArrayList<>();
    while (p!=null || q!=null){
        if(p != null) {
            list.add(p.val);
            p = p.next;
        }
        if (q!=null) {
            list.add(q.val);
            q = q.next;
        }
    }
        Collections.sort(list);
        for(int i: list){
            current.next = new ListNode(i);
            current = current.next;
        }
    return head.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(0);
        ListNode curr = l1;
        int[] a = {1};
        int[] b = {};
        ListNode l2 = new ListNode(0);
        ListNode curr2 = l2;
        for(int i: a){
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        for (int i: b){
            curr2.next = new ListNode(i);
            curr2 = curr2.next;
        }
        ListNode res = mergeTwoLists(l1.next, l2.next);
        System.out.println(res);
    }
}
