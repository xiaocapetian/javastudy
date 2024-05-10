package nowcoder.huawei;

import java.util.*;

public class hj25v1 {

    public static void main(String[] args){
        /*
         根据题解可知：整数序列I 和 规则整数序列R
         1、是根据R中元素到I序列中进行匹配查询并将I序列中出现的R[i]的索引(index)和I[i]的值进行记录
         2、定义集合用于记录待查找条件R[i]和R[i]出现的次数(count),最后将第一步得到的集合放进来即可，此处也可使用StringBuffer
         */
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int In = scanner.nextInt(); //整数序列I的个数
            String[] Iarr =  new String[In];
            for(int i=0;i<In;i++){
                Iarr[i]= String.valueOf(scanner.nextInt());
            }

            int Rn = scanner.nextInt();//规则整数序列R的个数
            Set<Integer> R_set = new TreeSet<>();//使用TreeSet进行排序和去重
            for(int i = 0; i<Rn; i++){
                R_set.add(scanner.nextInt());
            }

            List<Integer> I_list = new ArrayList<>();//用于存储整数序列I
            List<Integer> R_list = new ArrayList<>();//用于存储规则整数序列R
            for(int item : R_set){
                int count = 0;//统计R中元素在I中出现的次数
                for(int i =0; i<Iarr.length; i++){
                    if(Iarr[i].contains(String.valueOf(item))){//?
                        count++;
                        I_list.add(i);
                        I_list.add(Integer.valueOf(Iarr[i]));
                    }
                }
                if(count>0){
                    R_list.add(item);
                    R_list.add(count);
                    R_list.addAll(I_list);
                }
                I_list.clear();
            }
            System.out.print(R_list.size()+" ");
            for(Integer i:R_list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

