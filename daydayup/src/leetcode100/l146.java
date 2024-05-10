package leetcode100;

import java.util.LinkedHashMap;
import java.util.Map;

public class l146 {
    //直接继承LinkedHashMap
    class LRUCache extends LinkedHashMap<Integer,Integer> {
        private int capacity;//capacity意思是 容量
        public LRUCache(int capacity) {
            super(capacity,0.75F,true);
            this.capacity = capacity;
        /*    为什么这么写,看源码
        public LinkedHashMap(int initialCapacity,
                         float loadFactor,
                         boolean accessOrder) {
        super(initialCapacity, loadFactor);
        this.accessOrder = accessOrder;
    }
        * */
            //accessOrder(默认 false，代表按照插入顺序排序)来确定是按插入顺序还是读取顺序排序。
            //那么本题肯定是按照读取顺序排序的
        }
        public void put(int key, int value) {
            super.put(key,value);
        }
        public int get(int key){
            return super.getOrDefault(key,-1);
        }
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }

    }
}

//    作者：jeromememory
//    链接：https://leetcode.cn/problems/lru-cache/solutions/81045/yuan-yu-linkedhashmapyuan-ma-by-jeromememory/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
/*1.为什么用双向链表而不是单向链表？ 将某个节点移动到链表头部或者将链表尾部节点删去，都要用到删除链表中某个节点这个操作。
你想要删除链表中的某个节点，需要找到该节点的前驱节点和后继节点。对于寻找后继节点，单向链表和双向链表都能通过 next 指针在O(1)时间内完成；
对于寻找前驱节点，单向链表需要从头开始找，也就是要O(n)时间，双向链表可以通过前向指针直接找到，需要O(1)时间。
综上，要想在O(1)时间内完成该操作，当然需要双向链表，实际上就是用双向链表空间换时间了。
2.为什么链表节点需要同时存储 key 和 value，而不是仅仅只存储 value？
因为删去最近最少使用的键值对时，要删除链表的尾节点，如果节点中没有存储 key，
那么怎么知道是哪个 key 被删除，进而在 map 中删去该 key 对应的 key-value 呢？*/



