package chongle.huawei;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class hh {
    static boolean haschange = true;
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int n = Integer.parseInt(sc.nextLine());

            String s = sc.nextLine();
            String[] pai = s.split(" ");
            List<String> list = Arrays.asList(pai);
            //LinkedList<String> linkedlist = new LinkedList<>();

            //ListNode head = new ListNode("-1",null);
            ListNode dummy = new ListNode("-1",null);
            ListNode cur = dummy;
            for (int i = 0; i < pai.length; i++) {
                ListNode listnode = new ListNode(pai[i],null);
                cur.next = listnode;
                cur = listnode;
            }
//            cur =dummy;
//            while (cur!=null){
//                System.out.println(cur.var);
//                cur = cur.next;
//            }
            while (haschange){
                find(dummy);
            }
            if(dummy.next==null){
                System.out.println("0");
            }else {
                ListNode cur1 = dummy.next;
                StringBuilder sb = new StringBuilder();
                while (cur1!=null){
                    sb.append(cur1.var+" ");
                    //System.out.println(cur1.var+" ");
                    cur1 = cur1.next;
                }
                String string = sb.toString();

                System.out.println(string.substring(0,string.length()-1));
            }
        }
    }

    static class ListNode{
        String var;
        ListNode next;
        ListNode(){}
        ListNode(String var,ListNode next){
            this.var = var;
            this.next =next;
        }
    }
    //private static void find(List<String> list) {
    private static void find(ListNode dummy) {
        haschange = false;
        ListNode pre3 = dummy;
        if(pre3==null){
            return;}
        ListNode pre2= dummy.next;
        if(pre2==null){
            return;}
        ListNode pre = pre2.next;
        if(pre==null){
            return;}
        ListNode cur = pre.next;
        while (cur!=null){
            //System.out.println("pre.next.var = "+pre3.next.var+"pre.next.next.var = "+pre3.next.next.var+"cur="+cur.var);
            if(cur.var.equals(pre3.next.var)&&cur.var.equals(pre3.next.next.var)){
                pre3.next = cur.next;
                cur = cur.next;
                haschange = true;
                if(cur==null||cur.next==null){return;}
                else {
                    cur = cur.next.next;
                }
            }
            else {
                cur = cur.next;
                pre3 = pre3.next;
            }
        }

    }
}
//        if(list.size()<3){return;}
//        boolean if3;
//        for (int i = 2; i < list.size(); i++) {
//        if(list.get(i)==list.get(i-1)&&list.get(i)==list.get(i-2)){
//        list.remove(i-2);
//        list.remove(i-1);
//        list.remove(i);
//        i
//        }
//        }