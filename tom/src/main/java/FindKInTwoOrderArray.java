/**
 * @author wangtao
 * @date 2022/2/13
 */
public class FindKInTwoOrderArray {

    private FindKInTwoOrderArray(){

    }

    public static int findKInTwoOrderArray(int[] a,int[] b,int k){
        if (k > a.length + b.length){
            return -1;
        }
        if (a.length > b.length){
            return findKth(b,0,b.length-1,a,0,a.length-1,k);
        }else {
            return findKth(a, 0, a.length - 1, a, 0, b.length - 1, k);
        }
    }

    private static int findKth(int[] a,int startA, int endA, int[] b,int startB,
                              int endB, int k) {
        if (k == 1) {
            return Math.min(a[startA],b[startB]);
        }
        if (startA >= endA){
            return b[startB + k - 1];
        }
        if (startB >= endB){
            return a[startA+k-1];
        }
        int pa = Math.min(k/2,endA-startA+1);
        int pb = k - pa;
        int indexA = pa + startA -1;
        int indexB = pb + startB - 1;
        if (a[indexA] > b[indexB]){
            return findKth(a,startA,indexA,b,indexB+1,endB,k-pb);
        }else if (a[indexA] < b[indexB]){
            return findKth(a,indexA+1,endA,b,startB,indexB,k-pa);
        }else {
            return a[indexA];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,4,6,8,10};
        int[] b= new int[]{3,5,7,9};
        System.out.println(findKInTwoOrderArray(a,b,2));
        System.out.println(findKInTwoOrderArray(a,b,9));
        System.out.println(findKInTwoOrderArray(a,b,10));
        System.out.println(findKInTwoOrderArray(a,b,20));
    }
}
