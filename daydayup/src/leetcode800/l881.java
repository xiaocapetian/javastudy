package leetcode800;

import java.util.Arrays;

public class l881 {
    /**确实自己想出来了,但是速度极慢   直奔v1去
     * @param people 给定数组 people 。people[i]表示第 i 个人的体重 ，船的数量不限，每艘船可以承载的最大重量为 limit。
     * @param limit 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
     * @return  返回 承载所有人所需的最小船数 。
     */
    public int numRescueBoats(int[] people, int limit) {

        //非要倒序排序 用o1o2,那就只能转Integer了
        //由于倒序排序不方便, 排序后倒着遍历
        Arrays.sort(people);
        //为什么非要排序呢, 因为  1,2,5,6  limit = 7  你不能让1和2上一个船,要分开,

        //cun[]表示现在有空位的船, 以及空位的大小
        int[] cun = new int[limit];
        int boatnum = 0;
        for(int i = people.length-1;i>=0;i--){
            boolean flag = false;
            //现在people[i]上船
            for(int j = people[i];j<limit;j++){
                if(cun[j]>0){
                    cun[j]--;
                    //cun[j-people[i]]++; //最多坐2人
                    flag = true;
                    break;
                }
            }
            if(!flag){
                boatnum++;
                cun[limit-people[i]]++;
            }
            //System.out.println(Arrays.toString(cun));
        }
        return boatnum;
    }
}
