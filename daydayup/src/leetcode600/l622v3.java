package leetcode600;

public class l622v3 {
    /**
     * 二刷（想的方法和v0的新版一模一样），这种题最关键的是定义一个 size 一个count
     */
    class MyCircularQueue {

        int size = 0;
        int count = 0;
        int k;
        int[] elements;
        public MyCircularQueue(int k) {
            elements = new int[k];
            this.k = k;
        }

        public boolean enQueue(int value) {
            if(size==k){
                return false;
            }

            elements[count%k]=value;
            size++;
            count++;
            return true;
        }

        public boolean deQueue() {
            if(size==0)return false;
            else {
                size --;
                return true;
            }
        }

        public int Front() {
            if(size==0)return -1;
            return elements[(count-size)%k];
        }

        public int Rear() {
            if(size==0)return -1;
            //System.out.println(Arrays.toString(elements));
            //System.out.println("count="+count+" size="+size);
            return elements[(count-1)%k];
        }

        public boolean isEmpty() {
            return size==0;
        }

        public boolean isFull() {

            return size == k;
        }
    }
}
