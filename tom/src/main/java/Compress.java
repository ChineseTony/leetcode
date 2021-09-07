

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author wangtao
 * @date 2021/9/7
 */
public class Compress {

    public static int compress(char[] chars) {
        if (chars == null || chars.length == 0){
            return 0;
        }
        int len = chars.length;
        Deque<Character> stack = new ArrayDeque<>();
        int count = 1;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (stack.isEmpty()){
                stack.offer(c);
            }else if (stack.peekLast() != c){
                if (count != 1){
                    String s = String.valueOf(count);
                    for (int j = 0; j < s.length(); j++) {
                        stack.offer(s.charAt(j));
                    }
                }
                stack.offer(c);
                count = 1;
            }else {
                count++;
            }
        }
        if (count != 1){
            String s = String.valueOf(count);
            for (int j = 0; j < s.length(); j++) {
                stack.offer(s.charAt(j));
            }
        }
        Character[] characters = stack.toArray(new Character[0]);
        int resultLen = characters.length;
        for (int i = 0; i < resultLen; i++) {
            chars[i] = characters[i];
        }
        System.out.println(Arrays.toString(stack.toArray(new Character[0])));
        return resultLen;
    }


    public static int compress2(char[] chars) {
        if (chars == null || chars.length == 0){
            return 0;
        }
        int len = chars.length;
        int write = 0;
        int left = 0;
        for (int read = 0; read < len; read++) {
            if (read == len-1 || chars[read] != chars[read+1]){
                chars[write++] = chars[read];
                int retain = read - left +1;
                if (retain > 1){
//                    int anchor = write;
//                    while (retain > 0) {
//                        chars[write++] = (char) (retain % 10 + '0');
//                        retain /= 10;
//                    }
//                    reverse(chars,anchor,write-1);
                    char[] tmp = String.valueOf(retain).toCharArray();
                    for (int i = 0; i < tmp.length; i++) {
                        chars[write++] = tmp[i];
                    }
                }
                left = read + 1;
            }
        }
        return write;
    }

    private static void reverse(char[] chars,int left,int right){
        while (left < right){
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int compress = compress(chars);
        System.out.println(new String(chars,0,compress));
        char[] chars2= new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int compressLen = compress2(chars2);
        System.out.println(new String(chars2,0,compressLen));
    }
}
