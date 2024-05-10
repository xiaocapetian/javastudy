package leetcode100;

import java.util.Arrays;

public class l135 {
    //困难题!自己手写的!就是特别慢
    public int candy(int[] ratings) {
        //if(ratings.length==1)return 1;
        int downLen = 0;//统计下降序列的长度
        int res =0;
        //int preGet = 0;//上一个获得的
        int[] get = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if(i==0){get[0]=1;continue;}
            if(ratings[i-1]>ratings[i]){//这正情况要考虑左边整体提高待遇
                get[i] = 1;
                //res+=1;
                //downLen++;
                if(get[i-1]==1){
                    for (int j = i-1;j>=0&&ratings[j]>ratings[j+1]&&get[j]==get[j+1];j--){
                        get[j] +=1;
                        //res+=1;
                    }

                }
                //downLen++;
            }//else {downLen = 0;}
            //现在这个比上一个好
            if(ratings[i-1]<ratings[i]){
                get[i] = get[i-1]+1;
                //res = res+get[i-1]+1;
            }
            if(ratings[i-1]==ratings[i]){
                get[i]=1;
                //res++;
            }
            //System.out.println(Arrays.toString(get));
        }
        return Arrays.stream(get).sum();

    }
}
