package nowcoder.huawei;

import java.util.Scanner;

public class hj18v2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] ipAndMask = new String[2];
        String[] ipArr = new String[4];
        int A = 0,B = 0,C = 0,D =0,E = 0,errIpOrMask = 0,privateIp = 0;
        while (in.hasNextLine()) {
            ipAndMask = in.nextLine().split("\\~");
            if(ipAndMask[0].equals("end")){
                break;
            }
            ipArr = ipAndMask[0].split("\\.");
            //类似于【0.*.*.*】和【127.*.*.*】忽略，这个条件要放在最前面，否则错误掩码会统计多
            if(ipArr[0].equals("0") || ipArr[0].equals("127")){
                continue;//跳过
            }
            if(!isValidMask(ipAndMask[1])){ //判断掩码是否有效
                errIpOrMask++;
                //System.out.println(ipAndMask[1]);//输出错误掩码
            }else{
                if(!isValidIp(ipAndMask[0])){
                    errIpOrMask++;
                    //System.out.println(ipAndMask[0]);//输出错误ip
                }else{
                    if(Integer.parseInt(ipArr[0])>=1 && Integer.parseInt(ipArr[0])<=126){
                        if(Integer.parseInt(ipArr[0])==10){
                            privateIp++;
                            A++;
                        }else{
                            A++;
                        }
                    }
                    if(Integer.parseInt(ipArr[0])>=128 && Integer.parseInt(ipArr[0])<=191){
                        if(Integer.parseInt(ipArr[0])==172 && (Integer.parseInt(ipArr[1]) >=16 && Integer.parseInt(ipArr[1])<=31)){
                            privateIp++;
                            B++;
                        }else{
                            B++;
                        }
                    }
                    if(Integer.parseInt(ipArr[0])>=192 && Integer.parseInt(ipArr[0])<=223){
                        if(Integer.parseInt(ipArr[0])==192 && Integer.parseInt(ipArr[1]) ==168){
                            privateIp++;
                            C++;
                        }else{
                            C++;
                        }
                    }
                }
                if(Integer.parseInt(ipArr[0])>=224 && Integer.parseInt(ipArr[0])<=239){
                    D++;
                }
                if(Integer.parseInt(ipArr[0])>=240 && Integer.parseInt(ipArr[0])<=255){
                    E++;
                }
            }
        }
        System.out.println(A + " " + B + " " + C + " " + D + " " + E + " " + errIpOrMask + " " + privateIp);
    }
    public static boolean isValidMask(String mask){
        if(!isValidIp(mask)){
            return false;
        }
        String[] maskTable = mask.split("\\.");
        //mask转为32位2进制字符串
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<maskTable.length;i++){
            maskTable[i] = Integer.toBinaryString(Integer.parseInt(maskTable[i]));
            if(maskTable[i].length() < 8){//不足8位补齐0
                for(int j=0;j < 8- maskTable[i].length();j++){
                    sb.append("0");//补完零
                }
                sb.append(maskTable[i]);//再添加转换的2进制串
            }else{
                sb.append(maskTable[i]);//刚好8位直接添加，因为之前已经判断过ip的有效性，所以不可能超过8位
            }
        }
        //最后一个1在第一个0之前，有效，否则无效
        return sb.toString().lastIndexOf("1") < sb.toString().indexOf("0");
    }
    public static boolean isValidIp(String ip){
        String[] ipTable = ip.split("\\.");
        if(ipTable.length != 4){
            return false;
        }
        for(String s : ipTable){
            if(Integer.parseInt(s) < 0 || Integer.parseInt(s) > 255){
                return false;
            }
        }
        return true;
    }
}