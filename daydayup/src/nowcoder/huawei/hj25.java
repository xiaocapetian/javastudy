package nowcoder.huawei;

import java.util.*;

/**
 * 重难点:1.用treeSet TreeMap的自动排序和去重
 * 重难点2. rstr是Iarr[i]的子串吗? 不用自己写了! Iarr[i].contains(rstr)
 */
public class hj25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String Istr = in.nextLine();
            String Rstr = in.nextLine();
            String[] Iarr = new String[Integer.parseInt(Istr.split(" ")[0])];
            //HashSet<Character>[] isetArr = new HashSet[Integer.parseInt(Istr.split(",")[0])];
            for (int i = 0; i < Iarr.length; i++) {
                //String s = Istr.split(",")[i + 1];
                Iarr[i] = Istr.split(" ")[i+1];
            }

            TreeMap <Integer, List<Integer>> map = new TreeMap<>();
            //HashMap <Integer, List<Integer>> map = new HashMap<>();
            ////R<i>需要从小到大排序
            for (int i = 0; i < Integer.parseInt(Rstr.split(" ")[0]); i++) {
                map.put(Integer.parseInt(Rstr.split(" ")[i+1]),new ArrayList<>());
            }

            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {

                Integer r = entry.getKey();
                String rstr = r+"";
                for (int i = 0; i < Iarr.length; i++) {
                    //if(zichuan(rstr,Iarr[i])){entry.getValue().add(i);}
                    if(Iarr[i].contains(rstr)){entry.getValue().add(i);}
                }
            }

            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                List<Integer> list = entry.getValue();
                int countwei=0;
                StringJoiner sj = new StringJoiner(" ");
                if(list.size()==0){

                }else {

                    count+=2;
                    for (Integer integer : list) {
                        sj.add(integer+"");
                        sj.add(Iarr[integer]);
                        countwei++;
                        count+=2;
                    }
                    sb.append(entry.getKey()).append(" ").append(countwei).append(" ");
                    sb.append(sj.toString()).append(" ");
                }
            }

            String res = count+" "+sb.toString();
            System.out.println(res);
            
        }
    }

    private static boolean zichuan(String rstr, String s) {
        //rstr是s的字串吗?
        for (int i = 0; i+rstr.length() < s.length(); i++) {
            for (int j = 0; j < rstr.length(); j++) {
                while (j < rstr.length()&&i+j< s.length()&&rstr.charAt(j)==s.charAt(i+j)){
                    j++;
                }
                if(j==rstr.length())return true;
            }
        }
        return false;
    }
}
