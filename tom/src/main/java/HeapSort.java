import java.util.Arrays;

/**
 * @author wangtao
 * @date 2021/8/8
 */
public class HeapSort {

    private HeapSort(){

    }

    public void sort(int[] arr){
        int len = arr.length;
        //第一步堆化 调整为堆
        for (int i = getParent(len-1); i >= 0 ; i--) {
            downAdjust(arr,i,len);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=len - 1;j>0;j--){
            //将堆顶元素与末尾元素进行交换
            swap(arr,0,j);
            //重新对堆进行调整
            downAdjust(arr,0,j);
        }
    }


    private void downAdjust(int[] arr,int index,int length){
        while (getLeftChild(index) < length){
            int tmp = getLeftChild(index);
            if (tmp + 1 < length && arr[ tmp +1] > arr[tmp]){
                tmp ++;
            }
            if (arr[index] > arr[tmp]) {
                break;
            }
            swap(arr,index,tmp);
            index = tmp;
        }
    }



    private void shiftUp(int[] arr,int i){
        while (i != 0){
            int parent = getParent(i);
            if (arr[i] < arr[parent]){
                swap(arr,i,parent);
            }
            i = parent;
        }
    }

    private void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    private int getParent(int index){
        if (index == 0){
            throw new RuntimeException("index = 0 not have parent");
        }
        return (index - 1) / 2;
    }

    private int getLeftChild(int index){
        return 2 * index + 1;
    }

    private int getRightChild(int index){
        return 2 * index + 2;
    }


    public static void main(String[] args) {
        //大根堆
        int[] nums = new int[]{3,2,1,-9,120};
        new HeapSort().sort(nums);
        for (int i:nums){
            System.out.print(i+"\t");
        }
        System.out.println();
    }
}
