package leetcode;

/*  468. Validate IP Address    */

/*  https://leetcode.com/problems/validate-ip-address/  */


/*
*Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.

IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.

IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).

However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.

Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.



Example 1:

Input: IP = "172.16.254.1"
Output: "IPv4"
Explanation: This is a valid IPv4 address, return "IPv4".
Example 2:

Input: IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
Output: "IPv6"
Explanation: This is a valid IPv6 address, return "IPv6".
Example 3:

Input: IP = "256.256.256.256"
Output: "Neither"
Explanation: This is neither a IPv4 address nor a IPv6 address.


Constraints:

IP consists only of English letters, digits and the characters "." and ":".
*
*
* */


public class ValidateIPAddress {
    public String validIPAddress(String IP) {

        if(IP == null ||IP.length()==0) return "Neither";

        if(IP.contains(".")) return checkIPV4(IP);
        else if(IP.contains(":")) return checkIPV6(IP);

        return "Neither";
    }

    private String checkIPV6(String IP) {

        String N = "Neither";

        if(IP.charAt(IP.length()-1) == ':') return N;

        String [] segments = IP.split(":");

        if(segments.length!=8) return N;

        for(String segment: segments){

            if(segment.length() ==0 ||segment.length() >4) return N;

            for(int i=0;i<segment.length();i++){
                char c = segment.charAt(i);

                if(!(c>='0' && c <='9') && !(c>='a' && c <='f') && !(c>='A' && c <='F') ) return N;

            }
        }

        return "IPv6";
    }

    private String checkIPV4(String IP) {

        String N ="Neither";
        if(IP.charAt(0) == '.' || IP.charAt(IP.length()-1) == '.') return N;

        String [] segments = IP.split("\\.");

        if(segments.length !=4) return N;

        for(String segment: segments){
            if(segment.length() == 0 || segment.length()>3 ||(segment.charAt(0)=='0' && segment.length()>1)) return N;

            for(int i=0;i<segment.length();i++){
                if(segment.charAt(i)<'0' || segment.charAt(i)>'9') return N;
            }

            if(Integer.valueOf(segment)>255) return N;

        }
        return "IPv4";
    }
}
