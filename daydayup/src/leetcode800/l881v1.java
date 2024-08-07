package leetcode800;

import java.util.Arrays;

/**
 * 你这么想 对于最小的人, 如果他不能和最大的人同船 ,那最大的不能和任何人同船, 需要给最大的单独一条
 *                    如果可以,那他和最大同船是最优的
 */
public class l881v1 {
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int boatnum = 0;
        while (left<right){
            //如果对于最小的人 可以和 最大的人同船
            if(people[left]+people[right]<=limit){
                left++;right--;
                boatnum++;
            }else {
                //如果他不能和最大的人同船 ,那最大的不能和任何人同船, 需要给最大的单独一条
                right--;
                boatnum++;
            }
        }
        if(left==right){
            //还差最后一个人,再加一条
            boatnum++;
        }//如果left>right,说明没有最后一个人了,
        return boatnum;
    }
}
