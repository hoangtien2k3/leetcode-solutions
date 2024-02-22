package tree._109ConvertSortedListToBinarySearchTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


// cách 1: dùng phương pháp chia để trị
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);

        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode newTree = new TreeNode(slow.next.val);
        ListNode pre = slow.next.next;
        slow.next = null;

        newTree.left = sortedListToBST(head);
        newTree.right = sortedListToBST(pre);

        return newTree;
    }
}


// cách 2: dùng chỉ mục
class Solution_Java {
    private ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        int size = getSize(head);
        this.head = head;

        return convertListToBST(0, size - 1);
    }

    private TreeNode convertListToBST(int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;

        TreeNode left = convertListToBST(start, mid - 1);

        TreeNode root = new TreeNode(head.val);
        root.left = left;

        head = head.next;

        root.right = convertListToBST(mid + 1, end);

        return root;
    }

    private int getSize(ListNode head) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
}


public class _109ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {

    }
}
