package linkedlist._142LinkedListCycleII;

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
    public ListNode detectCycle(ListNode head) {
        ListNode first = head; // con trỏ thứ nhất (con trỏ di chuyển 1 bước)
        ListNode second = head; // con trỏ thứ 2 (con trỏ di chuyển 2 bước)

        while(second != null && second.next.next != null) {
            first = first.next; // di chuyển 1 bước
            second = second.next.next; // di chuyển 2 bước

            if (first == second) { // khi chúng cùng địa chỉ với nhau (là chúng có tạo ra chu trình)
                first = head;
                while(first != second) {
                    first = first.next;
                    second = second.next;
                }
                return first; // trả về vị trí của first nơi tạo ra chu trình
            }
        }

        return null;
    }
}
public class _142LinkedListCycleII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(3);
        listNode.insert(2);
        listNode.insert(0);
        listNode.insert(-4);

        ListNode result = solution.detectCycle(listNode);
        if (result == null)
            System.out.println("no cycle");
        else {
            System.out.println("tail connects to node index");
        }
    }
}
