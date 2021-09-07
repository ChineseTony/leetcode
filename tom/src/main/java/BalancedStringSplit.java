/**
 * @author wangtao
 * @date 2021/9/7
 */
public class BalancedStringSplit {

    public static int balancedStringSplit(String s) {
        int count = 0;
        if (s == null || s.length() == 0){
            return count;
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L'){
                count++;
            }else {
                count--;
            }
            if (count == 0){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
