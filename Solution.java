public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode head = new ListNode(0);
        ListNode iter = head;
        int carry = 0;
        while(l1 != null && l2 != null){
            int num = l1.val + l2.val + carry;
            carry = num/10;
            num %= 10;
            iter.next = new ListNode(num);
            iter = iter.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l2 != null){
            l1 = l2;
        }
        while(l1 != null){
            int num = l1.val + carry;
            carry = num/10;
            num %= 10;
            iter.next = new ListNode(num);
            iter = iter.next;
            l1 = l1.next;
        }
        if(carry != 0){
            iter.next = new ListNode(carry);
            iter = iter.next;
        }
        iter.next = null;
        iter = head.next;
        return iter;
    }
}