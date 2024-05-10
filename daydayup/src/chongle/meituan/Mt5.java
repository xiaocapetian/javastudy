package chongle.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
3 3
1 2
2 3
3 1
*/
/*
2 1
1 2
*/
public class Mt5 {
    static int res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (sc.hasNextInt()) { // 注意 while 处理多个 case

            //
            String in = sc.nextLine();
            int n = Integer.parseInt(in.split(" ")[0]);//n个人
            int m = Integer.parseInt(in.split(" ")[1]);
            //HashMap<Integer,Integer> hash = new HashMap<>();
            boolean[][] map = new boolean[n][n];
            for (int i =0;i<m;i++){
                String in2 = sc.nextLine();
                int p1 = Integer.parseInt(in2.split(" ")[0]);
                int pmei = Integer.parseInt(in2.split(" ")[1]);
                map[p1-1][pmei-1] = true;
            }
            backtrack(new ArrayList<>(),0,n,map);
            System.out.println(res);
        }

    }
    public static void backtrack(List<Integer> path,int num,int peopleNum,boolean[][] map){
        //第num人
        System.out.println("现在已经邀请了"+path);
        System.out.println("看看判断邀请的是"+num);

        if(num ==peopleNum){
            System.out.println("凑出一局是"+path);
            res++;
            return;
        }//第num人;
        for(int i = 0;i<num;i++){
            if(map[i][num]&&!path.contains(i)){//能不能邀请num看的是已经决定不邀请的人里有没有喜欢num的

                System.out.println("想邀请"+num+"但是因为map["+i+"]["+num+"],i="+i+"喜欢num"+num+"但是path没"+i+",不可以了");

                return;
            }
        }
        for(int i = 0;i<2;i++){

            if(i==0){
                System.out.println("看看能不能不要请"+num);
                //如果不邀请它还得看已经邀请的人里面有没有num喜欢的

                if(xihuande(path,num,map)){
                     System.out.println("可以不邀请,先尝试不邀请"+num);
                     backtrack(path,num+1,peopleNum,map);
                }else {
                    System.out.println("已经邀请的人里面有num喜欢的,不可以不邀请"+num);
                }

            }
            if(i==1){
                System.out.println("现在尝试邀请"+num);
                path.add(num);
                backtrack(path,num+1,peopleNum,map);
                path.remove(path.size()-1);
            }
        }
    }
    public static boolean xihuande(List<Integer> path,int num,boolean[][] map){
        for(int i = 0;i<num;i++){
            System.out.println(num+"喜欢"+i+"吗?"+map[num][i]);
            if(map[num][i]&&path.contains(i)){
                return false;
            }
        }
        return true;
    }

}