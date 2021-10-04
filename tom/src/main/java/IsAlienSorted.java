import java.util.HashMap;
import java.util.Map;

/**
 * @author wangtao
 * @date 2021/10/4
 */
public class IsAlienSorted {


    private  Map<Character,Integer> map = new HashMap<>(26);

    public boolean isAlienSorted(String[] words, String order) {
        int len = words.length;
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i),i);
        }
        for (int i = 0; i < len-1; i++) {
            if (!isSorted(words[i+1],words[i])){
                return false;
            }
        }
        return true;
    }



    private boolean isSorted(String a,String b){
        int len1 = a.length();
        int len2 = b.length();
        int i = 0;
        while (i < len1 && i < len2){
            if (map.get(a.charAt(i)) > map.get(b.charAt(i))){
                return true;
            }else if (map.get(a.charAt(i)) < map.get(b.charAt(i))){
                return false;
            }
            i++;
        }
        if (len1 == len2){
            return true;
        }else {
            return i != len1;
        }
    }

    public static void main(String[] args) {
        String[] words = new String[]{"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(new IsAlienSorted().isAlienSorted(words,order));

    }
}
