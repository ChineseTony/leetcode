/**
 * @author wangtao
 * @date 2021/8/7
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1){
            return "";
        }
        int len = s.length();
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            int left = expandAroundCenter(s,i,i);
            int right = expandAroundCenter(s,i,i+1);
            int tmp = Math.max(left, right);
            if (tmp > end - start) {
                start = i - (tmp - 1) / 2;
                end = i + tmp / 2;
            }
        }
        return s.substring(start,end+1);
    }

    private int expandAroundCenter(
            String tmp,int left,int right){
        while (left >= 0 && right < tmp.length() &&
        tmp.charAt(left) == tmp.charAt(right)){
            left--;
            right++;
        }
        return right - left -1;
    }

    public static void main(String[] args) {
        String s="avaabb";
        System.out.println(new LongestPalindrome().longestPalindrome(s));
    }
}
