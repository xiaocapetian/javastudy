package leetcode;

public class l12 {
    public String intToRoman(int num) {
        String str = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        int[] numm = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            numm[str.length()-i-1] = str.charAt(i)-48;

            //numm=[7,6,9]
        }
        for (int i = 0; i < str.length(); i++) {
            //System.out.println(numm[i]);
            if(i==0) {
                switch (numm[i]) {
                    case 1:
                        sb = sb.append("I");
                        break;
                    case 2:
                        sb = sb.append("II");
                        break;
                    case 3:
                        sb = sb.append("III");
                        break;
                    case 4:
                        sb = sb.append("VI");
                        break;
                    case 5:
                        sb = sb.append("V");
                        break;
                    case 6:
                        sb = sb.append("IV");
                        break;
                    case 7:
                        sb = sb.append("IIV");
                        break;
                    case 8:
                        sb = sb.append("IIIV");
                        break;
                    case 9:
                        sb = sb.append("XI");
                        break;

                }
            }
            if(i == 1){
                switch (numm[i]) {
                    case 1:
                        sb = sb.append("X");
                        break;
                    case 2:
                        sb = sb.append("XX");
                        break;
                    case 3:
                        sb = sb.append("XXX");
                        break;
                    case 4:
                        sb = sb.append("LX");
                        break;
                    case 5:
                        sb = sb.append("L");
                        break;
                    case 6:
                        sb = sb.append("XL");
                        break;
                    case 7:
                        sb = sb.append("XXL");
                        break;
                    case 8:
                        sb = sb.append("XXXL");
                        break;
                    case 9:
                        sb = sb.append("CX");
                        break;

                }
            }
            if(i == 2){
                switch (numm[i]) {
                    case 1:
                        sb = sb.append("C");
                        break;
                    case 2:
                        sb = sb.append("CC");
                        break;
                    case 3:
                        sb = sb.append("CCC");
                        break;
                    case 4:
                        sb = sb.append("DC");
                        break;
                    case 5:
                        sb = sb.append("D");
                        break;
                    case 6:
                        sb = sb.append("CD");
                        break;
                    case 7:
                        sb = sb.append("CCD");
                        break;
                    case 8:
                        sb = sb.append("CCCD");
                        break;
                    case 9:
                        sb = sb.append("MC");
                        break;

                }
            }
            if(i == 3){
                switch (numm[i]) {
                    case 1:
                        sb = sb.append("M");
                        break;
                    case 2:
                        sb = sb.append("MM");
                        break;
                    case 3:
                        sb = sb.append("MMM");
                        break;
                }
            }


        }
        return sb.reverse().toString();
    }
}
