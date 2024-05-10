package leetcode;

public class l6_1 {
    public static void main(String[] args) {
        //convert("PAYPALISHIRING",4);
        //convert("ABCDEFGHIJKLMNOPQ",4);
        System.out.println(convert("ABCDEFGHIJK",4));
    }
    public static String convert(String s, int numRows) {
        int len = s.length();

        //StringBuilder sb = new StringBuilder();
        int lie = ((len-1)/(2*numRows-2)+1)*(numRows-1);
        char[] chara = s.toCharArray();
        //char[][] arr = new char[lie][numRows];
        char[][] arr = new char[numRows][lie];
        for (int i = 0, x = 0, y = 0; i < s.length(); i++) {
            arr[x][y] = chara[i];
            if(i%(2*numRows-2)<numRows-1){
                y=y+1;
            }
            else{
                x=x+1;
                y=y-1;
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                System.out.print(arr[i][i1]+" ");
            }
            System.out.println();
        }
        String c = "";
        StringBuffer ans = new StringBuffer();
        for (char[] row : arr) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }


        return ans.toString();

    }
}
