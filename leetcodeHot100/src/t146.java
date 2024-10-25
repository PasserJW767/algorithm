import java.util.*;

public class t146 {
    // 超出时间限制
    static class LRUCacheMySelf {

        Deque<int[]> deque;
        int capacity;

        public LRUCacheMySelf(int capacity) {
            deque = new ArrayDeque<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            int return_value = -1;
            int[] target_arr = null;
            for (int[] ints : deque) {
                if (ints[0] == key) {
                    target_arr = ints;
                    break;
                }
            }
            if (target_arr == null)
                return -1;
            deque.remove(target_arr);
            deque.addLast(target_arr);
            return return_value;
        }

        public void put(int key, int value) {
            // 遍历看是否有相同的key，有则覆盖value
            int[] target_arr = null;
            for (int[] ints : deque) {
                if (ints[0] == key) {
                    target_arr = ints;
                    break;
                }
            }
            if (target_arr != null) {
                // 最近使用了，移除，加在最后面
                deque.remove(target_arr);
                deque.addLast(target_arr);
                return ;
            }
            // 如果key不尊彩，append
            if (deque.size() < capacity){
                deque.addLast(new int[]{key, value});
            } else {
                deque.removeFirst();
                deque.addLast(new int[]{key, value});
            }
        }
    }
    // 双向链表+HashMap，提高速度
    static class LRUCache {
        static class ListNode{
            int key;
            int value;
            ListNode next;
            ListNode prev;

            public ListNode() {

            }

            public ListNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        ListNode dummyHead;
        ListNode dummyTail;
        Map<Integer, ListNode> map;
        int capacity;
        int listLen;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            dummyHead = new ListNode();
            dummyTail = new ListNode();
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
            this.capacity = capacity;
            this.listLen = 0;
        }

        public void put(int key, int value) {
            ListNode listNode = null;
            // 如果map里面没有这个key
            if (!map.containsKey(key)){
                // 如果长度已经满了，就移除一个
                if (listLen >= capacity){
                    ListNode removeNode = dummyHead.next;
                    removeNode.next.prev = removeNode.prev;
                    removeNode.prev.next = removeNode.next;
                    map.remove(removeNode.key);
                } else {
                    listLen++;
                }
                // 新增一个
                listNode = new ListNode(key, value);
            }
            // 如果map里有这个key
            else {
                listNode = map.get(key);
                // 把这个listNode从链表上删除
                ListNode prev_node = listNode.prev;
                ListNode next_node = listNode.next;
                prev_node.next = next_node;
                next_node.prev = prev_node;
                listNode.value = value;
            }
            // 把这个listNode弄到后面去
            ListNode insertPre = dummyTail.prev;
            insertPre.next = listNode;
            listNode.prev = insertPre;
            listNode.next = dummyTail;
            dummyTail.prev = listNode;
            map.put(key, listNode);
        }

        public int get(int key) {
            if (!map.containsKey(key)){
                return -1;
            } else {
                int result = map.get(key).value;
                // 拿到这个Node，移除它
                ListNode listNode = map.get(key);
                // 把这个listNode从链表上删除
                ListNode prev_node = listNode.prev;
                ListNode next_node = listNode.next;
                prev_node.next = next_node;
                next_node.prev = prev_node;
                // 把这个listNode弄到后面去
                ListNode insertPre = dummyTail.prev;
                insertPre.next = listNode;
                listNode.prev = insertPre;
                listNode.next = dummyTail;
                dummyTail.prev = listNode;
                map.put(key, listNode);
                return result;
            }
        }

        public void print(){
            ListNode cur = dummyHead;
            while (cur.next != dummyTail){
                cur = cur.next;
                System.out.print(cur.value + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
