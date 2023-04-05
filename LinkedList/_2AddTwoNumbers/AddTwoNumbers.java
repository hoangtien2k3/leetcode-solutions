package LinkedList._2AddTwoNumbers;


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

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            int l1_val = (l1 != null) ? l1.val : 0;
            int l2_val = (l2 != null) ? l2.val : 0;

            int sum = l1_val + l2_val + carry;
            carry = sum / 10;
            int last_digit = sum % 10;

            ListNode new_node = new ListNode(last_digit);
            current.next = new_node;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            current = current.next;
        }

        if (carry > 0) {
            ListNode new_node = new ListNode(carry);
            current.next = new_node;
            current = current.next;
        }

        return dummy.next;
        // return về dummy.next, tại chúng ta muốn trả về danh sách liên kết kết quả,
        // bắt đầu từ nút thứ hai (nút đầu tiên là dummy). Vì vậy, thay vì trả về current, chúng ta trả
        // về dummy.next, nghĩa là nút thứ hai của danh sách liên kết kết quả.
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {

    }
}
