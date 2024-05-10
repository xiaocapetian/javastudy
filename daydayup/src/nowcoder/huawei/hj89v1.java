package nowcoder.huawei;

import java.util.*;
//排列,,不会写了
public class hj89v1 {
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
        put("joker",-1);
        put("JOKER",-1);
    }};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            int[] p = new int[4];
            p[0] = map.get(s.split(" ")[0]);
            p[1] = map.get(s.split(" ")[1]);
            p[2] = map.get(s.split(" ")[2]);
            p[3] = map.get(s.split(" ")[3]);

            System.out.println(get24(p));

        }
    }

    private static String get24(int[] p) {
        if(p[1]==-1||p[2]==-1||p[3]==-1||p[0]==-1){
            return "ERROR";
        }
        traceback(p,new boolean[4],new ArrayList<>(),0);
        return "";
    }

    private static void traceback(int[] p, boolean[] used, List<Integer> path, int item) {

        //System.out.println(path);
        if(path.size()==4){
            System.out.println("hh"+path);
            return;
        }

        for(int i = 0;i<4;i++){
            if(!used[i]){
                path.add(p[i]);
                used[i] = true;
                traceback(p,used,path,i);
                path.remove(path.size()-1);
                used[i]=false;
            }
        }

    }
}
