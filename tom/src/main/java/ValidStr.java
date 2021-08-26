import java.util.HashMap;
import java.util.Map;

/**
 * @author wangtao
 * @date 2021/8/26
 */
public class ValidStr {


    public static boolean validate(String a,String b){
        if (b == null || b.length() <= 0){
            return false;
        }
        Map<Character,Integer> need = new HashMap<>(16);
        Map<Character,Integer> windows = new HashMap<>(16);
        int len1 = a.length();
        int len2 = b.length();
        for (int i = 0; i < len1; i++) {
            char c = a.charAt(i);
            need.put(c, need.getOrDefault(c,0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < len2){
            char tmp = b.charAt(right);
            if (need.containsKey(tmp)){
                windows.put(tmp,windows.getOrDefault(tmp,0)+1);
                if (windows.get(tmp).equals(need.get(tmp))){
                    valid++;
                }
            }
            right++;
            while (right-left >= len1){
                char c = b.charAt(left);
                if (valid == need.size()){
                    return true;
                }
                if (need.containsKey(c)){
                    if (windows.get(c).equals(need.get(c))){
                        valid--;
                    }
                    windows.put(c,windows.getOrDefault(c,0)-1);
                }
                left++;
            }
        }

        return false;
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        int len1 = s.length();
        int len2 = t.length();
        int tmp = 0;
        while (i < len1 && j < len2){
            if (s.charAt(i) == t.charAt(j)){
                i++;
                tmp++;
            }
            j++;
        }
        return tmp == len1;

    }

    public static void main(String[] args) {
        String a = "ab";
        String b = "eidboaoo";
        System.out.println(validate(a,b));



    }
}
