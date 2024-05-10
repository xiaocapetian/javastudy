package chongle.huawei;

import java.util.*;

public class hh2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            int M = Integer.parseInt(s.split(" ")[0]);//阈值
            int N = Integer.parseInt(s.split(" ")[1]);
            //YunListNode dummy= new YunListNode("dummy",new ArrayList<>(),"");
            //YunListNode cur = dummy;
            //String[] ss= new String[N];
            //List<YunListNode> list = new ArrayList<>();
            HashMap<String,YunListNode> map = new HashMap<>();
            HashMap<String,YunListNode> yunmap = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String s1 = sc.nextLine();
                String[] sarr = s1.split(" ");
                //if(sarr[1].equals("*")){
                if(!map.containsKey(sarr[0])){
                    YunListNode yunListNode= new YunListNode(sarr[0],new ArrayList<>(),sarr[1]);
                    if(sarr[2].equals("0")){yunListNode.gao = Integer.parseInt(sarr[3]);}
                    if(sarr[2].equals("1")){yunListNode.di = Integer.parseInt(sarr[3]);}
                    map.put(sarr[0],yunListNode);
                }else {
                    //map.getOrDefault(sarr[0],new YunListNode(sarr[0],new ArrayList<>()));
                    YunListNode yunListNode = map.get(sarr[0]);
                    if(sarr[2].equals("0")){yunListNode.gao = Integer.parseInt(sarr[3]);}
                    if(sarr[2].equals("1")){yunListNode.di = Integer.parseInt(sarr[3]);}
                    map.put(sarr[0],yunListNode);
                }
            }

            for (Map.Entry<String, YunListNode> entry : map.entrySet()) {
                String fu = entry.getValue().fu;
                if(fu.equals("*")){
                    yunmap.put(entry.getKey(),entry.getValue());
                }else {
                    map.get(fu).next.add(entry.getValue());//把他爹找到啊
                    map.get(fu).childNum++;
                }
            }
            int res=0;
            for (Map.Entry<String, YunListNode> entry : yunmap.entrySet()) {
                YunListNode yunhead = entry.getValue();
                YunListNode cur =yunhead;

                int[] tongji = get(cur);
                int numdi = tongji[0];
                int numgao = tongji[1];
                int score = 5*numgao+2*numdi;
                if(score>M){
                    //风险
                    res++;
                }
            }
            System.out.println(res);
        }
    }
    static int[] get(YunListNode cur){
        int[] tongji = new int[2];
        //int numdi = cur.di;
        //int numgao = cur.gao;
        tongji[0] = cur.di;
        tongji[1] = cur.gao;
        for (YunListNode child : cur.next) {
            int[] tj = get(child);
            tongji[0] =tongji[0]+tj[0];
            tongji[1] =tongji[1]+tj[1];
        }
        return tongji;
    }
    static class YunListNode{
        String name;
        int di;
        int gao;
        String fu;
        int childNum;
        List<YunListNode> next;
        //YunListNode shenzi;
        //hh.ListNode[] next;//一群子节点
        YunListNode(){}
        YunListNode(String name,List<YunListNode> next,String fu){
            this.name = name;
            this.next =next;
            this.fu = fu;
            childNum=0;
            //this.shenzi =shenzi;
        }
        YunListNode(String name,int di,int gao, List<YunListNode> next){
            this.name = name;
            this.di= di;
            this.gao=gao;
            this.next =next;
            //this.shenzi =shenzi;
        }
    }
}
