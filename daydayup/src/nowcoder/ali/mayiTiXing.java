package nowcoder.ali;

import java.util.Scanner;

public class mayiTiXing {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int q = in.nextInt();
            for(int i = 0; i<q ; i++){
                int[][] map = new int[4][2];
                map[0][0] = in.nextInt();
                map[0][1] = in.nextInt();
                map[1][0] = in.nextInt();
                map[1][1] = in.nextInt();
                map[2][0] = in.nextInt();
                map[2][1] = in.nextInt();
                map[3][0] = in.nextInt();
                map[3][1] = in.nextInt();
                judge(map);
            }
            //int b = in.nextInt();
            //System.out.println(a + b);
        }
    }
    public static void judge(int[][] map){
        if(judge1(map,0,1,2,3)||judge1(map,0,2,1,3)||judge1(map,0,3,1,2)
            //||judge1(map,0,1,3,2)||judge1(map,0,2,3,1)||judge1(map,0,3,2,1)
        ){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        //judge1(1,2)||judge1(1,3)||judge1(1,4)
    }

    public static boolean judge1(int[][] map,int point1,int point2,int point3,int point4){
        //System.out.println(""+map[point1][0]+" ,"+map[point1][1]);
        //如果12,和34平行 且不相等,就返回真
        //System.out.println("point2"+point2+"point3"+point3);
        if(map[point1][0]-map[point2][0]==0||map[point3][0]-map[point4][0]==0){
            if(map[point1][0]-map[point2][0]==0&&map[point3][0]-map[point4][0]==0
                    &&(
                    Math.abs(map[point1][1]-map[point2][1])!=Math.abs(map[point3][1]-map[point4][1])
                    //   (map[point1][1]-map[point2][1]!=map[point3][1]-map[point4][1])
                    //   &&
                    //    (map[point1][1]-map[point2][1]!=-map[point3][1]-map[point4][1])
            )
            ){
                //System.out.println("为0且真");
                return true;
            }else return false;
        }
        int xie1 = (map[point1][1]-map[point2][1])/(map[point1][0]-map[point2][0]);
        int xie2 = (map[point3][1]-map[point4][1])/(map[point3][0]-map[point4][0]);
        //System.out.println("xie1="+xie1+" ,xie2="+xie2);
        if((xie1!=xie2))return false;
        else{
            if(Math.abs(map[point1][0]-map[point2][0])==Math.abs(map[point3][0]-map[point4][0])
                //     (map[point1][0]-map[point2][0])==(map[point3][0]-map[point4][0])
                // ||
                // (map[point1][0]-map[point2][0])==-(map[point3][0]-map[point4][0])
            )
            {
                return false;
            }else {
                if(Math.abs(map[point1][0]-map[point2][0])*Math.abs(map[point1][0]-map[point2][0])+
                        Math.abs(map[point1][1]-map[point2][1])*Math.abs(map[point1][1]-map[point2][1])==
                        Math.abs(map[point3][0]-map[point4][0])*Math.abs(map[point3][0]-map[point4][0])+
                                Math.abs(map[point3][1]-map[point4][1])*Math.abs(map[point3][1]-map[point4][1])
                ){
                    return true;
                }else return false;
            }

        }
    }
}