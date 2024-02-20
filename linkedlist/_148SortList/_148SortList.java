package linkedlist._148SortList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void insert(int value) {
        ListNode listNode = new ListNode(value);
        ListNode current = this;
        while(current.next != null) {
            current = current.next;
        }
        current.next = listNode;
    }

    public void printList() {
        ListNode current = this;
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Find middle node
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // Splitting the list

        // Recursively sort two halves
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        // Merge the sorted halves
        return merge(left, right);
    }

    // merge single linked list
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if (left != null)
            current.next = left;
        else if (right != null)
            current.next = right;

        return dummy.next;
    }
}

public class _148SortList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.insert(2);
        listNode.insert(1);
        listNode.insert(3);

        listNode.printList();
        Solution solution = new Solution();
        ListNode result = solution.sortList(listNode);

        result.printList();
    }
}
