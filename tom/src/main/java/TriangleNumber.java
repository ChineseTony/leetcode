import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangtao
 * @date 2021/8/4
 * @link https://leetcode-cn.com/problems/valid-triangle-number/
 */
public class TriangleNumber {


    public int triangleNumber2(int[] nums) {
        if (nums == null || nums.length <= 2){
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int left = j+1;
                int right = len - 1;
                int k = j;
                while (left <= right){
                    int mid = (right - left) / 2 + left;
                    if (nums[mid] < nums[i] + nums[j]){
                        k = mid;
                        left = mid+1;
                    }else {
                        right = mid - 1;
                    }
                }
                count += k - j;
            }
        }
        return count;
    }



    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length <= 2){
            return 0;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        getN(nums,result,tmp,3,0);
        int count = 0;
        for (List<Integer> tmpList:result){
            if (isTri(tmpList)){
                count++;
            }
        }
        return count;
    }

    private boolean isTri(List<Integer> tmp){
        if (tmp == null || tmp.size() != 3){
            return false;
        }
        //任意2边和大于第三边
        int a = tmp.get(0);
        int b = tmp.get(1);
        int c = tmp.get(2);
        if (a + b <= c){
            return false;
        }
        if (a + c <= b){
            return false;
        }
        if (b + c <= a){
            return false;
        }
        return true;
    }


    private static void getN(int[] nums, List<List<Integer>> result,
                      List<Integer> tmpList,int n,int i){
        if (n == tmpList.size()){
            result.add(new ArrayList<>(tmpList));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            tmpList.add(nums[j]);
            getN(nums,result,tmpList,n,j+1);
            tmpList.remove(tmpList.size()-1);
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        getN(nums,result,tmp,3,0);
        for (List<Integer> list:result){
            System.out.println(Arrays.toString(list.toArray(new Integer[0])));
        }

    }
}
