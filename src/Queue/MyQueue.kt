package Queue

import sun.jvm.hotspot.HelloWorld.e


/**
 * @author zhangzheng
 * @Date  2021/3/9 下午5:19
 * @ClassName MyQueue
 * <p>
 * Desc : 通过数组来实现一个队列结构
 */
class MyQueueForArray(size: Int) {
    var queArray: Array<Any?>
    var maxSize = 0
    var front = 0
    var rear = -1
    var nItems = 0

    init {
        maxSize = size
        queArray = arrayOf(maxSize)
    }

    //入队操作
    fun enqueue(value: Any): Boolean {
        return if (isFull()) {
            false
        } else {
            if (rear == (maxSize - 1)) {
                //如果已经指到最后一个了
                rear = -1
            }
            queArray[++rear] = value
            nItems++
            true
        }
    }

    //出队操作
    fun dequeue(): Any? {
        var dequeueValue: Any? = null
        if (!isEmpty()) {
            dequeueValue = queArray[front]
            queArray[front] = null
            front++
            if (front == maxSize) {
                front = 0
            }
            nItems--
        }
        return dequeueValue
    }

    //查看当前队列第一个元素
    fun peekFront(): Any? {
        return queArray[front]
    }

    //是否已经填满了
    fun isFull(): Boolean {
        return maxSize == nItems
    }

    //是否为空队列
    fun isEmpty(): Boolean {
        return nItems == 0
    }

    //队列长度 
    fun getSize(): Int {
        return nItems
    }
}

/**
 * 链式队列
 */
class MyQueueForLinked<T> {

    class Node<T>(var item: T) {
        var next: Node<T>? = null
    }

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    //入队操作
    fun enqueue(t: T) {
        val node=Node(t)
        if (head == null) {
            head = node
            tail = head
        } else {
            tail?.next =node
            tail = node
        }
        size++
    }

    //出队操作
    fun dequeue(): T? {
        return if(size==0){
            null
        }else{
            size--
            val node=head
            head=head?.next
            node?.item
        }
    }
}