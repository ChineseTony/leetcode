import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangtao
 * @date 2021/8/25
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (String tmp:strs) {
            char[] tmpChar = tmp.toCharArray();
            Arrays.sort(tmpChar);
            String key = new String(tmpChar);
            if (map.containsKey(key)){
                map.get(key).add(tmp);
            }else {
                List<String> tmpList = new ArrayList<>();
                tmpList.add(tmp);
                map.put(key,tmpList);
            }
        }
        for (Map.Entry<String,List<String>> entry:map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
