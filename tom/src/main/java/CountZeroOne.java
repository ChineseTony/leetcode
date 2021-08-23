import java.util.Scanner;

/**
 * @author wangtao
 * @date 2021/8/21
 */
public class CountZeroOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        int[] arr = getZeroOne(s);
        for (int i = 0; i < n; i++) {
            if (i != n-1){
                System.out.print(arr[i] + " ");
            }else {
                System.out.println(arr[i]);
            }
        }
    }

    private static int[] getZeroOne(String s){
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) - '0';
        }
        int[] result = new int[n];
        result[0]=1;
        int[] zero = new int[n];
        int[] one = new int[n];
        if (arr[0] == 0){
            zero[0] = 1;
        }else {
            one[0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (arr[i] == 0){
                zero[i] = zero[i-1]+1;
                one[i] = one[i-1];
            }else {
                one[i] = one[i-1]+1;
                zero[i] = zero[i-1];
            }
        }

        for (int i = 1; i < n; i++) {
            int sum = 1;
            for (int j = 0; j < i; j++) {
                int beforZero = zero[j];
                int afterZero = zero[i] - zero[j];
                int beforOne =  one[j];
                int afterOne = one[i] - one[j];
                if (beforOne * afterZero == beforZero * afterOne) {
                    sum ++;
                }
            }
            result[i] = sum;
        }
        return result;
    }
}
