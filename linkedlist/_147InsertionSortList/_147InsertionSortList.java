package linkedlist._147InsertionSortList;

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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newNode = new ListNode(0);
        ListNode prev = newNode;

        while(head != null) {
           ListNode next = head.next;

           if (prev.val >= head.val)
               prev = newNode;

           while(prev.next != null && prev.next.val < head.val) {
               prev = prev.next;
           }

           head.next = prev.next;
           prev.next = head;

           head = next;
        }

        return newNode.next;
    }
}

public class _147InsertionSortList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.insert(2);
        listNode.insert(1);
        listNode.insert(3);

        listNode.printList();

        Solution solution = new Solution();
        ListNode resultListNode = solution.insertionSortList(listNode);
        resultListNode.printList();
    }
}
