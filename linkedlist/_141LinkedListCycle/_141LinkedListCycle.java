package linkedlist._141LinkedListCycle;

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
        public boolean hasCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if(slow == fast){
                    return true;
                }
            }
            return false;
        }
}

public class _141LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(3);
        listNode.insert(2);
        listNode.insert(0);
        listNode.insert(-4);

        System.out.println(solution.hasCycle(listNode));
    }
}
