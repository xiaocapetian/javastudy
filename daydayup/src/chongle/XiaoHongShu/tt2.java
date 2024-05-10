package chongle.XiaoHongShu;

import java.util.*;
//自己写的太复杂了啊,其实没那么复杂的~
public class tt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            int n = Integer.parseInt(s.split(" ")[0]);//商品数量
            int q = Integer.parseInt(s.split(" ")[1]);//关键词数量
            String s2 = sc.nextLine();
            String[] GuanGianCi = new String[q];
            //String[] str = new String[n];

            boolean[][] map = new boolean[n][q];
            HashMap<String,Integer> GuanGianCiMap = new HashMap<>();
            //HashMap<String,Integer> shangPingMap = new HashMap<>();
            HashMap<Integer,String> shangPingMap = new HashMap<>();
            for(int i = 0;i<q;i++){//q个关键词已经就绪了
                GuanGianCiMap.put(s2.split(" ")[i],i);
                //GuanGianCi[i] = s2.split(" ")[i];
            }
            for(int i = 0;i<n;i++){//对于n个商品
                String s3 = sc.nextLine();
                String shangPing = s3.split(" ")[0];
                //shangPingMap.put(shangPing,i);//存了商品名和商品ID
                shangPingMap.put(i,shangPing);
                int GuanGianCiNum = Integer.parseInt(s3.split(" ")[1]);
                String s4 = sc.nextLine();
                for (int j =0;j<GuanGianCiNum;j++){//对于第i个商品的第j个关键词
                    String guanjianciName = s4.split(" ")[j];
                    if(GuanGianCiMap.containsKey(guanjianciName)){
                        int guanjianciID = GuanGianCiMap.get(guanjianciName);
                        map[i][guanjianciID] = true;
                    }

                }
            }
//            for(int i = 0;i<n;i++){
//                System.out.println(Arrays.toString(map[i]));
//            }
            HashMap<Integer,Integer> shangPingNum = new HashMap<>();//第一个键是商品id,值是商品的关键词数
            for(int i =0;i<n;i++){//对于每个商品
                int num=0;
                for(int j =0;j<q;j++){
                    if(map[i][j]){num++;
                        //System.out.println("num++"+num);
                        }
                }
                shangPingNum.put(i,num);
            }
            System.out.println(GuanGianCiMap);
            System.out.println(shangPingMap);
            System.out.println(shangPingNum);

            ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(shangPingNum.entrySet());
            Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    if(!Objects.equals(o1.getValue(), o2.getValue())){
                           return o2.getValue()-o1.getValue();}
                    else {
                        return o1.getKey()-o2.getKey();
                    }
                }
            });
            for (Map.Entry<Integer, Integer> entry : entries) {

                String shangpingName = shangPingMap.get(entry.getKey());
                System.out.println(shangpingName);
                //System.out.println(entry.getKey());
            }
        }
    }

}
/*
2 5
red book game music sigma
mozart 3
book classic music
arcaea 2
red music
* */