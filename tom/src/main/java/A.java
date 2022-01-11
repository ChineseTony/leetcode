/**
 * @author wangtao
 * @date 2021/11/5
 */
public class A {

        public void sortColors(int[] nums) {
            int r1 = -1;
            int r2 = -1;
            for(int i = 0;i < nums.length;i++){
                if(nums[i] < 2) {
                    r2++;
                    swap(nums,i,r2);
                    if(nums[r2] < 1){
                        r1++;
                        swap(nums,r1,r2);
                    }
                }
            }
        }

        private void swap(int[] arr,int i,int j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
}
