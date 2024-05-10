package nowcoder.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**[易错1] 注意审题,3的倍数 和 5的倍数不能在一边!
 * if(num[i]!=0&&num[i]%5==0){num5++;}   [易错2] 0不是5或3的倍数!
 * 要这么写 if(sum%2!=0){              [易错3]负数%2 = -1判断不出来  //if(sum%2==1){
 *    if(i==num.length){continue;}          [易错4];但是,这句话必须有!不然会越界!
 *
 *   [重难点1:]简化思路:求sum3和sum5 那么找target = sum/2 -sum3  (或-sum5)就可以了
 *   [重难点2:]我这个回溯写的太复杂,可以按照v1的回溯来写,但是即使这样都慢了
 *
 *   l416是用动规
 *   想我这么写,还要判断两边是不是都有5是不是都有3就不好动规了
 *   [重难点3:]问题转化为在出去5和3的list里找target = sum/2 -sum3,就可以动规
 */
public class hj93 {
    static int num5 = 0;
    static int num3 = 0;
    static boolean res;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());
            String[] s = (in.nextLine()).split(" ");


            int[] num = new int[n];
            int sum = 0;


            for(int i = 0;i<n;i++){
                num[i] = Integer.parseInt((s[i]));
                sum+=num[i];
                if(num[i]!=0&&num[i]%5==0){num5++;}/*[易错1] 0不是5或3的倍数!*/
                if(num[i]!=0&&num[i]%3==0){num3++;}
            }
            //System.out.println(a + b);
            if(sum%2!=0){                       /*[易错2]负数%2 = -1判断不出来*/   //if(sum%2==1){
                System.out.println("false");
                continue;
            }
            int target = sum/2;
            traceback(num,target,0,0,0,0,new ArrayList<>());
            System.out.println(res);
        }

    }

    private static void traceback(int[] num, int target, int shu5, int shu3, int startItem, int sum, List<Integer> path) {
//        System.out.println(path);
//        System.out.println("shu5="+shu5+"num5="+num5);
//        System.out.println("shu3="+shu3+"num3="+num3);
//        System.out.println("sum="+sum);
        //path只为了调试,可以不要的
        if(((shu5==0&&shu3==num3)||(shu5==num5&&shu3==0))&&sum==target){
            res = true;
            return;
        }

        if(startItem==num.length-1)return;
        for(int i = startItem;i<num.length;i++){
            while (i<num.length&&i!=startItem&&num[i]==num[i-1]){
                i++;
            }
            if(i==num.length){continue;}/*[易错3];但是,这句话必须有!不然会越界!*/
            //👆这个剪枝必须进行,不然就过慢,但是,↗
            if(num[i]!=0&&num[i]%5==0){shu5++;}
            if(num[i]!=0&&num[i]%3==0){shu3++;}
            path.add(num[i]);
            traceback(num,target,shu5,shu3,i+1,sum+num[i],path);
            if(num[i]!=0&&num[i]%5==0){shu5--;}
            if(num[i]!=0&&num[i]%3==0){shu3--;}
            path.remove(path.size()-1);
        }
    }

}
