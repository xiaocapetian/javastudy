package leetcode100;

import java.util.Arrays;

public class l149 {
    public int maxPoints(int[][] points) {

        int[][] bp = new int[points.length][points.length];
        int max = 0;
        for(int i = 0 ;i<points.length;i++){
            for(int j = i ;j<points.length;j++){
                if(j==i){bp[i][j]=1;}
                else if(j==i+1){bp[i][j]=2;}
                else {
                    bp[i][j] =2;
                    for(int k = 1;k<j;k++){
                        //System.out.println("i0-j0= "+(points[i][0]-points[j][0])+" ,i1-j1= "+(points[i][1]-points[j][1]));
                        //System.out.println("i0-k0= "+(points[i][0]-points[k][0])+" ,i1-k1= "+(points[i][1]-points[k][1]));
                        int i0j0=points[i][0]-points[j][0];
                        int i1j1=points[i][1]-points[k][1];
                        int i0k0=points[i][0]-points[k][0];
                        int i1k1=points[i][1]-points[j][1];
                        if(i1j1==0||i1k1==0){
                            if(i1j1==0&&i1k1==0){
                                bp[i][j] = bp[i][k]+1;
                            }
                        }
                        //else if(((points[i][0]-points[j][0])/(points[i][1]-points[j][1]))==((points[i][0]-points[k][0])/(points[i][1]-points[k][1]))){
                        else if(i0j0*i1j1==i0k0*i1k1){
                            //System.out.println("==");
                            bp[i][j] = bp[i][k]+1;
                        }
                    }
                }
                max = Math.max(max,bp[i][j]);
            }
        }
        for(int i = 0 ;i<points.length;i++){
            System.out.println(Arrays.toString(bp[i]));
        }
        return max;
    }
}
