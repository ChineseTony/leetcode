/**
 * @author wangtao
 * @date 2021/8/21
 */
public class FindKBit {

    public static String reverse(String str){
        char[] chars= str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length-1; i >=0 ; i--) {
            sb.append('a' + 'z' - chars[i]);
        }
        return sb.toString();
    }


    public static char findKBit(int n,int k){
        char[] chars = new char[26];
        for (int i = 0; i < 26; i++) {
            chars[i] = (char) (i + 'a');
        }
        String[] strings = new String[n];
        strings[0] = "a";
        for (int i = 1; i < n ; i++) {
            if (k < strings[i-1].length()){
                return strings[i-1].charAt(k-1);
            }
            strings[i] = strings[i-1] + chars[i]
                    + reverse(strings[i-1]);
        }
        return strings[n-1].charAt(k-1);
    }

    public static void main(String[] args) {
    }
}
