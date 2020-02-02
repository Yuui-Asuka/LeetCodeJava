package sumadd;

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

class SumAdd {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, current = head;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return head.next;
    }
}

public class Solution{
     public static void main(String[] args) {
         ListNode l1 = new ListNode(0);
         ListNode cur1 = l1;
         ListNode l2 = new ListNode(0);
         ListNode cur2 = l2;
         int[] num1 = {2, 7, 4};
         int[] num2 = {9, 0, 3};
         for(int i: num1){
             cur1.next = new ListNode(i);
             cur1 = cur1.next;
         }
         for (int i: num2){
             cur2.next = new ListNode(i);
             cur2 = cur2.next;
         }
         SumAdd add = new SumAdd();
         ListNode result = add.addTwoNumbers(l1.next, l2.next);
         System.out.println(result);
         
     }
}
