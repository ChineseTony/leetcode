import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangtao
 * @date 2021/9/8
 */
public class GetZeroAllPath {

    public static int  getAllPath(int[][] arr){
        List<List<Index>> result = new ArrayList<>();
        List<Index> tmp = new ArrayList<>();
        int i = arr.length;
        int j = arr[0].length;
        boolean[][] visited = new boolean[i][j];
        if (arr[0][0] == 1){
            return -1;
        }
        tmp.add(new Index(0,0));
        dfs(arr,0,0,visited,result,tmp);
        if (result.size() == 0){
            return -1;
        }else {
            int min = Integer.MAX_VALUE;
            for (List<Index> tmpList:result){
                min = Math.min(min,tmpList.size());
                System.out.println(Arrays.toString(tmpList.toArray(new Index[0])));
            }
            return  min;
        }
    }

    static class Index{
        int x;
        int y;

        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public String toString() {
            return "[" + x +","+ y +
                    "]";
        }
    }

    private static void dfs(int[][] arr, int i, int j,
                            boolean[][] visited,
                            List<List<Index>> tmpList, List<Index> tmpIndex){
        if (arr[i][j] == 1){
            return;
        }
        if (i == arr.length-1 && j == arr[0].length-1){
            tmpList.add(new ArrayList<>(tmpIndex));
            return;
        }
        visited[i][j]= true;
        int[][] direct = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        for (int[] tmp:direct){
            int newI = i + tmp[0];
            int newJ = j + tmp[1];
            if (newI >= 0 && newI < arr.length
                    && newJ >= 0 && newJ < arr[0].length && arr[newI][newI] == 0){
                if (!visited[newI][newJ]){
                    tmpIndex.add(new Index(newI,newJ));
                    dfs(arr,newI,newJ,visited,tmpList,tmpIndex);
                    tmpIndex.remove(tmpIndex.size()-1);
                }
            }
        }
        visited[i][j]=false;
    }

    public static void main(String[] args) {
//        int[][] arr = new int[][]{{0,1,1,1,1},{0,0,0,1,1},
//                {1,1,0,1,1},{1,1,0,0,0},{1,1,1,0,0}};
        int[][] arr = new int[][]{{0,0,0},{0,0,0},
                {0,1,0}};
        System.out.println(getAllPath(arr));
    }
}
