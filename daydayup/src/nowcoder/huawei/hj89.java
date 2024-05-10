package nowcoder.huawei;

import java.util.*;

public class hj89 {
    //建立一个牌到数字
    static Map<String,Integer> map=new HashMap<String,Integer>(){{
        put("3",3);
        put("4",4);
        put("5",5);
        put("6",6);
        put("7",7);
        put("8",8);
        put("9",9);
        put("10",10);
        put("J",11);
        put("Q",12);
        put("K",13);
        put("A",1);
        put("2",2);
    }};
    //建立一个数字到牌
    static String[] numToPai = new String[]{"","A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    static String resBiaoDaShi;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            int[] p = new int[4];
            p[0] = map.getOrDefault(s.split(" ")[0],-1);
            p[1] = map.getOrDefault(s.split(" ")[1],-1);
            p[2] = map.getOrDefault(s.split(" ")[2],-1);
            p[3] = map.getOrDefault(s.split(" ")[3],-1);

            System.out.println(get24(p));

        }
    }

    private static String get24(int[] p) {
        if(p[1]==-1||p[2]==-1||p[3]==-1||p[0]==-1){
            return "ERROR";
        }
        for (int i = 0; i < p.length; i++) {
            boolean[] bools = new boolean[4];
            bools[i]=true;
            if(dfs(p,bools,p[i],1,numToPai[p[i]])){return resBiaoDaShi;}
            //[易错]千万别在这return false!不对就进入下一轮循环啊
        }
        return "NONE";

    }

    private static boolean dfs(int[] p, boolean[] used,int res,int usednum,String biaodashi) {

        System.out.println(biaodashi);
        //System.out.println("res=" +res);
        if(usednum==4){
            if(res==24){
                System.out.println(biaodashi);
                resBiaoDaShi = biaodashi;
                return true;
            }else {
                return false;
            }
        }

        for(int i = 0;i<4;i++){
            if(!used[i]){
                used[i] = true;
                boolean b1 = dfs(p,used,res+p[i],usednum+1,biaodashi+"+"+numToPai[p[i]]);
                boolean b2 = dfs(p,used,res-p[i],usednum+1,biaodashi+"-"+numToPai[p[i]]);
                boolean b3 = dfs(p,used,res*p[i],usednum+1,biaodashi+"*"+numToPai[p[i]]);
                boolean b4 = dfs(p,used,res/p[i],usednum+1,biaodashi+"/"+numToPai[p[i]]);
                used[i] = false;//回溯一下
                if(b1||b2||b3||b4)return true;
                //else return false;
                //[易错]千万别在这return false!不对就进入下一轮循环啊
            }
        }
        return false;
    }

}
