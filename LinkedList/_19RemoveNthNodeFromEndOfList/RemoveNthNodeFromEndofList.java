package LinkedList._19RemoveNthNodeFromEndOfList;

/**
 * Definition for singly-linked list.
 * public class Node {
 * int val;
 * Node next;
 * Node() {}
 * Node(int val) { this.val = val; }
 * Node(int val, Node next) { this.val = val; this.next = next; }
 * }
 */
public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAt(new Node(1), 0);
        list.insertAt(new Node(2), 1);
        list.insertAt(new Node(3), 2);
        list.insertAt(new Node(4), 3);
        list.insertAt(new Node(5), 4);
        int n = 2;

        list.printList();
    }
}
