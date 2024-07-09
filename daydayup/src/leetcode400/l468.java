package leetcode400;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class l468 {
    public String validIPAddress(String queryIP) {

        //我觉得现实应用中肯定是用正则表达式做的,,
        String validIpv4 = "^(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)){3}$";
        //正则表达式  | 或   25x , 2xx , 1xx, xx,  (.  ){3}
        Matcher matcherIpv4 = Pattern.compile(validIpv4).matcher(queryIP);
        if(matcherIpv4.matches()){
            return "IPv4";
        }
        String validIpv6 = "^([0-9a-fA-F]{1,4})(:[0-9a-fA-F]{1,4}){7}$";
        Matcher matcherIpv6 = Pattern.compile(validIpv6).matcher(queryIP);
        if(matcherIpv6.matches()){
            return "IPv6";
        }
        return "Neither";
    }
}
