package partition;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class Partition {
    public static ListNode partition(int x, ListNode l1) {
        ListNode p = l1;
        ListNode before = new ListNode(0);
        ListNode be = before;
        ListNode after = new ListNode(0);
        ListNode af = after;
        while (p!=null){
            if (p.val < x){
                be.next = new ListNode(p.val);
                be = be.next;
            }
            else {
                af.next = new ListNode(p.val);
                af = af.next;
            }
            p = p.next;
        }
        be.next = after.next;
        return before.next;
    }


public static void main(String[] args){
        ListNode l1 = new ListNode(0);
        ListNode cur = l1;
        int[] a = {1,2,4,3,5,4,2,2};
        for(int i: a){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode res = partition(3, l1.next);
        System.out.println(res);
    }
}
