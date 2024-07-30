package leetcode100;

public class l165 {
    /**
     * 比较版本号
     * 关键是什么啊？字符串转数字的函数Integer.parseInt(v1);
     */
    public int compareVersion(String version1, String version2) {


        String[] version1Arr = version1.split("\\.");
        String[] version2Arr = version2.split("\\.");
        int item = 0;
        int res = 0;
        while (item<version1Arr.length||item<version2Arr.length){
            String v1 = item<version1Arr.length?version1Arr[item]:"0";
            String v2 = item<version2Arr.length?version2Arr[item]:"0";
            int i1 = Integer.parseInt(v1);
            int i2 = Integer.parseInt(v2);
            if(i1>i2){return 1;}
            else if(i1<i2){return -1;
            }
            System.out.println("i1"+i1+"i2"+i2);
            item++;
        }
        return res;
    }
    /**
     * 7/27二刷
     */
    public int compareVersionV2(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int wei = Math.max(v1.length, v2.length);
        for (int i = 0; i < wei; i++) {
            int v1num;
            int v2num;
            if(i>=v1.length){
                v1num=0;
            }else {
                v1num = Integer.parseInt(v1[i]);
            }
            if(i>=v2.length){
                v2num=0;
            }else {
                v2num = Integer.parseInt(v2[i]);
            }
            System.out.println("v1num:"+v1num+" v2num:"+v2num);
            if(v1num>v2num)return 1;
            else if(v1num<v2num)return -1;
        }
        return 0;
    }
}
