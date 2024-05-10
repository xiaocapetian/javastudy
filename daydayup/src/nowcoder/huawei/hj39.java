package nowcoder.huawei;

import java.util.Scanner;

/**
 * [重难点1] IP 子网掩码的正则表达式 [1]{1,}[0]{1,}
 * [重难点2]  Integer.toBinaryString(Integer.parseInt(yanmaOrIp[i])) 字符串变数字变二进制
 *     toBinaryString()     十进制转二进制
 *   [重难点3]  这里没必要全求出来返回再比,应该一位一位的比!
 */
public class hj39 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String yanma = in.nextLine();
            String ip1 = in.nextLine();
            String ip2 = in.nextLine();
            System.out.println(get(yanma,ip1,ip2));

        }
    }

    private static int get(String yanma, String ip1, String ip2) {
        if(!ipvalid(ip1)||!ipvalid(ip2)||!yanmavalid(yanma)){
            return 1;
        }
        if(weiyu(yanma, ip1).equals(weiyu(yanma, ip2)))return 0;
        else return 2;
    }
    //咱这里没必要全求出来返回再比,应该一位一位的比!
    private static String weiyu(String yanma, String ip){
        String[] yanmas = yanma.split("\\.");
        String[] ips = ip.split("\\.");
        StringBuilder sbym = new StringBuilder();
        StringBuilder sbip = new StringBuilder();
        String ymm = toBinstr(yanmas);
        String ipp = toBinstr(ips);

        System.out.println("ymm="+ymm);
        System.out.println("ipp="+ipp);
        StringBuilder sbres = new StringBuilder();
        for (int i = 0; i < ymm.length(); i++) {
            sbres.append(ymm.charAt(i)&ipp.charAt(i));
        }
        return sbres.toString();

    }

    /**
     *
     * @param yanmaOrIp
     * @return  二进制表示的字符串
     */
    private static String toBinstr(String[] yanmaOrIp) {
        StringBuilder sb =new StringBuilder();
        for(int i = 0;i<4;i++){
            //String s1 = Integer.toBinaryString(Integer.parseInt(yanmaOrIp[i])); 十进制转二进制
            StringBuilder s = new StringBuilder(Integer.toBinaryString(Integer.parseInt(yanmaOrIp[i])));
            while (s.length()<8){
                s.insert(0, "0");}
            sb.append(s);
        }
        return sb.toString();
    }

    private static boolean yanmavalid(String yanma) {
        String[] yanmas = yanma.split("\\.");
        int[] yanmaarr = new int[yanmas.length];
        StringBuilder sb =new StringBuilder();
        for(int i = 0;i<4;i++){
            yanmaarr[i] = Integer.parseInt(yanmas[i]);
            if(yanmaarr[i]>255||yanmaarr[i]<0)return false;

        }
        String s = toBinstr(yanmas);
        if(s.matches("[1]{1,}[0]{1,}"))return true;
        else return false;


    }

    private static boolean ipvalid(String ip) {
        String[] ips = ip.split("\\.");

        for(int i = 0;i<4;i++){
            if(Integer.parseInt(ips[i])>255||Integer.parseInt(ips[i])<0)return false;
        }
        return true;
    }


}
