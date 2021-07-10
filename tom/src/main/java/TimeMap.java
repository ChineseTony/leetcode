import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangtao
 * @date 2021/7/10
 * @link https://leetcode-cn.com/problems/time-based-key-value-store/
 */
public class TimeMap {
    private Map<String, List<Integer>> map;
    private Map<Integer, String> values;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
        values = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(timestamp);
        values.put(timestamp,value);
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        List<Integer> times=map.get(key);
        if(timestamp<times.get(0)) {
            return "";
        }
        int n=times.size();
        for(int i=n-1;i>=0;i--){
            int cur=times.get(i);
            if(cur<=timestamp){
                return values.get(cur);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        TimeMap obj = new TimeMap();
        obj.set("foo","bar",1);
        System.out.println(obj.get("foo",1));
        System.out.println(obj.get("foo",3));
    }
}
