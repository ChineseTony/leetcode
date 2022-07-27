/**
 * @author wangtao
 * @date 2022/7/27
 */
public class FractionAddition {

    public static String fractionAddition(String expression) {
        if (expression == null || expression.length() == 0){
            return expression;
        }
        int len = expression.length();
        long fenzi = 0L;
        long fenmu = 1;
        int index = 0;
        while (index < len){
            long denominator1 = 0, sign = 1;
            if (expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                sign = expression.charAt(index) == '-' ? -1 : 1;
                index++;
            }
            while (index < len && Character.isDigit(expression.charAt(index))){
                denominator1 = denominator1 * 10 + (expression.charAt(index) - '0');
                index++;
            }
            denominator1 = denominator1 * sign;
            //跳过 /
            index++;
            long numerator1 = 0;
            while (index < len && Character.isDigit(expression.charAt(index))){
                numerator1 = numerator1 * 10 + (expression.charAt(index) - '0');
                index++;
            }
            fenzi = denominator1 * fenmu + fenzi * numerator1 ;
            fenmu = fenmu * numerator1;
        }
        if (fenzi == 0){
            return  "0/1";
        }
        // 获取最大公约数
        long g = gcd(Math.abs(fenzi), fenmu);
        return fenzi / g + "/" + fenmu / g;
    }

    private static long gcd(long a,long b){
        long remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }


    public static void main(String[] args) {
        String expression = "-1/2+1/2";
        String s = fractionAddition(expression);
        System.out.println(s);
        String ex = "-1/2+1/2+1/3";
        System.out.println(fractionAddition(ex));
    }
}
