import java.util.HashMap;
import java.util.Map;

/**
 * @author wangtao
 * @date 2022/3/22
 */
public class Next<K,V> {


        private int capacity;
        private Node head = new Node(null,null);
        private Node tail  = new Node(null,null);
        private Map<K,Node> map = new HashMap<>();

        public Next(int cap){
            this.capacity = cap;
            head.next = tail;
            tail.pre = head;
        }

        public V get(K key){
            Node node = map.get(key);
            if(node != null ){
                lastUse(node);
                return node.value;
            }else{
                //没找到
                return null;
            }
        }

        public void put(K key,V value){
            if(!map.containsKey(key)){
                //超过容量大小 移除队首元素
                if(map.size() == capacity){
                    Node first = head.next;
                    Node tmp = first.next;
                    tmp.pre = head;
                    head.next = tmp;
                    map.remove(key);
                }
                //将新添加的元素添加到队尾
                Node newNode = new Node(key,value);
                Node last = tail.pre;
                last.next = newNode;
                newNode.pre = last;
                newNode.next = tail;
                tail.pre = newNode;
                map.put(key,newNode);
            }else{
                Node node = map.get(key);
                node.value = value;
                //移到队尾
                lastUse(node);
            }
        }

        //移到队尾
        public void lastUse(Node node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
            Node last = tail.pre;
            last.next = node;
            node.pre = last;
            node.next = tail;
            tail.pre = node;
        }


        public static void main(String[] args){
            System.out.println();
            Next<Integer,Integer> cache = new Next<>(2);
            cache.put(1,2);
            cache.put(2,3);
            cache.put(1,4);
            cache.put(3,4);
            System.out.println(cache.get(2));
            // 删除 (2,3)   1,4 --> 3,4

        }


    class Node{
        public Node pre;
        public Node next;
        K key;
        V value;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
        }

    }

}

