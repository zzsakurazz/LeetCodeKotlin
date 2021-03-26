package Stack

import Queue.MyLinkedQueue

/**
 * @author zhangzheng
 * @Date  2021/3/26 下午3:07
 * @ClassName MyStack
 * <p>
 * Desc :使用数组和链表来实现一个栈
 */
/**
 * 顺序栈
 */
class MyArrayStack<T> {
    private var arrayStack=ArrayList<T?>()
    private var nItems = -1
    init {
        arrayStack = arrayListOf()
    }

    /**
     * 压入元素
     */
    fun push(t: T) {
        arrayStack.add(t)
        nItems++
    }

    /**
     * 弹出并返回元素
     */
    fun pop(): T? {
        return if (nItems<0) null else arrayStack[nItems--]
    }

    /**
     * 仅返回不弹出栈
     */
    fun peek(): T?{
        return if (nItems<0) null else arrayStack[nItems]
    }

}

/**
 * 链式栈
 */
class MyLinkedStack<T>{
    class Node<T>(var item: T) {
        var next: Node<T>? = null
    }
    private var head: Node<T>? = null
    private var size = 0

    /**
     * 压入元素
     */
    fun push(t: T) {
        val oldHead=head
        head=Node(t)
        head?.next=oldHead
        size++
    }

    /**
     * 弹出并返回元素
     */
    fun pop(): T? {
        val oldHead=head
        head=oldHead?.next
        size--
        return oldHead?.item
    }

    /**
     * 仅返回不弹出栈
     */
    fun peek(): T?{
        return head?.item
    }

    fun isEmpty():Boolean{
        return size==0
    }
}