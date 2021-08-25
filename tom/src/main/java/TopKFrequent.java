import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author wangtao
 * @date 2021/8/25
 */
public class TopKFrequent {

    public static List<String> topKFrequent(String[] words, int k) {
        int len = words.length;
        Map<String,Integer> map = new HashMap<>(len);
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        List<String> rec = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            rec.add(entry.getKey());
        }
        Collections.sort(rec, (word1, word2) -> map.get(word1).equals(map.get(word2)) ? word1.compareTo(word2)
                : map.get(word2) - map.get(word1));
        return rec.subList(0, k);
    }


    public static List<String> topKFrequent2(String[] words, int k) {
        int len = words.length;
        Map<String, Integer> map = new HashMap<>(len);
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>((word1, word2) ->
                map.get(word1).equals(map.get(word2)) ? word2.compareTo(word1)
                : map.get(word1) - map.get(word2));
        for (Map.Entry<String,Integer> entry:map.entrySet()){
            queue.offer(entry.getKey());
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<String> result = new ArrayList<>(k);
        while (!queue.isEmpty()){
            result.add(queue.poll());
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        String[] tmp = new String[]{"i","love","leetcode","i","love","coding"};
        int k = 2;
        List<String> list = topKFrequent2(tmp, k);
        for (String s:list){
            System.out.print(s + "\t");
        }
    }

}
