package nowcoder.huawei;

import java.util.Scanner;

/**
 * if(binyanma.matches("[1]{1,}[0]{1,}")){return true;}//[重难点就是这个正则表达式呗]
 */
public class hj18 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /*
        * A类地址从1.0.0.0到126.255.255.255;
B类地址从128.0.0.0到191.255.255.255;
C类地址从192.0.0.0到223.255.255.255;
D类地址从224.0.0.0到239.255.255.255；
E类地址从240.0.0.0到255.255.255.255*/
        /*私网IP范围是：
从10.0.0.0到10.255.255.255
从172.16.0.0到172.31.255.255
从192.168.0.0到192.168.255.255
        * */
        int A=0;
        int B=0;
        int C=0;
        int D=0;
        int E=0;
        int invaild = 0;
        int privatenum = 0;
        String[] ipAndMask = new String[2];
        String[] ipArr = new String[4];
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
//            if (s.equals("")) {
//                break; // 跳出循环
//            }
            ipAndMask = s.split("~");
            String address = ipAndMask[0];
            String yanma = ipAndMask[1];

            ipArr = s.split("~")[0].split("\\.");
            //类似于【0.*.*.*】和【127.*.*.*】忽略，这个条件要放在最前面，否则错误掩码会统计多
            if(ipArr[0].equals("0") || ipArr[0].equals("127")){
                continue;//跳过
            }
            if(!yanmaValid(yanma)){//掩码非法
                invaild++;continue;
            }else if(!addressValid(address)){//地址非法
                invaild++;continue;
            }
            String[] iparr = address.split("\\.");
            if(Integer.parseInt(iparr[0])>=1&&Integer.parseInt(iparr[0])<=126){
                A++;
            }
            if(Integer.parseInt(iparr[0])>=128&&Integer.parseInt(iparr[0])<=191&&Integer.parseInt(iparr[0])!=127){
                B++;
            }
            if(Integer.parseInt(iparr[0])>=192&&Integer.parseInt(iparr[0])<=223){
                C++;
            }
            if(Integer.parseInt(iparr[0])>=224&&Integer.parseInt(iparr[0])<=239){
                D++;
            }
            if(Integer.parseInt(iparr[0])>=240&&Integer.parseInt(iparr[0])<=255){
                E++;
            }
            if(Integer.parseInt(iparr[0])==10){
                privatenum++;
            }
            if(Integer.parseInt(iparr[0])==172&&Integer.parseInt(iparr[1])>=16&&Integer.parseInt(iparr[1])<=31){
                privatenum++;
            }
            if(Integer.parseInt(iparr[0])==192&&Integer.parseInt(iparr[1])==168){
                privatenum++;
            }

        }
        String res = A+" "+B+" "+C+" "+D+" "+E+" "+invaild+" "+privatenum;
        System.out.println(res);//[易错]:这nm我能写个空????System.out.println();
    }

    private static boolean addressValid(String address) {
        String[] addressarr = address.split("\\.");
        if(addressarr.length!=4)return false;
        int[] ip = new int[4];
        for (int i = 0; i < 4; i++) {
            ip[i] = Integer.parseInt(addressarr[i]);
            if(ip[i]>255||ip[i]<0)return false;
        }
        return true;
    }

    private static boolean yanmaValid(String yanma) {
        String[] yanmaarr = yanma.split("\\.");
        if(yanmaarr.length!=4)return false;
        int[] ymarr = new int[4];
        for (int i = 0; i < 4; i++) {
            ymarr[i] = Integer.parseInt(yanmaarr[i]);
            if(ymarr[i]>255||ymarr[i]<0)return false;
        }
        String binyanma = tobinary(ymarr[0])+tobinary(ymarr[1])+tobinary(ymarr[2])+tobinary(ymarr[3]);
        if(binyanma.matches("[1]{1,}[0]{1,}")){return true;}//[重难点就是这个正则表达式呗]
        else return false;
    }
    //抽成方法写的简洁啊
    private static String tobinary(int i){
        String res = Integer.toBinaryString(i);
        while (res.length()<8){
            res = "0"+res;
        }
        return res;
    }
}
