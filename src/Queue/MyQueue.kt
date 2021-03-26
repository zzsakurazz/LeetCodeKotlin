package Queue



/**
 * @author zhangzheng
 * @Date  2021/3/9 下午5:19
 * @ClassName MyQueue
 * <p>
 * Desc : 通过数组和链表来实现一个队列结构
 */

/**
 * 顺序队列
 * 使用ArrayList来代替array，添加泛型的操作
 */
class MyArrayQueue<T> {
    private var queArray: ArrayList<T?> = arrayListOf()
    private var front = 0
    private var rear = 0

    //入队操作
    fun enqueue(value: T) {
        queArray.add(value)
        rear++
    }

    //出队操作
    fun dequeue(): T? {
        var dequeueValue: T? = null
        if (!isEmpty()) {
            dequeueValue = queArray[front]
            queArray[front] = null
            front++
        }
        return dequeueValue
    }

    //查看当前队列第一个元素
    fun peekFront(): Any? {
        return queArray[front]
    }


    //是否为空队列
    fun isEmpty(): Boolean {
        return queArray.isEmpty()
    }

    //队列长度 
    fun getSize(): Int {
        return queArray.size
    }
}

/**
 * 链式队列
 */
class MyLinkedQueue<T> {

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