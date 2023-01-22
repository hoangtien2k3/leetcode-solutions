package LinkedList._23MergeKSortedLists;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode();
        ListNode temp = merged;

        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if (list1 != null) {
            temp.next = list1; // liên kết tiếp các phần tử còn sót
        }
        if (list2 != null) {
            temp.next = list2;
        }

        return merged.next; // phần tủ đầu tiên
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        while(lists.length > 1) {
            List<ListNode> list = new ArrayList<>();
            for(int i = 0; i < lists.length; i += 2) {
                ListNode list1 = lists[i];
                ListNode list2 = null;
                if (lists.length > (i + 1)) { //
                    list2 = lists[i + 1];
                }
                ListNode result = mergeTwoLists(list1, list2);
                list.add(result);
            }

            ListNode[] array = new ListNode[list.size()];
            array = list.toArray(array); // chuyển cái list thành mảng và gán ngược lại có array đó.
            lists = array;
        }

        return lists[0]; // tại vì lists là kiểu mảng, mà lists[0]: là liểu ListNode. (với cần return phần tử đầu trong mảng)
    }
}
