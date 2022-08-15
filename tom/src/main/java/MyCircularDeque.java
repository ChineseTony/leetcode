/**
 * @author wangtao
 * @date 2022/8/15
 */
public class MyCircularDeque {

    private int font=0;
    private int rear = 0;
    private int[] arr;
    private int capacity;

    public MyCircularDeque(int k) {
        arr = new int[k+1];
        capacity = k+1;
    }

    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        font = (font - 1+ capacity) % capacity;
        arr[font] = value;

        return true;

    }

    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        arr[rear] = value;
        rear = (rear + 1 ) % capacity;
        return  true;
    }

    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        font = (font+1) % capacity;

        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()){
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return arr[font];
    }

    public int getRear() {
        if (isEmpty()){
            return -1;
        }
        return arr[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return font == rear;
    }

    public boolean isFull() {
        return  ( rear + 1 ) % capacity == font;
    }

    public static void main(String[] args) {

    }
}
