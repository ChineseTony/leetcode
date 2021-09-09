/**
 * @author wangtao
 * @date 2021/9/9
 */
public class MultiplyStr {

    public static String multiply(String num1, String num2) {
        if (num1 == null || "".equals(num1.trim())){
            return "";
        }
        if (num2 == null || "".equals(num2.trim())){
            return "";
        }
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int len = len1+len2+2;
        int[] result = new int[len];
        for (int i = len1; i >=0; i--) {
            for (int j=len2;j >= 0;j--){
                int val = (num2.charAt(j) - '0') * (num1.charAt(i) - '0');
                val += result[i+j+1];
                result[i+j] += val / 10;
                result[i+j+1] = val % 10;
            }
        }
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (index < len-1 && result[index] == 0){
            index++;
        }
        for (int i = index; i < len; i++) {
            stringBuilder.append(result[i] );
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        String s1 = "10";
        String s2 = "456";
        System.out.println(multiply(s1,s2));

    }
}
