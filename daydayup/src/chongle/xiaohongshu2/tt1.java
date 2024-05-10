package chongle.xiaohongshu2;

import java.util.*;
//class Main {
public class tt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            int n = Integer.parseInt(s.split(" ")[0]);//n个粉丝
            int k = Integer.parseInt(s.split(" ")[1]);//送k个人

            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
                if(o2[0]!=o1[0]){return o2[0]-o1[0];}//总分
                else if(o2[1]!=o1[1]){
                    return o2[1]-o1[1];//收藏
                }else return o1[2]-o2[2];//关注顺序
            });
            for (int i = 0; i < n; i++) {
                String s1 = sc.nextLine();
                int[] newfensi = new int[3];
                newfensi[0] = Integer.parseInt(s1.split(" ")[0])+Integer.parseInt(s1.split(" ")[1])*2;
                newfensi[1] = Integer.parseInt(s1.split(" ")[1]);
                newfensi[2] = i+1;
                pq.add(newfensi);
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 0; !pq.isEmpty()&&i < k; i++) {//前k个人
                list.add(pq.poll()[2]);
            }
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i)+" ");
            }
        }
    }
}
