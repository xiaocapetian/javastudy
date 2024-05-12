package leetcode600;

import java.util.Arrays;

/**
 * 腾讯面面原题,当时我拿链表做可谓是一场悲剧,,,
 */
public class l622 {

    /**
     * 速度击败1%,真是有够好笑的呢
     * 经过一番修改👇,击败100%啦
     * 就是说别循环遍历判断是不是-1啊,应该用上size!!!!!
     * 定义的这个size太重要啦
     */
    class MyCircularQueue {
        int cur = 0;//操作的次数
        int chang;
        int size = 0;
        private int[] elements;

        public MyCircularQueue(int k) {
            //chang = k+1;
            chang = k;//造一个长度为k的循环队列
            elements = new int[chang];
            //Arrays.fill(elements, -1);
        }

        //向循环队列插入一个元素。如果成功插入则返回真。
        public boolean enQueue(int value) {

            if(size==chang)return false;
            else {
                elements[cur%chang] =  value;
                size++;
                cur++;
                return true;
            }
        }

        //从循环队列中删除一个元素。如果成功删除则返回真。
        public boolean deQueue() {
            if(size==0)return false;
            elements[(cur-size)%chang] = -1;
            size--;
            //System.out.println(Arrays.toString(elements));
            return true;
        }

        //从队首获取元素。如果队列为空，返回 -1 。
        public int Front() {
            if(size==0) return -1;
            return elements[(cur-size)%chang];
        }

        //获取队尾元素。如果队列为空，返回 -1 。
        public int Rear() {
            if(size==0)return -1;
            else {return elements[(cur - 1) % chang];}
        }

        public boolean isEmpty() {
            if(size ==0){return true;}else{return false;}
        }

        public boolean isFull() {
            if(size ==chang){return true;}else{return false;}
        }
    }

    /**
     * 速度击败1%,真是有够好笑的呢
     */
    class MyCircularQueue0 {
        int cur = 0;//操作的次数
        int chang;
        int size = 0;
        private int[] elements;

        public MyCircularQueue0(int k) {
            //chang = k+1;
            chang = k;//造一个长度为k的循环队列
            elements = new int[chang];
            Arrays.fill(elements, -1);
        }

        //向循环队列插入一个元素。如果成功插入则返回真。
        public boolean enQueue(int value) {

            if(elements[cur%chang]==-1){
                elements[cur%chang] =  value;
                size++;
                cur++;
                return true;
            }else {
                return false;
            }
        }

        //从循环队列中删除一个元素。如果成功删除则返回真。
        public boolean deQueue() {


            for(int i = 0;i<chang;i++){

                if(elements[(cur+i)%chang]!=-1){
                    elements[(cur+i)%chang]= -1;
                    size--;
                    //System.out.println(Arrays.toString(elements));
                    return true;
                }

            }
            //System.out.println(Arrays.toString(elements));
            return false;
        }

        //从队首获取元素。如果队列为空，返回 -1 。
        public int Front() {
            for(int i = 0;i<=chang;i++) {
                if (elements[(cur + i) % chang] != -1) {
                    return elements[(cur + i) % chang];
                }
            }
            return -1;
        }

        //获取队尾元素。如果队列为空，返回 -1 。
        public int Rear() {
            for(int i = 1;i<=chang;i++) {
                if (cur - i>=0&&elements[(cur - i) % chang] != -1) {
                    return elements[(cur - i) % chang];
                }
            }
            return -1;
        }

        public boolean isEmpty() {
            if(size ==0){return true;}else{return false;}
        }

        public boolean isFull() {
            if(size ==chang){return true;}else{return false;}
        }
    }
}
