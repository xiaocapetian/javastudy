package leetcode300;

public class l378 {
    /**
     *怎么想不起来归并排序呢?怎么想不起来归并排序呢?看到这四个字就会做了,看不到怎么办呢?
     * @param matrix n x n 矩阵 matrix
     * @param k 其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
     *
     * @return 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
     */
    public int kthSmallest(int[][] matrix, int k) {
        // 1  5  9
        //10 11 13
        //12 13 15
        //要找排序后第8个
        int n = matrix.length;
        int[] item = new int[n];
        int number = 0;
        int res=0;
        while (number<k){
            int min = Integer.MAX_VALUE;
            int minitem = 0;
            for(int i = 0;i<n;i++){

                if(item[i]<n&&min>matrix[i][item[i]]){
                    min = matrix[i][item[i]];
                    minitem = i;
                }

            }
            item[minitem]++;
            res = min;
            number++;
            System.out.println(res);
        }
        return res;


    }
}
