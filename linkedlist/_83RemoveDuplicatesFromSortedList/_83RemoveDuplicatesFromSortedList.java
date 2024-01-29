package linkedlist._83RemoveDuplicatesFromSortedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // Phương thức để thêm một nút mới vào cuối danh sách
    public void append(int val) {
        ListNode newNode = new ListNode(val);
        ListNode current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Phương thức để in ra các giá trị trong danh sách
    public void printList() {
        ListNode current = this;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while(current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}

public class _83RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.append(1);
        listNode.append(2);
        listNode.append(3);
        listNode.append(3);

        Solution solution = new Solution();
        solution.deleteDuplicates(listNode);
        listNode.printList();
    }
}
