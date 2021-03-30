package Hash

/**
 * 自定义map接口
 */
interface MyMap<K, V> {

    /**
     * 插入键值对
     */
    fun put(k: K?, v: V?): V?

    /**
     * 根据K获取V
     */
    fun get(k: K?): V?

    /**
     * 判断Key是否存在
     */
    fun containsKey(k: K?): Boolean

    /**
     * 获取map集合中所有的key，并放入set集合中
     */
    fun keySet(): Set<K?>?

    interface Entry<K, V>
}


/**
 * @param defaultInitialCapacity 数组初始化大小，默认是大小是 [DEFAULT_INITIAL_CAPACITY]
 * @param defaultLoadFactor 负载因子 默认值是 [DEFAULT_LOAD_FACTOR]
 */
class MyHashMap<K, V>(defaultInitialCapacity: Int = DEFAULT_INITIAL_CAPACITY, defaultLoadFactor: Float = DEFAULT_LOAD_FACTOR) : MyMap<K, V> {
    //静态常量
    companion object {
        //初始化长度，这里省弃了源码中 1 << 4 的方式
        private const val DEFAULT_INITIAL_CAPACITY = 16

        //负载因子，默认值为0.75
        //当前容量超过负载因子后（即当前容量超过75%），就有可能触发扩容操作
        private const val DEFAULT_LOAD_FACTOR = 0.75f
    }

    //当前元素数量
    private var size = 0

    //存放Entry的数组
    private var table: Array<Entry<K, V>?>

    //可设置的初始容量
    private var defaultInitSize = 0

    //可设置的负载因子
    private var defaultLoadFactor = 0.0f

    //初始化
    init {
        if (defaultInitialCapacity < 0) {
            //初始容量带下不合法
            throw IllegalAccessException("输入的初始化大小数值异常$defaultInitialCapacity")
        }
        if (defaultLoadFactor < 0 || !defaultLoadFactor.isFinite()) {
            //初始容量带下不合法
            throw IllegalAccessException("输入的负载因子数值异常$defaultLoadFactor")
        }
        this.defaultInitSize = defaultInitialCapacity
        this.defaultLoadFactor = defaultLoadFactor
        //创建数组
        table = arrayOfNulls(defaultInitSize)
    }

    override fun put(k: K?, v: V?): V? {
        var oleValue: V? = null
        //判断是否需要扩容
        if (size >= defaultInitSize * defaultLoadFactor) {
            resize(2 * size)
        }
        //根据hash计算出key应该放到哪里
        val index = hash(k) and (defaultInitSize - 1)
        if (table[index] == null) {
            //这里还没有值
            //创建一个新的实体放入
            table[index] = Entry(k, v, null)
            size += 1
        } else {
            //已经有一个值，遍历该位置的链表，查找是否有一样的key
            val entry = table[index]
            var e = entry
            while (e != null) {
                if (e.key == k || e.key === k) {
                    //有一样的key了，将这个key对应的value取出放到oldValue中
                    // 并将新的覆盖原来的值
                    oleValue = e.value
                    e.value = v
                    //返回oleValue
                    return oleValue
                }
                e = e.next
            }
            //如果没有一样的key
            //使用头插法将新的Entry放到第一位
            table[index] = Entry(k, v, entry)
            size += 1
        }
        return oleValue

    }

    override fun get(k: K?): V? {
        //计算出key对应的index
        val index = hash(k) and (defaultInitSize - 1)
        if (table[index] == null) {
            //如果table这个位置为空则返回null
            return null
        } else {
            val entry = table[index]
            var e = entry
            while (e != null) {
                if (e.key == k || e.key === k) {
                    //如果k相等侧返回对应的value
                    return e.value
                }
                //不是的话就将指针移动到下一位
                e = e.next
            }
        }
        return null
    }

    override fun containsKey(k: K?): Boolean {
        var flag = false
        val index = hash(k) and (defaultInitSize - 1)
        if (table[index] == null) {
            return flag
        } else {
            val entry = table[index]
            var e = entry
            while (e != null) {
                if (e.key === k) {
                    flag = true
                    return flag
                } else {
                    e = e.next
                }
            }
        }
        return false
    }

    override fun keySet(): Set<K?>? {
        return if (size == 0) {
            null
        } else {
            val entrySet = mutableSetOf<K?>()
            for (entry in table) {
                if (entry != null) {
                    var e = entry
                    while (e != null) {
                        entrySet.add(e.key)
                        e = e.next
                    }
                }
            }
            entrySet.toSet()
        }
    }

    //根据key计算hash值
    private fun hash(k: K?): Int {
        //如果key为null则返回 0
        return if (k == null) 0 else (k.hashCode() xor (k.hashCode() ushr this.defaultInitSize))
    }

    /**
     * 扩容操作 作者采用了比较简单的方式，在扩容时将数据全部放入到一个ArrayList中，在进行put操作
     * 这样的话对性能影响很大，后面可以针对这里进行优化
     * @param newSize 扩容后的期望大小
     */
    private fun resize(newSize: Int) {
        val newTable = arrayOfNulls<Entry<K, V>>(newSize)
        defaultInitSize = newSize
        this.size = 0
        val entryList = arrayListOf<Entry<K, V>>()
        for (entry in table) {
            if (entry != null) {
                var e = entry
                while (e != null) {
                    entryList.add(e)
                    //如果该entry上存在链表的话，将他们都取出来存放在list中
                    e = e.next
                }
            }
        }
        if (newTable.isNotEmpty()) {
            table = newTable
        }
        for (entry in entryList) {
            put(entry.key, entry.value)
        }

    }

    //HashMap中存放的实体类
    class Entry<K, V>(k: K?, v: V?, n: Entry<K, V>?) : MyMap.Entry<K, V> {
        constructor() : this(null, null, null)

        var key: K? = null
        var value: V? = null
        var next: Entry<K, V>? = null

        init {
            this.key = k
            this.value = v
            this.next = n
        }
    }
}


