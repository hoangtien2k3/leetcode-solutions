package LinkedList._24SwapNodesInPairs;

import java.util.ArrayList;
import java.util.List;

public class Solution {
//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode previus = head;
//        ListNode current = head.next;
//        ListNode next = head.next.next;
//
//        head = current;
//        head.next = previus;
//        head.next.next = swapPairs(next);
//
//        return head;
//    }


    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head; // node đầu tiên danh sách
        ListNode prev = dummy;

        while (head != null && head.next != null) {
            ListNode list1 = head;
            ListNode list2 = head.next;

            prev.next = list2;
            list1.next = list2.next;
            list2.next = list1;

            prev = list1;
            head = list1.next;
        }

        return dummy.next;
    }
}
