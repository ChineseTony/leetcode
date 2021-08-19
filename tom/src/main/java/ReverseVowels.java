import java.util.HashSet;
import java.util.Set;

/**
 * @author wangtao
 * @date 2021/8/19
 */
public class ReverseVowels {

    private static Set<Character> vowels;

    static {
        vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
    }

    public  static String reverseVowels(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        int len = s.length();
        char[] chars =s.toCharArray();
        int left = 0;
        int right = len-1;
        while (left < right){
            if ( !isVowel(chars[left])){
                left++;
            }else if (!isVowel(chars[right])){
                right--;
            }else  {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }

        }
        return new String(chars);

    }

    private static boolean isVowel(Character c){
        return vowels.contains(c);
    }

    public static void main(String[] args) {
        String s = "a.b,.";
        System.out.println(reverseVowels(s));

    }

}
