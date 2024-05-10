package takeoff;

import java.util.Arrays;

public class Sort_SelectionSort {
    /*
        选择排序：
            1，从0索引开始，跟后面的元素一一比较。
            2，小的放前面，大的放后面。
            3，第一次循环结束后，最小的数据已经确定。
            4，第二次循环从1索引开始以此类推。

     */
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 3, 1};
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length ; j++) {//这里是i+1  //这里是arr.length不要-1
                if (arr[i] > arr[j]) {//选择排序是i和j比，而非j和j+1比
                    int tmep = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmep;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
            
}
