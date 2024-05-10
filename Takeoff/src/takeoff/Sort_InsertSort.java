package takeoff;

public class Sort_InsertSort {
    public static void main(String[] args) {
                /*
            插入排序：
                将0索引的元素到N索引的元素看做是有序的，把N+1索引的元素到最后一个当成是无序的。
                遍历无序的数据，将遍历到的元素插入有序序列中适当的位置，如遇到相同数据，插在后面。
                N的范围：0~最大索引

        */
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        int start = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]>arr[i+1]){
                start = i;
                break;
            }
        }
        for (int i = start+1; i < arr.length; i++) {
            int j = i;
            while (j>0&&arr[j-1]>arr[j]){//注意这里是j-1和j来比较
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;

            }
            /*for (int j = i; j > 0; j--) {
                if(arr[j-1]>arr[j]){//注意这里是j-1和j来比较
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }*/
        }
        for (int j : arr) {//增强for遍历
            System.out.print(j + " ");
        }
    }



}
