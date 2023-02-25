package LinkedList.RemoveNthNodeFromEndOfList;

public class Solution {
    public int Size(Node head) {
        int count = 0;
        Node countSixe = head;
        while(countSixe != null) {
            ++count;
            countSixe = countSixe.next;
        }
        return count;
    }

    public Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        int size = Size(head);

        Node temp = new Node(0);
        temp.next = head;
        Node p = temp;

        size -= n;
        for(int i = 0; i < size; i++) {
            p = p.next;
        }
        p.next = p.next.next;

        return temp.next;
    }
}
