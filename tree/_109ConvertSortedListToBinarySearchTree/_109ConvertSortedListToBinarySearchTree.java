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

    TreeNode insert(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (val < root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    void print(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            print(root.left);
            print(root.right);
        }
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

    public void insert(int val) {
        ListNode listNode = new ListNode(val);
        ListNode current = this;
        while(current.next != null) {
            current = current.next;
        }
        current.next = listNode;
    }

    public void print() {
        ListNode current = this;
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// cách 1: dùng phương pháp chia để trị
class Solution_1 {
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
class Solution_2 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        int size = getSize(head);

        return convertListToBST(head, 0, size - 1);
    }

    private TreeNode convertListToBST(ListNode head, int start, int end) {
        if (start > end)
            return null;

        int mid = start + (end - start) / 2;

        TreeNode left = convertListToBST(head, start, mid - 1);

        TreeNode root = new TreeNode(head.val);
        root.left = left;

        head = head.next;

        root.right = convertListToBST(head, mid + 1, end);

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
        Solution_1 solution_1 = new Solution_1();
        Solution_2 solution_2 = new Solution_2();

        ListNode listNode = new ListNode(-10);
        listNode.insert(-3);
        listNode.insert(0);
        listNode.insert(5);
        listNode.insert(9);

        TreeNode treeNode1 = solution_1.sortedListToBST(listNode);
        treeNode1.print(treeNode1);

        TreeNode treeNode2 = solution_2.sortedListToBST(listNode);
        treeNode2.print(treeNode2);

    }
}
