import java.util.Arrays;

/**
 * @author wangtao
 * @date 2022/8/3
 */
public class Leetcode899 {

    public static String orderlyQueue(String s, int k) {
        if (k == 1){
            int len = s.length();
            StringBuilder sb = new StringBuilder(s);
            String small = s;
            for (int i = 1; i < len; i++) {
                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
                if (sb.toString().compareTo(small) < 0){
                    small = sb.toString();
                }
            }
            return small;
        }else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }


    public static void main(String[] args) {
        String s = "cba";
        int k = 1;
        System.out.println(orderlyQueue(s,k));
    }
}
