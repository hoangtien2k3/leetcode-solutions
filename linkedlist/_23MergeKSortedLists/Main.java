package linkedlist._23MergeKSortedLists;

public class Main {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        Add_Print_ListNode.addNode(list1, 4);
        Add_Print_ListNode.addNode(list1, 5);
        ListNode list2 = new ListNode(1);
        Add_Print_ListNode.addNode(list2, 3);
        Add_Print_ListNode.addNode(list2, 4);
        ListNode list3 = new ListNode(2);
        Add_Print_ListNode.addNode(list3, 6);

        ListNode[] lists = new ListNode[] {list1, list2, list3};
        Solution solution = new Solution();
        ListNode result = solution.mergeKLists(lists);
        Add_Print_ListNode.print(result);
    }
}
