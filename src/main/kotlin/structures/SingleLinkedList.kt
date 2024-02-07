package structures

/**
 *
 * LinkedList a data structure consisting of a collection of nodes that contain a link to the next/previous node.
 *
 * In the single LinkedList each node contains a link only to the next element
 *
 */

class SingleLinkedList<T>() {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    private var size: Int = 0

    val isEmpty: Boolean
        get() = head == null

    /**
     * Complexity:
     * worst time: O(n)
     * best time: O(1)
     * average time: O(n)
     */
    fun add(index: Int, value: T) : Boolean {
        if (head == null) return false

        var i = 0
        var node = head
        var prevNode = head
        while (prevNode != null && node != null) {
            if (i == index) {
                val newNode = Node(value)
                newNode.changeNext(node)
                prevNode.changeNext(newNode)
                size++
                return true
            }
            i++
            prevNode = node
            node = node.next()
        }

        return false
    }

    fun add(value: T) = addLast(value)

    /**
     * Complexity:
     * worst time: O(1)
     * best time: O(1)
     * average time: O(1)
     */
    fun addFirst(value: T) {
        val node = Node(value)
        if (head == null) {
            head = node
            tail = node
        } else {
            node.changeNext(head)
            head = node
        }
        size++
    }

    /**
     * Complexity:
     * worst time: O(1)
     * best time: O(1)
     * average time: O(1)
     */
    fun addLast(value: T) {
        val node = Node(value)
        if (head == null) {
            head = node
            tail = node
        } else {
            tail?.changeNext(node)
            tail = node
        }
        size++
    }

    /**
     * Complexity:
     * worst time: O(n)
     * best time: O(1)
     * average time: O(n)
     */
    fun contains(value: T) : Boolean {
        if (head == null) return false

        var node = head
        while (node != null) {
            if (node.value() == value) {
                return true
            }
            node = node.next()
        }

        return false
    }

    /**
     * Complexity:
     * worst time: O(n)
     * best time: O(1)
     * average time: O(n)
     */
    fun remove(value: T) : Boolean {
        if (head == null) return false

        var prev = head
        var node = head

        while (node != null) {
            if (node.value() == value) {
                if (head === node) {
                    val oldHead = head
                    head = node.next()
                    if (oldHead === tail) {
                        tail = head
                    }

                    node.changeNext(null)
                    node.changeValue(null)
                } else {
                    prev?.changeNext(node.next())
                }

                size--
                return true
            }
            prev = node
            node = node.next()
        }

        return false
    }

    /**
     * Complexity:
     * worst time: O(n)
     * best time: O(1)
     * average time: O(n)
     */
    fun clear() {
        var node = head
        while (node != null) {
            val currentNode = node

            node = node.next()

            currentNode.changeNext(null)
            currentNode.changeValue(null)
        }

        head = null
        tail = null
        size = 0
    }

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("size: $size\n")
        builder.append("elements: ")

        var node = head
        var next = node?.next()
        while (node != null && next != null) {
            builder.append("${node.value()}, ")

            node = node.next()
            next = node?.next()
        }
        if (node != null) {
            builder.append(node.value())
        }

        return builder.toString()
    }

    class Node<T>(
        private var value: T? = null,
        private var next: Node<T>? = null
    ) {

        fun next() = next
        fun changeNext(node: Node<T>? = null) {
            next = node
        }

        fun value() = value
        fun changeValue(newValue: T?) {
            value = newValue
        }

    }

}