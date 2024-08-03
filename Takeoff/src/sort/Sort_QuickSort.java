package sort;

import java.util.Arrays;
import java.util.Random;

/*
快速排序：
第一轮：以0索引的数字为基准数，确定基准数在数组中正确的位置。
比基准数小的全部在左边，比基准数大的全部在右边。
后面以此类推。
*/
public class Sort_QuickSort {

    public void quickSort(int[] arr,int first,int last){
        //System.out.println("现在first是"+first+" ,last是"+last);
        if(first>=last){   //这里写>还是>=都可以,写>=比较好,因为相等时也可以结束递归
        //System.out.println("first>j结束");
         return;}

        int start = partition(arr, first, last);

        quickSort(arr,first,start-1);//基准数左边的范围
        quickSort(arr,start+1,last);//基准数右边的范围

    }

    private int partition(int[] arr, int first, int last) {
        //以第一位first为基准数
        //int baseNumber = arr[first];
        //改进方案，找一个随机位作为基准数
        Random random = new Random();
        int baseNumberItem = random.nextInt(last - first + 1) + first;
        //基准数和首位交换（这样首位还放的是基准数）
        swap(arr, first,baseNumberItem);
        int baseNumber = arr[first];
        System.out.println("选到了随机基准点baseNumberItem="+baseNumberItem+"值是"+baseNumber);

        int left = first;
        //int left  = first+1;
        /*[重难] 👆*///问题出在这里!!!
        //为什么不能这样写？假如要排的数是3,4,5,start和end停在4直接就把3和4换了!!!
        //假如要排的数是3,4 ,start和end根本不进循环,出来停在4直接就把3和4换了!!!
        int right = last;

//end从后往前找,找到比基准数小的就停下来
        //start从后往前找,找到比基准数大的就停下来
        //除非end,start有谁在没找到目标就相遇了
        while (left<right){
            //为什么必须先移动end,如果先移动start,START碰到比基准数大的停下了,然后end移动,再相遇的时候会相遇点会比基准数大
            //那么把这个相遇点移到前面去了//那么就不能符合一轮过后,所有比基准数小的在左边,比基准数大的在右边了
            while (right > left && arr[right] >= baseNumber) {
                right--;
            }
            //System.out.println("现在end停在了arr["+right+"] = "+ arr[right]);
            while (right > left && arr[left] <= baseNumber) {
                left++;
            }
            //System.out.println("现在start停在了arr["+left+"] = "+ arr[left]);
            //start和end停下来后,就交换
            swap(arr, left, right);
            //System.out.println("startend交换后"+Arrays.toString(arr));
            //交换完之后怎么办?继续left和right继续向前,循环,直到相遇
        }
        //baseNumber
        //left和right相遇了.那么这就是基准数first应该在的位置,
        //first和left交换
        //System.out.println("现在arr[first]为arr["+ first +"] = "+ arr[first]);
        swap(arr, first, right);
        int temp = arr[right];
        arr[right] = arr[first];
        arr[first] = temp;
        System.out.println("firstend交换后"+Arrays.toString(arr)+",现在start = "+left);
        return left;
    }

    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Sort_QuickSort solution = new Sort_QuickSort();
        //int[] arr = {1, 6, 2, 7, 9, 3, 4, 5, 10, 8};
        int[] arr = {1,1, 6, 2, 7, 9, 3, 4, 5, 1,10, 8};
        //int[] arr = {3,4,5};
        //System.out.println(Arrays.toString(arr));
        solution.quickSort(arr,0,arr.length-1);
        //quickSort4(arr,0,arr.length-1);//老师的是对的啊

        //quick(arr,0,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

//        int[] arr = new int[1000000];
//        Random r = new Random();
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = r.nextInt();
//        }
//        long start = System.currentTimeMillis();
//        quickSort(arr, 0, arr.length - 1);
//        long end = System.currentTimeMillis();
//
//        System.out.println(end - start);//131

    }
    public static void quick(int[] nums,int k,int shou,int wei){
        //System.out.println("现在shou是"+shou+"wei是"+wei);
        if(shou>wei){return;}
        //
        int left = shou;
        /*
        if(shou>=wei){return;}

        int left = shou+1;问题出在这里!!!
        * */
        int right = wei;
        while (right>left){
            while (right>left&&nums[right]>=nums[shou]){
                right--;
            }
            while (right>left&&nums[left]<=nums[shou]){
                left++;
            }
            int temp = nums[right];
            nums[right] =nums[left];
            nums[left] =temp;
        }
        int temp = nums[right];
        nums[right] =nums[shou];
        nums[shou] =temp;
        //nums[right]现在是找到位置的索引数
        //现在索引为nums.length-k的就是我要找的,第k大的元素
/*        if(right==nums.length-k){res = nums[right];}
        else if(right>nums.length-k){
            quick(nums,k,shou,right-1);
        }
        else {
            quick(nums,k,right+1,wei);
        }*/
        //System.out.println("right"+right+"left"+left);
        quick(nums,k,shou,right-1);
        quick(nums,k,right+1,wei);
    }
    //老师写的
    public static void quickSort4(int[] arr, int i, int j) {
        //定义两个变量记录要查找的范围
        int start = i;
        int end = j;

        if(start > end){
            //递归的出口
            return;
        }



        //记录基准数
        int baseNumber = arr[i];
        //利用循环找到要交换的数字
        while(start != end){
            //利用end，从后往前开始找，找比基准数小的数字
            //int[] arr = {1, 6, 2, 7, 9, 3, 4, 5, 10, 8};
            while(true){
                if(end <= start || arr[end] < baseNumber){
                    break;
                }
                end--;
            }
            //System.out.println(end);
            //利用start，从前往后找，找比基准数大的数字
            while(true){
                if(end <= start || arr[start] > baseNumber){
                    break;
                }
                start++;
            }



            //把end和start指向的元素进行交换
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }

        //当start和end指向了同一个元素的时候，那么上面的循环就会结束
        //表示已经找到了基准数在数组中应存入的位置
        //基准数归位
        //就是拿着这个范围中的第一个数字，跟start指向的元素进行交换
        int temp = arr[i];
        arr[i] = arr[start];
        arr[start] = temp;

        //确定6左边的范围，重复刚刚所做的事情
        quickSort4(arr,i,start - 1);
        //确定6右边的范围，重复刚刚所做的事情
        quickSort4(arr,start + 1,j);
//甚至只要不是第一次,之后的调quickSort都对,太离谱了!!!!
    }
}
