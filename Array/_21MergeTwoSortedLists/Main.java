package Array._21MergeTwoSortedLists;

public class Main {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        Add_Print_ListNode.addNode(list1, 2);
        Add_Print_ListNode.addNode(list1, 4);

        ListNode list2 = new ListNode(1);
        Add_Print_ListNode.addNode(list2, 3);
        Add_Print_ListNode.addNode(list2, 4);


        Solution solution = new Solution();
        ListNode newNode = solution.mergeTwoLists(list1, list2);
        Add_Print_ListNode.print(newNode);

    }
}
