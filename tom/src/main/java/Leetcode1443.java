/**
 * @author wangtao
 * @date 2022/8/9
 */
public class Leetcode1443 {


    /**
     * [-3,2,-3,4,2]
     * -3 -1 -4 0 2
     * @param nums
     * @return
     */
    public static int minStartValue(int[] nums) {
        // 初始值
        int startValue = 1;
        int cur = startValue;
        for(int k:nums){
            cur += k;
            // 保证当前值大于等于1，差多少初始值补多少
            if(cur < 1){
                startValue += 1 - cur;
                cur = 1;
            }
        }
        return startValue;
    }

    public static void main(String[] args) {
        int[] tmp = new int[]{-3,2,-3,4,2};
        System.out.println(minStartValue(tmp));
    }
}
