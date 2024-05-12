package leetcode100;

public class l165 {
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
}
