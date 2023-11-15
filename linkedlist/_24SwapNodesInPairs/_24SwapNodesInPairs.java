package linkedlist._24SwapNodesInPairs;

public class _24SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode list =  new ListNode();
        Add_Print_ListNode.addNode(list, 1);
        Add_Print_ListNode.addNode(list, 2);
        Add_Print_ListNode.addNode(list, 3);
        Add_Print_ListNode.addNode(list, 4);

        Add_Print_ListNode.print(list.next);

        Solution solution = new Solution();
        ListNode result = solution.swapPairs(list.next);

        System.out.println();
        Add_Print_ListNode.print(result);


    }
}
