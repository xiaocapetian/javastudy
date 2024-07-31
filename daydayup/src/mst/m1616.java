package mst;

/**
 * 我自己写出来的~
 */
public class m1616 {
    /**
     *
     * @param array 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
     * @return 注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
     */
    public int[] subSort(int[] array) {

        int left = -1;
        int right = -1;
        int max=Integer.MIN_VALUE;//注意有负数就不能设成0了
        for (int i = 0; i < array.length; i++) {
            //如果不比max大,right 应该包括这一位
            if(array[i]>=max){/*[难点]如果是等于,也应该别折腾*/
                max = array[i];
            }else {
                right = i;
                if(left==-1){left=i;}
                while (left-1>=0&&array[left-1]>array[i]){/*[重难]这里用array[left-1]会比较简单*/
                    left--;
                }

            }
        }
        return new int[]{left,right};
    }
}
