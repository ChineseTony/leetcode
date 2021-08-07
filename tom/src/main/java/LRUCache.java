import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wangtao
 * @date 2021/8/7
 */
public class LRUCache {

    private int capacity;

    private LinkedHashMap<Integer,Integer> linkedHashMap;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        int tmp = (int)Math.ceil(capacity /DEFAULT_LOAD_FACTOR )+1;
         linkedHashMap= new LinkedHashMap<Integer,Integer>(
                 tmp,DEFAULT_LOAD_FACTOR,true
         ){
             @Override
             protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                 return linkedHashMap.size() > capacity;
             }
         };

    }

    public int get(int key) {
        Integer integer = linkedHashMap.get(key);
        if (integer == null){
            return -1;
        }else {
            return integer;
        }
    }

    public void put(int key, int value) {
        linkedHashMap.put(key,value);
    }

}
