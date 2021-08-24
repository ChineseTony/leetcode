import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author wangtao
 * @date 2021/8/23
 */
public class Queen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string= scanner.nextLine();
        int index = string.indexOf("=");
        int n = Integer.parseInt(string.substring(index+1));
        List<List<String>> result= new ArrayList<>();
        int[] visited = new int[n];
        dfs(visited,0,n,result);
        for (List<String> tmp:result){
            System.out.println(Arrays.toString(tmp.toArray(new String[0])));
        }
        System.out.println(result);
    }

    private static void dfs(int[] visited,int row,int n,
                            List<List<String>> result){
        if (row == n){
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (visited[i] == j){
                        sb.append("Q");
                    }else {
                        sb.append(".");
                    }
                }
                tmp.add(sb.toString());
            }
            result.add(tmp);
        }
        for (int i = 0; i < n; i++) {
            if (isValid(visited,row,i)){
                visited[row] = i;
                dfs(visited,row+1,n,result);
            }
        }
    }

    private static boolean isValid(int[] visited,int row,int col){
        for (int i = 0; i < row; i++) {
            int index = visited[i];
            if (index == col){
                return false;
            }
            if (index+ row - i == col){
                return false;
            }
            if (index-row+i == col){
                return false;
            }
        }
        return true;
    }
}
