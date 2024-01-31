package linkedlist._160IntersectionOfTwoLinkedLists;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
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
            System.out.println(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode a = headA;
        ListNode b = headB;
        while(a != b){
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }
}

public class _160IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode listNode1 = new ListNode(4);
        listNode1.insert(1);
        listNode1.insert(8);
        listNode1.insert(4);
        listNode1.insert(5);

        ListNode listNode2 = new ListNode(5);
        listNode2.insert(6);
        listNode2.insert(1);
        listNode2.insert(8);
        listNode2.insert(4);
        listNode2.insert(5);

        ListNode result = solution.getIntersectionNode(listNode1, listNode2);
        if (result == null) {
            System.out.println("null");
        } else {
            result.printList();
        }
    }
}
