package LinkedList._21MergeTwoSortedLists;

class Solution {
    public ListNode sort(ListNode head) {
        ListNode newNode = head;
        for(ListNode current = newNode; current.next != null; current = current.next) {
            for(ListNode pre = current.next; pre != null; pre = pre.next) {
                if (current.val > pre.val) {
                    int temp = current.val;
                    current.val = pre.val;
                    pre.val = temp;
                }
            }
        }
        return head;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        if ((list1 != null && list2 == null) || (list1 == null && list2 != null)) {
            return (list1 != null) ? list1 : list2;
        }

        ListNode head = new ListNode(0);

        ListNode current = list1;
        while(current.next != null) {
            current = current.next;
        }
        current.next = list2;

        head = sort(list1);
        return head;
    }
}



