package linkedlist._21MergeTwoSortedLists;

public class MergeSortLinkedList {

    // Hàm tìm giá trị giữa của danh sách liên kết
    public ListNode getMiddle(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    // Hàm hợp nhất 2 danh sách liên kết đã được sắp xếp
    public ListNode merge(ListNode left, ListNode right) {
        ListNode merged = new ListNode(0); // Đây là đỉnh đầu của danh sách đã hợp nhất
        ListNode current = merged;

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

        if (left != null) {
            current.next = left;
        }

        if (right != null) {
            current.next = right;
        }

        return merged.next; // Trả về danh sách đã hợp nhất, bỏ qua đỉnh đầu
    }


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Tìm giá trị giữa của danh sách liên kết
        ListNode middle = getMiddle(head);
        ListNode nextOfMiddle = middle.next;
        middle.next = null;

        // Tiếp tục phân chia danh sách liên kết thành 2 phần
        ListNode left = sortList(head);
        ListNode right = sortList(nextOfMiddle);

        // Hợp nhất 2 danh sách đã được sắp xếp
        ListNode sortedList = merge(left, right);
        return sortedList;
    }
}