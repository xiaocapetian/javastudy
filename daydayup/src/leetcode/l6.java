package leetcode;

public class l6 {
    public static void main(String[] args) {
        //convert("PAYPALISHIRING",4);
        //convert("ABCDEFGHIJKLMNOPQ",4);
        convert("ABCDEFGHIJK",4);
    }
    public static String convert(String s, int numRows) {
        int len = s.length();
        String result = "";
        StringBuilder sb = new StringBuilder();
        int lie = qiulie(len,numRows);
        char[][] arr = create(len,numRows);
        char[] chararr = s.toCharArray();
        for (int j = 0; j < lie; j++) {
            for (int i = 0; i < numRows; i++) {
                if((j+1)%(numRows-1)==1){arr[i][j] = chararr[(j+1)/(numRows-1)*2*(numRows-1)+i];}
                else{
                    if(i == numRows-1-j%numRows){
                        //arr[i][j] = chararr[(j+1)/(numRows-1)*2*(numRows-1)+j%(numRows-1)+numRows-1];
                        //arr[i][j] = '1';
                    }

                }
            }

        }
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                System.out.print(arr[i][i1]+" ");
            }
            System.out.println();
        }
        String c = "";
        return c;
    }
    public static  int qiulie(int len,int numRows){
        int lie;
        if(len%(2*numRows-1)==0){
            lie = len/(2*numRows-1)*(numRows-1);
        }
        else if (len%(2*numRows-1)<numRows){
            lie = len/(2*numRows-1)*(numRows-1)+1;
        }
        else {
            lie = len/(2*numRows-1)*(numRows-1)+1+(len%(2*numRows-1)-numRows);
        }
        return lie;
    }
    //首先就不用这么复杂，多创建了无所谓！！！
    public static char[][] create(int len,int numRows){
        if(len%(2*numRows-1)==0){
            char[][] arr = new char[len/(2*numRows-1)*(numRows-1)][numRows];
            return arr;
        }
        else if (len%(2*numRows-1)<numRows){
            char[][] arr = new char[len/(2*numRows-1)*(numRows-1)+1][numRows];
            return arr;
        }
        else {
            char[][] arr = new char[len/(2*numRows-1)*(numRows-1)+1+(len%(2*numRows-1)-numRows)][numRows];
            return arr;
        }


    }
}
