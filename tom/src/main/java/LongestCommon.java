import java.util.Scanner;

/**
 * @author wangtao
 * @date 2021/9/8
 */
public class LongestCommon {

    public static int longestCommon(String a,String b){
        if (a == null || b == null || "".equals(a) ||
                "".equals(b)){
            return 0;
        }
        String s1 = "2"+a;
        String s2 = "1"+b;
        int[][] checked = new int[a.length()+1][b.length()+1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (i == 0 || j == 0){
                    checked[i][j] = 0;
                } else if (s1.charAt(i) == s2.charAt(j)) {
                    checked[i][j] = checked[i-1][j-1] + 1;
                }else {
                    if (checked[i-1][j] > checked[i][j-1]){
                        checked[i][j] = checked[i-1][j];
                    }else {
                        checked[i][j] = checked[i][j-1];
                    }
                }
            }
        }
        return checked[s1.length()-1][s2.length()-1];
    }

    public static int largest(String x,String y){
        int m = x.length();
        int n = y.length();
        //创建二维数组，也就是填表的过程
        int[][] c = new int[m+1][n+1];
        //初始化二维数组
        for (int i = 0; i < m+1; i++) {
            c[i][0] = 0;
        }
        for (int i = 0; i < n+1; i++) {
            c[0][i] = 0;
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)){
                    c[i][j] = c[i-1][j-1] + 1;
                }else if(c[i-1][j] >= c[i][j-1]){
                    c[i][j] = c[i-1][j];
                }else{
                    c[i][j] = c[i][j-1];
                }
            }
        }
//        System.out.println(c[m][n]);
        return c[m][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        System.out.println(longestCommon(a,b));
    }
}
