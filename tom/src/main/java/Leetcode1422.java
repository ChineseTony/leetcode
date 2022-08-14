/**
 * @author wangtao
 * @date 2022/8/14
 */
public class Leetcode1422 {

    public static int maxScore(String s) {
        if(s == null){
            return 0;
        }
        int len = s.length();
        int result = 0;
        int zero = 0;
        int one = 0;
        for (int i = 0; i < len; i++) {
            if(s.charAt(i) == '0'){
                zero++;
            }else{
                one++;
            }
        }
        int tmpZero =0;
        int tmpOne = 0;
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == '0') {
                tmpZero++;
            }else{
                tmpOne++;
            }
            result = Math.max(result,tmpZero + one - tmpOne);
        }
        return result;
    }

    public static void main(String[] args) {
        String s ="011101";
        System.out.println(maxScore(s));
        s= "00111";
        System.out.println(maxScore(s));
        s= "00";
        System.out.println(maxScore(s));
    }
}
