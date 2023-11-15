package linkedlist._61RotateList;

public class Solution {
    // làm theo cách cơm gạo này sẽ bị chạy quá thời gian.(rất lâu)
/*     public static ListNode Last_Node(ListNode head) {
         ListNode _next = head;
         while(_next.next.next != null) {
             _next = _next.next;
         }
         return _next;
     }

     public ListNode rotateRight(ListNode head, int k) {
         if (head == null || head.next == null || k == 0) {
             return head;
         }

         ListNode _dumy = new ListNode(0);
         _dumy.next = head;
         ListNode head_Node = _dumy.next;

         int i = 0;
         while(i++ < k) {
             ListNode _next = Last_Node(head_Node);
             ListNode l1 = _next;
             ListNode l2 = _next.next;

             l1.next = null;
             l2.next = head_Node;

             head_Node = l2;
         }

         return head_Node;
     }*/


    // cách này thì tìm ra vị trị rồi đổi 1 lần duy nhất.
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode cur = head;
        int len = 1;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }
        cur.next = head;

        k = k % len;
        k = len - k;
        while (k != 0) {
            cur = cur.next;
            k--;
        }

        head = cur.next; // chỉ ra phần tử đó là phần tử đầu
        cur.next = null; // trỏ phần tử đó vào null(để phá vỡ vòng khép kín)

        return head; // trả về phần tử đầu
    }
}
