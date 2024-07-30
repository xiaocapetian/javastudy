package leetcode1000;

import java.util.Arrays;

public class l1720 {
    /**
     * 找到第一个0的位置,以及0的个数
     * @param binary
     * @return
     */
    public String maximumBinaryString(String binary) {
        int first0 = 0;
        while (first0<binary.length()&&binary.charAt(first0)=='1') {
            first0++;
        }
        if(first0==binary.length()) return binary;
        int num0=0;
        for (int i = first0; i < binary.length(); i++) {
            if(binary.charAt(i)=='0') {
                num0++;
            }
        }
        int k = first0+num0-1;

        char[] ans = new char[binary.length()];
        Arrays.fill(ans, '1');
        ans[k] = '0';
        return String.valueOf(ans);
    }

    /**
     * 自己又想了一版本.做出来了,
     * 核心思路,所有的0转到前面来,所有的1放在后面,然后除了最后一位0之外,都变成1]
     * 别忘了所有的前置1不用管不用动!!

     * 00->10
     * 10->01
     * @param binary 给你一个二进制字符串 binary ，它仅有 0 或者 1 组成。你可以使用下面的操作任意次对它进行修改：
     * @return 请你返回执行上述操作任意次以后能得到的 最大二进制字符串
     */
    public String maximumBinaryStringV2(String binary) {
        StringBuilder sb = new StringBuilder();
        /*[易错],前置的1不用管,直到碰上了0*/
        int front1 = 0;
        while (front1<binary.length()&&binary.charAt(front1)=='1') {
            front1++;
            sb.append('1');
        }
        int num0 = 0;
        int num1 = 0;
        for (int i = front1; i < binary.length(); i++) {
            if(binary.charAt(i) == '0'){num0++;}
            if(binary.charAt(i) == '1'){num1++;}
        }
        //所有的0放到前面,所有的1放到后面,再把0中除了最后1位变成1

        if(num0 >0){
            for(int i = 0; i<num0-1; i++){
                sb.append('1');
            }

            sb.append('0');
        }


        for(int i = 0; i<num1; i++){
            sb.append('1');
        }

        return sb.toString();
    }
    /**自己想的,是对的,但是超时了
     */
    public String maximumBinaryStringV1(String binary) {

        char[] binaryArray = binary.toCharArray();
        //StringBuilder sb = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            if(binaryArray[i]=='1'){
                //binaryArray[i]= '1';
                //没有问题
                continue;
            }else {//i位是0
                if(i+1==binary.length()){
                    binaryArray[i]= '0';
                    continue;
                }else if(binaryArray[i+1]==0){
                    //下一位i+1是0 , 没有问题
                    binaryArray[i]= '1';
                }else {
                    //i位是0，下一位i+1是1，那就想怎么把下一位的1变成0
                    // 1变0只有1种方法, 就是10->01 ,那么就往后一直找找到1位是0的,交换位置
                    int j = i+1;
                    while (j<binary.length()&&binaryArray[j]!='0'){
                        j++;
                    }
                    if(j==binary.length()){
                        //那没办法了
                    }else {
                        binaryArray[j] = '1';
                        binaryArray[i+1] = '0';
                        binaryArray[i] = '1';
                    }
                }
            }
        }
        StringBuilder sb= new StringBuilder();
        for (char c : binaryArray) {
            sb.append(c);
        }
        return sb.toString();
    }
}
