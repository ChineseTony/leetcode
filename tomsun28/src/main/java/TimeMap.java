import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author tomsun28
 * @date 2021/7/10 17:02
 * @link https://leetcode-cn.com/problems/time-based-key-value-store/
 */
public class TimeMap {

    HashMap<String, TreeMap<Integer, String>> store;

    /** Initialize your data structure here. */
    public TimeMap() {
        store = new HashMap<>(18);
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> treeMap = store.get(key);
        if (treeMap == null) {
            treeMap = new TreeMap<>(Comparator.comparingInt(o -> o));
        }
        treeMap.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = store.get(key);
        if (treeMap == null) {
            return "";
        }
        Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
        if (entry == null) {
            return "";
        } else {
            return entry.getValue();
        }
    }
}
