package nowcoder.huawei;

import java.util.Scanner;

public class hj18v1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aNum = 0;
        int bNum = 0;
        int cNum = 0;
        int dNum = 0;
        int eNum = 0;
        int errNum = 0;
        int pNum = 0;
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
//            if (str.equals("")) {
//                break; // 跳出循环
//            }
            //人家这方法有这个没这个(在提交区)都行,离谱吧
            String[] strArr = str.split("~");
            int ipFirst = getIpSeg(strArr[0], 0);
            if (ipFirst == 0 || ipFirst == 127) {
                continue;
            }
            if (maskIsInvaild(strArr[1])) {
                errNum++;
                continue;
            }
            if (ipIsInvaild(strArr[0])) {
                errNum++;
                continue;
            }
            if (ipFirst >= 1 && ipFirst <= 126) {
                aNum++;
            }
            if (ipFirst >= 128 && ipFirst <= 191) {
                bNum++;
            }
            if (ipFirst >= 192 && ipFirst <= 223) {
                cNum++;
            }
            if (ipFirst >= 224 && ipFirst <= 239) {
                dNum++;
            }
            if (ipFirst >= 240 && ipFirst <= 255) {
                eNum++;
            }
            int ipSecond = getIpSeg(strArr[0], 1);
            if (ipFirst == 10 || (ipFirst == 172 && ipSecond >= 16 && ipSecond <=31) || (ipFirst == 192 && ipSecond == 168)) {
                pNum++;
            }
        }
        System.out.println(aNum + " " + bNum + " " + cNum + " " + dNum + " " + eNum + " " + errNum + " " + pNum);
    }

    public static boolean maskIsInvaild(String mask) {
        String[] maskArr = mask.split("\\.");
        if (maskArr.length != 4) {
            return true;
        }
        String maskBinary = toBinary(maskArr[0]) + toBinary(maskArr[1]) + toBinary(maskArr[2]) + toBinary(maskArr[3]);
        if (!maskBinary.matches("[1]{1,}[0]{1,}")) {
            return true;
        }
        return false;
    }

    public static String toBinary(String num) {
        String numBinary = Integer.toBinaryString(Integer.valueOf(num));
        while (numBinary.length() < 8) {
            numBinary = "0" + numBinary;
        }
        return numBinary;
    }

    public static boolean ipIsInvaild(String ip) {
        String[] ipArr = ip.split("\\.");
        if (ipArr.length != 4) {
            return true;
        }
        if (Integer.valueOf(ipArr[0]) > 255 || Integer.valueOf(ipArr[1]) > 255 || Integer.valueOf(ipArr[2]) > 255 || Integer.valueOf(ipArr[3]) > 255) {
            return true;
        }
        return false;
    }

    public static int getIpSeg(String ip, int index) {
        String[] ipArr = ip.split("\\.");
        return Integer.valueOf(ipArr[index]);
    }
}
