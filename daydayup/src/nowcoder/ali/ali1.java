package nowcoder.ali;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 看l354吧
 */
public class ali1 {



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int n = Integer.parseInt(str);
        for (int i = 0;i < n;i++){
            String str1 = bf.readLine();
            int m = Integer.parseInt(str1);
            String[] str2 = bf.readLine().split(" ");
            String[] str3 = bf.readLine().split(" ");
            int[][] items = new int[m][2];
            for (int j = 0;j < m;j++){
                items[j] = new int[]{Integer.parseInt(str2[j]),Integer.parseInt(str3[j])};
            }

            //对数组排序
            //排序器，将X从小到大排序，最关键的一步是将相同的X按Y从大到小排序，因为如果按Y从小到大排序，
            //会导致后面的大的Y覆盖末尾前面的小的Y，这样就不符合贪心算法的尽量保证末尾元素最小的要求了。
            Arrays.sort(items,(o1, o2) -> {
                if (o1[0] != o2[0]) {return o1[0] - o2[0];}
                else {
                    return o2[1] - o1[1];//真的秀啊
                }
            });
            //res保存最长递增子序列的大小。
            int res = 1;
            //用来保存每个长度末尾的Y尽可能小的[x,y]数组。
            int[][] dp = new int[m + 1][2];
            dp[1] = items[0];
            //二分法进行查找此时的Y刚刚好大于哪一个下标的Y，又小于下一个下标的Y，这样更改下一个下标
            //的Y，为此时的Y，就可以保证dp数组保存的是末尾可能的最小的Y。这种方法相对于DP寻找最长
            //递增子序列，更快，时间复杂度为O(nlogn)
            for (int j = 1;j < m;j++){
                if (dp[res][1] < items[j][1]) dp[++res] = items[j];
                else if (dp[res][1] > items[j][1]){
                    int l = 1,r = res,pos = 0;
                    while (l <= r){
                        int mid = (l + r) >> 1;
                        if (dp[mid][1] < items[j][1]){
                            pos = mid;
                            l = mid + 1;
                        }else{
                            r = mid - 1;
                        }
                    }
                    if (dp[pos][0] != items[j][0]) dp[pos + 1] = items[j];
                }
            }
            System.out.println(res);
        }
    }

//    作者：AnvilLiu
//    链接：https://www.nowcoder.com/exam/test/79917598/submission?examPageSource=Company&pid=30440638&testCallback=https%3A%2F%2Fwww.nowcoder.com%2Fexam%2Fcompany%3FcurrentTab%3Drecommand%26jobId%3D100%26selectStatus%3D0%26tagIds%3D134&testclass=%E8%BD%AF%E4%BB%B6%E5%BC%80%E5%8F%91
//    来源：牛客网
}
