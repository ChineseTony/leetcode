import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author wangtao
 * @date 2021/8/10
 */
public class MyLinkedLRUCache<K,V> {

    private Map<K,ListNode<K,V>> map;

    private ListNode<K,V> head;
    private ListNode<K,V> tail;

    private int capacity;

    public MyLinkedLRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public void put(K key, V value){
        if (map.containsKey(key)){
            ListNode<K,V> tmp = map.get(key);
            tmp.value = value;
            moveToTail(tmp);
        }else {
            ListNode<K,V> node = new ListNode<>(key,value);
            if (map.size() < capacity){
                if (map.size() == 0){
                    head = node;
                    tail = node;
                }else {
                    tail.next = node;
                    node.prev = tail;
                    tail = node;
                }
                map.put(node.key, node);
            }else {
                //删除队首元素
                if (head != null) {
                    map.remove(head.key);
                    if (head.next == null) {
                        head = null;
                        tail = null;
                    } else {
                        ListNode<K,V> next = head.next;
                        head = head.next;
                        next.prev = null;
                    }
                }
                //添加到队尾
                if (head == null){
                    head = node;
                    tail = node;
                }else {
                    tail.next = node;
                    node.prev = tail;
                    tail = node;
                }
                map.put(node.key, node);
            }
        }
    }

    public V get(K key){
        if (!map.containsKey(key)){
            return null;
        }
        //需要把当前节点插入到队尾元素
        ListNode<K,V> tmp = map.get(key);
        V result = tmp.getValue();
        moveToTail(tmp);
        return result;
    }

    private void  moveToTail(ListNode<K,V> tmp){
        if (tmp != tail) {
            ListNode<K, V> prev = tmp.prev;
            ListNode<K, V> next = tmp.next;
            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                next.prev = prev;
                if (next.prev == null) {
                    head = next;
                }
            }
            if (tail != null){
                tail.next = tmp;
                tmp.prev = tail;
                tmp.next = null;
            }
            tail = tmp;
        }
    }



    class ListNode<K,V>{
        private K key;
        private V value;
        private ListNode<K,V> prev;
        private ListNode<K,V> next;

        public ListNode(K key, V value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()){
                return false;
            }
            ListNode<?, ?> listNode = (ListNode<?, ?>) o;
            return Objects.equals(key, listNode.key)
                    && Objects.equals(value, listNode.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        ListNode<K,V> node = head;
        while(node != null){
            sb.append(String.format("%s:%s--->", node.key,node.value));
            node = node.next;
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        MyLinkedLRUCache<Integer,Integer>
                 myLinkedLRUCache = new MyLinkedLRUCache<>(5);
        for (int i = 0; i < 10; i++) {
            myLinkedLRUCache.put(i,i);
        }

        System.out.println(myLinkedLRUCache.get(0));
        System.out.println(myLinkedLRUCache);
        System.out.println(myLinkedLRUCache.get(7));
        System.out.println(myLinkedLRUCache);

    }
}
