package Array._21MergeTwoSortedLists;

public class Add_Print_ListNode {
    // thêm phần tử vào ListNode
    public static void addNode(ListNode list, int value) {
        ListNode temp = new ListNode(value);
        if (list == null) {
            list = temp;
        } else {
            ListNode current = list;
            while(current.next != null) {
                current = current.next;
            }
            current.next = temp;
        }
    }

    public static void print(ListNode list) {
        if (list == null) {
            return;
        }
        while(list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
}
