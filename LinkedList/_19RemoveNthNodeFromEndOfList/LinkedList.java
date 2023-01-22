package LinkedList._19RemoveNthNodeFromEndOfList;

public class LinkedList {
    private int size;
    private Node head;
    private Node tail;

    public LinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public int size() {
        return this.size;
    }

    public void insertAt(Node node, int position) {
        if (position < 1 || this.size == 0) {
            node.next = this.head;
            this.head = node;

            if (this.tail == null) {
                this.tail = node;
            }

            this.size++;
            return;
        }
        if (position >= this.size) {
            if (this.tail != null) {
                this.tail.next = node;
            }
            this.tail = node;

            if (this.head == null) {
                this.head = node;
            }

            this.size++;
            return;
        }
        Node preNode = null;
        Node currentNode = this.head;
        int counter = 0;
        while (counter < position) {
            counter++;
            preNode = currentNode;
            currentNode = currentNode.next;
        }
        node.next = currentNode;
        preNode.next = node;
        this.size++;
    }

    public void printList() {
        Node currentNode = this.head;
        while (currentNode != null) {
            System.out.print(currentNode.val + " ");
            currentNode = currentNode.next;
        }
    }

}
