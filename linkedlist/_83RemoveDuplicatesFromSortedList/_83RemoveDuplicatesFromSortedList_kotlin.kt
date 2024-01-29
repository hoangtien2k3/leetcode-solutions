package linkedlist._83RemoveDuplicatesFromSortedList

class ListNodeKotlin(var value: Int) {
    var next: ListNodeKotlin? = null

    fun append(value: Int) {
        val newNode = ListNodeKotlin(value)
        var currentNode: ListNodeKotlin = this
        while (currentNode.next != null) {
            currentNode = currentNode.next!!
        }
        currentNode.next = newNode
    }

    fun printList() {
        var currentNode: ListNodeKotlin? = this
        while (currentNode != null) {
            print("${currentNode.value} ")
            currentNode = currentNode.next
        }
        println()
    }
}

class Solution_kotlin {
    fun deleteDuplicates(head: ListNodeKotlin?): ListNodeKotlin? {
        var current: ListNodeKotlin? = head

        while (current?.next != null) {
            if (current.value == current.next!!.value) {
                current.next = current.next!!.next
            } else {
                current = current.next
            }
        }

        return head
    }
}

fun main() {
    val listNode = ListNodeKotlin(1)
    listNode.append(1)
    listNode.append(2)
    listNode.append(3)
    listNode.append(3)

    val solution = Solution_kotlin()
    solution.deleteDuplicates(listNode)
    listNode.printList()

}