package linkedlist._61RotateList;

public class _61RotateList {
    public static void main(String[] args) {
        ListNode list =  new ListNode();
        Add_Print_ListNode.addNode(list, 1);
        Add_Print_ListNode.addNode(list, 2);
        Add_Print_ListNode.addNode(list, 3);
        Add_Print_ListNode.addNode(list, 4);
        Add_Print_ListNode.addNode(list, 5);
        int k = 2;

        Add_Print_ListNode.print(list.next);

        Solution solution = new Solution();
        ListNode result = solution.rotateRight(list.next, k);

        System.out.println();
        Add_Print_ListNode.print(result);
    }
}
