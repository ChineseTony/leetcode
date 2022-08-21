/**
 * @author wangtao
 * @date 2021/8/17
 */
public class CheckRecord {

    public static boolean checkRecord(String s) {
        if (s == null || s.length() == 0){
            return false;
        }
        int len = s.length();
        int a = 0;
        int l = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'A'){
                a++;
                l = 0;
            } else if (s.charAt(i) == 'L') {
                l++;
                if (l >= 3){
                    return false;
                }
            }else {
                l = 0;
            }
            if (a > 1){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "ALLAPPL";
        System.out.println(checkRecord(s));
        System.out.println(f(5));
    }

    public static int f(int n){
        if (n < 2){
            return n;
        }else {
            return 2 * f(n-1) + f(n-2);
        }
    }


    public int isPrefixOfWord(String sentence, String searchWord) {

        String[] words = sentence.split(" ");
        int len = words.length;
        for (int i = 0; i < len; i++) {
            String word = words[i];
            if (word.startsWith(searchWord)){
                return i;
            }
        }

        return -1;

    }
}
