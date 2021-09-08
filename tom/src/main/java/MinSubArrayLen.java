/**
 * @author wangtao
 * @date 2021/9/7
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int index  = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target){
                int tmp  = i - index + 1;
                result = Math.min(tmp,result);
                sum -= nums[index++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;

    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0 ){
            return 0 ;
        }
        int left = 0;
        int right = 0;
        int result = 0;
        char[] tmp = s.toCharArray();
        char[] chars = new char[256];
        int len = s.length();
        while(right < len){
            if(right < len && chars[tmp[right]] == 0){
                chars[tmp[right]] = 1;
                right++;
            }else{
                chars[tmp[left]] = 0;
                left++;
            }
            result = Math.max(result,right - left);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "1232";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
