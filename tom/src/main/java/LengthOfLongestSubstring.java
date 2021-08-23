import java.util.HashMap;
import java.util.Map;

/**
 * @author wangtao
 * @date 2021/8/12
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        int max = 0;
        String tmp = "";
        for (int i = 0; i < len; i++) {
            if (tmp.contains(chars[i]+"")){
                tmp = tmp.substring(tmp.indexOf(chars[i])+1) + chars[i];
            }else {
                tmp = tmp + chars[i];
            }
            max = Math.max(max,tmp.length());
        }
        return max;
    }


    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() <= 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>(26);
        for (int i = 0; i < len; i++) {
            left = Math.max(left,map.getOrDefault(chars[i],0));
            max = Math.max(max,i-left+1);
            map.put(chars[i],i+1);
        }
        return max;
    }

    public static int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() <= 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        int left = 0;
        int right = 0;
        int result = 0;
        char[] tmp = new char[256];
        while (left < len){
            if (right < len && tmp[chars[right]] == 0){
                tmp[chars[right] ] = 1;
                right++;
            }else {
                tmp[chars[left]] = 0;
                left++;
            }
            result = Math.max(result,right-left);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "aaaabc";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring2(s));
        System.out.println(lengthOfLongestSubstring3(s));

    }
}
