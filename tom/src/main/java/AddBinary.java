/**
 * @author wangtao
 * @date 2021/9/9
 */
public class AddBinary {

    public static String addBinary(String a, String b,int n) {
        StringBuilder sb = new StringBuilder();
        if (a == null || "".equals(a)) {
            return b;
        }
        if (b == null || "".equals(b)) {
            return a;
        }
        int len1 = a.length();
        int len2 = b.length();
        int tmp = Math.max(len1, len2);
        int[] result = new int[tmp + 1];
        int i = len1 - 1;
        int j = len2 - 1;
        int jin = 0;
        int index = tmp;
        while (i >= 0 || j >= 0) {
            int tmpI = i < 0 ? 0 : a.charAt(i) - '0';
            int tmpJ = j < 0 ? 0 : b.charAt(j) - '0';
            int sum = (tmpI + tmpJ + jin);
            result[index--] = sum % n;
            jin = sum / n;
            i--;
            j--;
        }
        if (jin != 0) {
            result[index--] = jin;
        }
        int tmpIndex = 0;
        while (tmpIndex < tmp && result[tmpIndex] == 0) {
            tmpIndex++;
        }
        for (int k = tmpIndex; k < tmp + 1; k++) {
            sb.append(result[k]);
        }
        return sb.toString();
    }


    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i=1;i<n+1;){
            res[i] = res[i>>1] + (i++%2);
        }
        return res;
    }


    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        boolean flag = false;
        if ((a<0 && b<0) || (a>0 && b>0)) {
            flag = true;
        }
        long dividend = Math.abs((long) a);
        long divisor = Math.abs((long) b);
        if (dividend < divisor) {
            return 0;
        }
        int result = 0;
        int shift = 31;
        while (dividend >= divisor) {
            while (dividend < divisor << shift) {
                shift--;
            }
            dividend -= divisor << shift;
            result += 1 << shift;
        }

        return flag ? result : -result;
    }




    public static void main(String[] args) {
        String a = "10", b = "11";
        System.out.println(addBinary(a,b,2));
        System.out.println(addBinary(a,b,10));

    }
}
